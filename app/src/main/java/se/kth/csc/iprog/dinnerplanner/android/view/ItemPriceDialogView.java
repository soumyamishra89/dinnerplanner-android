package se.kth.csc.iprog.dinnerplanner.android.view;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import se.kth.csc.iprog.dinnerplanner.model.Ingredient;

/**
 * Created by Adnan Sakel on 2/13/2016.
 */
public class ItemPriceDialogView {
    View view;
    TextView txtDishName;
    TextView txtDishCost;
    TextView txtTotalDishCost;

    ImageView imgDish;

    Button btnChoose;
    public ItemPriceDialogView(final View view, Dish dish, Integer noOfGuests){
        this.view = view;

        txtDishName = (TextView)view.findViewById(R.id.txtDishName);
        txtDishCost = (TextView)view.findViewById(R.id.txtDishCost);
        txtTotalDishCost = (TextView)view.findViewById(R.id.txttotalDishCost);

        imgDish = (ImageView)view.findViewById(R.id.imgDish);

        float price = 0;
        for(Ingredient ing : dish.getIngredients()){
            price += ing.getPrice();
        }
        txtDishName.setText(dish.getName());
        txtDishCost.setText(price +" Kr / Person");
        txtTotalDishCost.setText("Cost: " + price * noOfGuests + " Kr");

        imgDish.setBackgroundResource(dish.getImage());


    }
}
