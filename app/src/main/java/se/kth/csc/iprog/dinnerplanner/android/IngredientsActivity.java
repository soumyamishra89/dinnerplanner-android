package se.kth.csc.iprog.dinnerplanner.android;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

import se.kth.csc.iprog.dinnerplanner.android.view.IngredientsView;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

/**
 * Created by Adnan Sakel on 2/14/2016.
 */
public class IngredientsActivity extends Activity implements View.OnClickListener {

    IngredientsView mainView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Default call to load previous state
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);// For removing the default title bar

        // Set the view for the main activity screen
        // it must come before any call to findViewById method
        setContentView(R.layout.ingredients_view);
        DinnerModel dinnerModel=((DinnerPlannerApplication) this.getApplication()).getDinnerModel();

        // Creating the view class instance
        mainView = new IngredientsView(findViewById(R.id.view_activity_ingredients), dinnerModel);
        findViewById(R.id.imgIngredients).setOnClickListener(this);
        findViewById(R.id.llbackarrow).setOnClickListener(this);
        //mainView.update(dinnerModel,null);
        //findViewById(R.id.header).setOnClickListener(this);
        dinnerModel.setNumberOfGuests(dinnerModel.getNumberOfGuests());//Just to show that observing the model works here as well.
    }

    @Override
    public void onClick(View view) {
        //startActivity(new Intent(IngredientsActivity.this, InstructionsActivity.class));
        if(view == findViewById(R.id.llbackarrow)){
            this.finish();
        }
        else if(view == findViewById(R.id.imgIngredients)){
            mainView.loadIngredients();
            ((LinearLayout)findViewById(R.id.llborderColor_ingredients)).setBackgroundColor(Color.parseColor("#800000"));
        }

    }
}
