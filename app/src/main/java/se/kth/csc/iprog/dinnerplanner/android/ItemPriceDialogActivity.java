package se.kth.csc.iprog.dinnerplanner.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import se.kth.csc.iprog.dinnerplanner.android.view.ItemPriceDialogView;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

/**
 * Created by Adnan Sakel on 2/13/2016.
 */
public class ItemPriceDialogActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Default call to load previous state
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);// For removing the default title bar
        // Set the view for the main activity screen
        // it must come before any call to findViewById method
        setContentView(R.layout.item_price_dialog);

        final DinnerModel dinnerModel = ((DinnerPlannerApplication) getApplication()).getDinnerModel();
        final Dish selectedDish = (Dish) getIntent().getExtras().get(Dish.EXTRA_DISH);
        Integer noOfGuests = getIntent().getIntExtra(Intent.EXTRA_TEXT, 0);
        // Creating the view class instance
        ItemPriceDialogView mainView = new ItemPriceDialogView(findViewById(R.id.view_dialog_activity_item_price), selectedDish, noOfGuests, ItemPriceDialogActivity.this);
        findViewById(R.id.imgCross).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                finish();
            }
        });

        findViewById(R.id.btnChoose).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dinnerModel.addDishToMenu(selectedDish);
                finish();
            }
        });
    }
}
