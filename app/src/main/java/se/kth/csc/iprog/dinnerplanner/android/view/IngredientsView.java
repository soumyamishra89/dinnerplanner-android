package se.kth.csc.iprog.dinnerplanner.android.view;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import se.kth.csc.iprog.dinnerplanner.model.Ingredient;

/**
 * Created by Adnan Sakel on 2/14/2016.
 */
public class IngredientsView implements Observer {
    View view;
    DinnerModel dinnerModel;
    TextView txtTotalCost;


    TextView txtIngredient;

    TextView txtIngredient_amount;


    TextView txtNumberofPersons;
    TextView txtIngredientsTitle;
    LinearLayout llDishes;
    LinearLayout llingerdientDetails;
    LinearLayout llborderColor_ingredients;

    LayoutInflater layoutInflater;
    LinearLayout.LayoutParams layoutParams;

    public IngredientsView(View view, DinnerModel dinnerModel){

        dinnerModel.addObserver(this);
        this.view = view;
        this.dinnerModel = dinnerModel;

        layoutInflater = (LayoutInflater) view.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(5, 0, 5, 0);

        txtTotalCost = (TextView)view.findViewById(R.id.txtTotalCost);

        txtNumberofPersons = (TextView)view.findViewById(R.id.txtNumberofPerson);
        txtIngredientsTitle = (TextView)view.findViewById(R.id.txtingredientsTitle);


        llDishes = (LinearLayout)view.findViewById(R.id.lldishes);
        llingerdientDetails = (LinearLayout)view.findViewById(R.id.llingredientdetails);

        llborderColor_ingredients = (LinearLayout)view.findViewById(R.id.llborderColor_ingredients);

    }

    public void loadIngredients(){
        //int i = 0;
        //llDishes.removeAllViews();
        llingerdientDetails.removeAllViews();
        for(int i = 0; i < llDishes.getChildCount();i++) {

            ((LinearLayout) llDishes.getChildAt(i).findViewById(R.id.llborderColor)).setBackgroundColor(Color.parseColor("#00800000"));

        }
        //llborderColor_ingredients.setBackgroundColor(Color.parseColor("#800000"));
       for(Dish dish: dinnerModel.getDishes()){

           for (Ingredient ing : dish.getIngredients()) {

               View ingtredientsItemView = layoutInflater.inflate(R.layout.ingredients_item_view,null);
               TextView txtingredientName = (TextView)ingtredientsItemView.findViewById(R.id.txtIngredientName);
               TextView txtingredientUnit = (TextView)ingtredientsItemView.findViewById(R.id.txtIngredientUnit);
               TextView txtingredientqty = (TextView)ingtredientsItemView.findViewById(R.id.txtIngredientqty);
               txtingredientName.setText(ing.getName());
               txtingredientqty.setText(Double.toString(ing.getQuantity() * dinnerModel.getNumberOfGuests()));
               txtingredientUnit.setText(ing.getUnit());
               llingerdientDetails.addView(ingtredientsItemView);
           }
       }
    }

    @Override
    public void update(Observable observable, Object o) {
        if(observable instanceof  DinnerModel){
            DinnerModel odinnermodel = (DinnerModel)observable;

            txtTotalCost.setText(Float.toString(dinnerModel.getTotalMenuPrice()));
            txtNumberofPersons.setText(""+dinnerModel.getNumberOfGuests());

            int i = 0;
            llDishes.removeAllViews();
            llingerdientDetails.removeAllViews();
            //llborderColor_ingredients.setBackgroundColor(Color.parseColor("#800000"));
            for(Dish dish: odinnermodel.getDishes()){
                View instructionsItemView = layoutInflater.inflate(R.layout.instruction_item_view,null);
                instructionsItemView.setTag(i++);
                ImageView imgInstructionDish = (ImageView)instructionsItemView.findViewById(R.id.imgInstructionDish);
                TextView txtDishName = (TextView)instructionsItemView.findViewById(R.id.txtNameDish);
                imgInstructionDish.setBackgroundResource(dish.getImage());
                txtDishName.setText(dish.getName());
                instructionsItemView.setOnClickListener(new InstructionOnClickListener());
                llDishes.addView(instructionsItemView);


                for (Ingredient ing : dish.getIngredients()) {

                    View ingtredientsItemView = layoutInflater.inflate(R.layout.ingredients_item_view,null);
                    TextView txtingredientName = (TextView)ingtredientsItemView.findViewById(R.id.txtIngredientName);
                    TextView txtingredientUnit = (TextView)ingtredientsItemView.findViewById(R.id.txtIngredientUnit);
                    TextView txtingredientqty = (TextView)ingtredientsItemView.findViewById(R.id.txtIngredientqty);
                    txtingredientName.setText(ing.getName());
                    txtingredientqty.setText(Double.toString(ing.getQuantity()*odinnermodel.getNumberOfGuests()));
                    txtingredientUnit.setText(ing.getUnit());
                    llingerdientDetails.addView(ingtredientsItemView);
                }
            }

        }

    }

    public class InstructionOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            llingerdientDetails.removeAllViews();
            txtIngredientsTitle.setVisibility(View.GONE);
            txtNumberofPersons.setVisibility(View.GONE);
            llborderColor_ingredients.setBackgroundColor(Color.parseColor("#00800000"));
            View instructionDescription = layoutInflater.inflate(R.layout.instruction_description_view,null);
            TextView txtDishName = (TextView)instructionDescription.findViewById(R.id.txtDishName);
            TextView txtDishType = (TextView)instructionDescription.findViewById(R.id.txtDishType);
            TextView txtCookingInstruction = (TextView)instructionDescription.findViewById(R.id.txtCookingInstruction);
            String name = ((TextView)view.findViewById(R.id.txtNameDish)).getText().toString();

            String type = "";
            for(Dish dish: dinnerModel.getDishes()){
                if(dish.getName().equals(name)){
                    txtDishName.setText(name);
                    if(dish.getType()==1){type = "Starter";}
                    else if(dish.getType()==2){type = "Main";}
                    else if(dish.getType()==3){type = "Dessert";}
                    txtDishType.setText(type);
                    txtCookingInstruction.setText(dish.getDescription());

                }

            }
            llingerdientDetails.addView(instructionDescription);
            View tempview;
            for(int i = 0; i < llDishes.getChildCount();i++){
                if(llDishes.getChildAt(i)==view){
                    ((LinearLayout)view.findViewById(R.id.llborderColor)).setBackgroundColor(Color.parseColor("#800000"));
                }
                else {
                    tempview = llDishes.getChildAt(i);
                    ((LinearLayout)tempview.findViewById(R.id.llborderColor)).setBackgroundColor(Color.parseColor("#00800000"));
                }
            }
        }
    }

}
