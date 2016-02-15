package se.kth.csc.iprog.dinnerplanner.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import se.kth.csc.iprog.dinnerplanner.android.view.Instructions1View;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

/**
 * Created by Adnan Sakel on 2/14/2016.
 */
public class Instructions1Activity extends Activity implements View.OnClickListener{

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
        Instructions1View mainView = new Instructions1View(findViewById(R.id.view_activity_instructions), dinnerModel);
        findViewById(R.id.header).setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        startActivity(new Intent(Instructions1Activity.this,Instructions2Activity.class));
    }
}
