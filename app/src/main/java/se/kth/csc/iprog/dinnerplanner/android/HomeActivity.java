package se.kth.csc.iprog.dinnerplanner.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import se.kth.csc.iprog.dinnerplanner.android.view.HomeView;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

/**
 * Created by Adnan Sakel on 2/13/2016.
 */
public class HomeActivity extends Activity implements  View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Default call to load previous state
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);// For removing the default title bar
        // Set the view for the main activity screen
        // it must come before any call to findViewById method
        setContentView(R.layout.activity_home);

        DinnerModel dinnerModel=((DinnerPlannerApplication) this.getApplication()).getDinnerModel();

        dinnerModel.setNumberOfGuests(4);
        dinnerModel.getDishes().clear();

        //((DinnerPlannerApplication) this.getApplication()).getBigOvenDataFetch().execute("20");
        // Creating the view class instance
        HomeView mainView = new HomeView(findViewById(R.id.view_activity_home));

        findViewById(R.id.btnStart).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == findViewById(R.id.btnStart))
            startActivity(new Intent(HomeActivity.this,MainActivity.class));
    }
}
