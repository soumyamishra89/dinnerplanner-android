package se.kth.csc.iprog.dinnerplanner.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import se.kth.csc.iprog.dinnerplanner.android.view.ExampleView;
import se.kth.csc.iprog.dinnerplanner.android.view.MainView;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.IDinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.IMenuModel;


public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Default call to load previous state
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);// For removing the default title bar
        // Set the view for the main activity screen
        // it must come before any call to findViewById method
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.main_view);
        DinnerModel dinnerModel=((DinnerPlannerApplication) this.getApplication()).getDinnerModel();
        IMenuModel menuModel = ((DinnerPlannerApplication) this.getApplication()).getMenuModel();

        // Creating the view class instance
        MainView mainView = new MainView(findViewById(R.id.view_activity_main), menuModel, dinnerModel);

        findViewById(R.id.header).setOnClickListener(this);
        findViewById(R.id.btnCreate).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == findViewById(R.id.header)){
            startActivity(new Intent(MainActivity.this,IngredientsActivity.class));
        }

        if(view == findViewById(R.id.btnCreate)){
            startActivity(new Intent(MainActivity.this,ItemPriceDialogActivity.class));
        }
    }
}
