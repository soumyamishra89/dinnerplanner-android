package se.kth.csc.iprog.dinnerplanner.android;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import se.kth.csc.iprog.dinnerplanner.android.view.MainView;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;


public class MainActivity extends Activity  {
    public int numOfItemstoLoad = 20;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Default call to load previous state
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);// For removing the default title bar
        // Set the view for the main activity screen
        // it must come before any call to findViewById method
        //setContentView(R.layout.activity_main);

        setContentView(R.layout.main_view);
        final DinnerModel dinnerModel = ((DinnerPlannerApplication) this.getApplication()).getDinnerModel();
        ProgressDialog progress = new ProgressDialog(this);
        progress.setMessage("Loading...");

        ((DinnerPlannerApplication) this.getApplication()).getBigOvenDataFetch(progress, this).execute(""+numOfItemstoLoad);//sakel
        // Creating the view class instance
        MainView mainView = new MainView(findViewById(R.id.view_activity_main), dinnerModel);

        //findViewById(R.id.header).setOnClickListener(this);
        findViewById(R.id.btnCreate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btnCreate) {
                    if (!dinnerModel.getDishes().isEmpty()) {
                        startActivity(new Intent(MainActivity.this, IngredientsActivity.class));
                    } else {
                        Toast warningToast = Toast.makeText(v.getContext(), "Select some dishes", Toast.LENGTH_LONG);
                        warningToast.setGravity(Gravity.CENTER, 0, 0);
                        warningToast.show();
                    }
                }
            }
        });

        findViewById(R.id.imgbtnRefresh).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                numOfItemstoLoad += 20;
                ProgressDialog progress = new ProgressDialog(MainActivity.this);
                progress.setMessage("Loading...");
                ((DinnerPlannerApplication) MainActivity.this.getApplication()).getBigOvenDataFetch(progress, MainActivity.this).execute(""+numOfItemstoLoad);//sakel
            }
        });
    }
}
