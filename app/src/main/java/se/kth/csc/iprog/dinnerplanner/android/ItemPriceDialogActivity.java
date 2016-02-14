package se.kth.csc.iprog.dinnerplanner.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import se.kth.csc.iprog.dinnerplanner.android.view.ItemPriceDialogView;

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


        // Creating the view class instance
        ItemPriceDialogView mainView = new ItemPriceDialogView(findViewById(R.id.view_dialog_activity_item_price));
    }
}
