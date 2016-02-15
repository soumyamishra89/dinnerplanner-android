package se.kth.csc.iprog.dinnerplanner.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import se.kth.csc.iprog.dinnerplanner.android.view.HomeView;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.IHomeModel;
import se.kth.csc.iprog.dinnerplanner.model.IMenuModel;

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

        IHomeModel homeModel=((DinnerPlannerApplication) this.getApplication()).getHomeModel();
        homeModel.setStartText("Start");
        homeModel.setHomeViewText(getString(R.string.app_desc));
        DinnerModel dinnerModel=((DinnerPlannerApplication) this.getApplication()).getDinnerModel();
        IMenuModel menuModel = ((DinnerPlannerApplication) this.getApplication()).getMenuModel();
        menuModel.setDessertText(getString(R.string.dessert_text));
        menuModel.setMainText(getString(R.string.main_text));
        menuModel.setStarterText(getString(R.string.starter_text));

        dinnerModel.setNumberOfGuests(4);
        dinnerModel.addDishToMenu(menuModel.getAllMenuItems( ).get(1));
        dinnerModel.addDishToMenu(menuModel.getAllMenuItems( ).get(3));
        // Creating the view class instance
        HomeView mainView = new HomeView(findViewById(R.id.view_activity_home), homeModel);

        findViewById(R.id.header).setOnClickListener(this);
        findViewById(R.id.btnStart).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(HomeActivity.this,MainActivity.class));
    }
}
