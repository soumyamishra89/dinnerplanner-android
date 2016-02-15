package se.kth.csc.iprog.dinnerplanner.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import se.kth.csc.iprog.dinnerplanner.android.view.ExampleView;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.IDinnerModel;


/**
 * Created by Adnan Sakel on 2/13/2016.
 */
public class ExampleActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Default call to load previous state
        super.onCreate(savedInstanceState);

        // Set the view for the main activity screen
        // it must come before any call to findViewById method
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        DinnerModel model = ((DinnerPlannerApplication) this.getApplication()).getDinnerModel( );

        // Creating the view class instance
        ExampleView mainView = new ExampleView(findViewById(R.id.this_is_example_view_id), model);

        TextView txtPrice = (TextView)findViewById(R.id.example_text);

        txtPrice.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == findViewById(R.id.example_text)){
            startActivity(new Intent(ExampleActivity.this,HomeActivity.class));
        }
    }
}
