package se.kth.csc.iprog.dinnerplanner.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import se.kth.csc.iprog.dinnerplanner.android.view.Instructions2View;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

/**
 * Created by SOMU on 15/02/16.
 */
public class Instructions2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Default call to load previous state
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);// For removing the default title bar
        // Set the view for the main activity screen
        // it must come before any call to findViewById method
        setContentView(R.layout.instruction_view);

        DinnerModel dinnerModel=((DinnerPlannerApplication)this.getApplication()).getDinnerModel();
        // Creating the view class instance
        Instructions2View mainView = new Instructions2View(findViewById(R.id.view_activity_instructions), dinnerModel);
    }
}
