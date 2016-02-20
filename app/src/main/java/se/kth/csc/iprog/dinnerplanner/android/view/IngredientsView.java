package se.kth.csc.iprog.dinnerplanner.android.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

/**
 * Created by Adnan Sakel on 2/14/2016.
 */
public class IngredientsView {
    View view;

    TextView txtTotalCost;
    TextView txtDishName_1;
    TextView txtDishName_2;
    TextView txtDishName_3;

    TextView txtIngredient_1;
    TextView txtIngredient_2;
    TextView txtIngredient_3;
    TextView txtIngredient_4;
    TextView txtIngredient_5;

    TextView txtIngredient_1_amount;
    TextView txtIngredient_2_amount;
    TextView txtIngredient_3_amount;
    TextView txtIngredient_4_amount;
    TextView txtIngredient_5_amount;

    TextView txtNumberofPersons;

    ImageView imgInstructionDish_1;
    ImageView imgInstructionDish_2;
    ImageView imgInstructionDish_3;

    public IngredientsView(View view, DinnerModel dinnerModel){
        this.view = view;

        txtTotalCost = (TextView)view.findViewById(R.id.txtTotalCost);

        txtTotalCost.setText(Float.toString(dinnerModel.getTotalMenuPrice()));

        txtDishName_1 = (TextView)view.findViewById(R.id.txtNameDish_1);
        txtDishName_2 = (TextView)view.findViewById(R.id.txtNameDish_2);
        txtDishName_3 = (TextView)view.findViewById(R.id.txtNameDish_3);

        txtIngredient_1 = (TextView)view.findViewById(R.id.txtIngredient_1);
        txtIngredient_2 = (TextView)view.findViewById(R.id.txtIngredient_2);
        txtIngredient_3 = (TextView)view.findViewById(R.id.txtIngredient_3);
        txtIngredient_4 = (TextView)view.findViewById(R.id.txtIngredient_4);
        txtIngredient_5 = (TextView)view.findViewById(R.id.txtIngredient_5);

        txtIngredient_1_amount = (TextView)view.findViewById(R.id.txtIngredient_1_amount);
        txtIngredient_2_amount = (TextView)view.findViewById(R.id.txtIngredient_2_amount);
        txtIngredient_3_amount = (TextView)view.findViewById(R.id.txtIngredient_3_amount);
        txtIngredient_4_amount = (TextView)view.findViewById(R.id.txtIngredient_4_amount);
        txtIngredient_5_amount = (TextView)view.findViewById(R.id.txtIngredient_5_amount);

        txtNumberofPersons = (TextView)view.findViewById(R.id.txtNumberofPerson);

        imgInstructionDish_1 = (ImageView)view.findViewById(R.id.imgInstructionDish_1);
        imgInstructionDish_2 = (ImageView)view.findViewById(R.id.imgInstructionDish_2);
        imgInstructionDish_3 = (ImageView)view.findViewById(R.id.imgInstructionDish_3);


        txtTotalCost.setText(Float.toString(dinnerModel.getTotalMenuPrice()));

//        Dish dish = dinnerModel.getDishes().get(0);
//        txtDishName_1.setText(dish.getName( ));
//        imgInstructionDish_1.setBackgroundResource(dish.getImage( ));
//
//        dish=dinnerModel.getDishes().get(1);
//        txtDishName_2.setText(dish.getName( ));
//        imgInstructionDish_2.setBackgroundResource(dish.getImage( ));
//        txtDishName_3.setText("");
//
//        dish = dinnerModel.getDishes().get(0);
//        Iterator<Ingredient> ingIterator=dish.getIngredients().iterator();
//
//        Ingredient ing=ingIterator.next();
//        txtIngredient_1.setText(ing.getName());
//        txtIngredient_1_amount.setText(ing.getQuantity() * dinnerModel.getNumberOfGuests() + " " + ing.getUnit());
//
//        ing=ingIterator.next();
//        txtIngredient_2.setText(ing.getName());
//        txtIngredient_2_amount.setText(ing.getQuantity() * dinnerModel.getNumberOfGuests()+ " " + ing.getUnit());
//
//        ing=ingIterator.next();
//        txtIngredient_3.setText(ing.getName());
//        txtIngredient_3_amount.setText(ing.getQuantity() * dinnerModel.getNumberOfGuests()+ " " + ing.getUnit());
//
//        dish = dinnerModel.getDishes().get(1);
//        ingIterator=dish.getIngredients().iterator();
//        ing =ingIterator.next( );
//        txtIngredient_4.setText(ing.getName( ));
//        txtIngredient_4_amount.setText(ing.getQuantity() * dinnerModel.getNumberOfGuests()+ " " + ing.getUnit());
//
//        ing=ingIterator.next();
//        txtIngredient_5.setText(ing.getName());
//        txtIngredient_5_amount.setText(ing.getQuantity() * dinnerModel.getNumberOfGuests() + " " + ing.getUnit());
//



    }

}
