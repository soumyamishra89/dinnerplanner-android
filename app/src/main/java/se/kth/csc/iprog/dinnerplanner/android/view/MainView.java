package se.kth.csc.iprog.dinnerplanner.android.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import se.kth.csc.iprog.dinnerplanner.android.ItemPriceDialogActivity;
import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

/**
 * Created by Adnan Sakel on 2/13/2016.
 */
public class MainView implements Observer{

    Map<String, View> dishNameToViewMap = new HashMap<>();

    View view;

    TextView txtTotalCost;
    //TextView txtSearchMenu;
    EditText txtNumberOfGuests;

    TextChangeListener textChangeListener = new TextChangeListener();

    DinnerModel dinnerModel;

    LinearLayout starterLayout;
    LinearLayout mainLayout;
    LinearLayout dessertLayout;

    GradientDrawable borderSelected;

    LinearLayout.LayoutParams layoutParams;

    LayoutInflater layoutInflater;

    Button btnCreate;

    public MainView(View view, DinnerModel dinnerModel){

        dinnerModel.addObserver(this);
        this.dinnerModel = dinnerModel;
        this.view = view;
        layoutInflater = (LayoutInflater) view.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        txtNumberOfGuests = (EditText)view.findViewById(R.id.txtNumberofGuests);

        txtTotalCost = (TextView)view.findViewById(R.id.txtTotalCost);
        starterLayout = (LinearLayout) view.findViewById(R.id.llStarter);
        mainLayout = (LinearLayout) view.findViewById(R.id.llMainCourse);
        dessertLayout = (LinearLayout) view.findViewById(R.id.llDessert);

        borderSelected = new GradientDrawable();
        borderSelected.setColor(Color.parseColor("#800000"));
        //borderSelected.setStroke(4, Color.parseColor("#800000"));
        layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(5, 0, 5, 0);

        btnCreate = (Button)view.findViewById(R.id.btnCreate);

        txtNumberOfGuests.setText(Integer.toString(dinnerModel.getNumberOfGuests()));
        txtNumberOfGuests.addTextChangedListener(textChangeListener);
        txtTotalCost.setText(Float.toString(dinnerModel.getTotalMenuPrice()) + " Kr");

        addViewsOfDishes();

    }

    private void addViewsOfDishes(){
        // Starter menu
        for(Dish starterDish : dinnerModel.getDishesOfType(Dish.STARTER)){
            View starterView = layoutInflater.inflate(R.layout.menu_item_view, null);
            TextView dishView = (TextView) starterView.findViewById(R.id.txtDishItem);

            dishView.setText(starterDish.getName());
            ImageView dishImage = (ImageView) starterView.findViewById(R.id.imgDishItem);
            dishImage.setBackgroundResource(starterDish.getImage());

            if(dinnerModel.getDishes().contains(starterDish))
                starterView.findViewById(R.id.llMenuItem).setBackgroundDrawable(borderSelected);
            starterView.setOnClickListener(new DishOnClickListener());
            dishNameToViewMap.put(starterDish.getName(), starterView);
            starterLayout.addView(starterView, layoutParams);
        }

        // Main menu
        for(Dish mainDish : dinnerModel.getDishesOfType(Dish.MAIN)){
            View mainView = layoutInflater.inflate(R.layout.menu_item_view, null);
            TextView dishView = (TextView) mainView.findViewById(R.id.txtDishItem);
            dishView.setText(mainDish.getName());
            ImageView dishImage = (ImageView) mainView.findViewById(R.id.imgDishItem);
            dishImage.setBackgroundResource(mainDish.getImage());

            if(dinnerModel.getDishes().contains(mainDish))
                mainView.findViewById(R.id.llMenuItem).setBackgroundDrawable(borderSelected);
            mainView.setOnClickListener(new DishOnClickListener());
            dishNameToViewMap.put(mainDish.getName(), mainView);
            mainLayout.addView(mainView, layoutParams);
        }

        // Dessert menu
        for(Dish dessertDish : dinnerModel.getDishesOfType(Dish.DESERT)){
            View dessertView = layoutInflater.inflate(R.layout.menu_item_view, null);
            TextView dishView = (TextView) dessertView.findViewById(R.id.txtDishItem);
            dishView.setText(dessertDish.getName());
            ImageView dishImage = (ImageView) dessertView.findViewById(R.id.imgDishItem);
            dishImage.setBackgroundResource(dessertDish.getImage());

            if(dinnerModel.getDishes().contains(dessertDish))
                dessertView.findViewById(R.id.llMenuItem).setBackgroundDrawable(borderSelected);
            dessertView.setOnClickListener(new DishOnClickListener());
            dishNameToViewMap.put(dessertDish.getName(), dessertView);
            dessertLayout.addView(dessertView, layoutParams);
        }
    }

    @Override
    public void update(Observable observable, Object data){
        if(data instanceof Integer){
            txtNumberOfGuests.removeTextChangedListener(textChangeListener);
            txtNumberOfGuests.setText(data.toString());
            txtNumberOfGuests.addTextChangedListener(textChangeListener);

        } else if(data instanceof Dish){
            Dish dish = (Dish) data;
            if(dishNameToViewMap.containsKey(dish.getName())){
                dishNameToViewMap.get(dish.getName()).setBackgroundDrawable(borderSelected);
            }
        }
        if(observable instanceof DinnerModel){
            DinnerModel dinnerModel = (DinnerModel) observable;
            txtTotalCost.setText(Float.toString(dinnerModel.getTotalMenuPrice()) + " Kr");
        }
    }

    public class TextChangeListener implements TextWatcher{

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after){

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count){

        }

        @Override
        public void afterTextChanged(Editable s){
            dinnerModel.setNumberOfGuests(Integer.parseInt(s.toString()));
        }
    }

    public class DishOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v){
            String dishName = ((TextView)v.findViewById(R.id.txtDishItem)).getText().toString();
            Intent itemPriceIntent = new Intent(view.getContext(), ItemPriceDialogActivity.class);
            itemPriceIntent.putExtra(Dish.EXTRA_DISH, dinnerModel.getSelectedDish(dishName));
            itemPriceIntent.putExtra(Intent.EXTRA_TEXT, dinnerModel.getNumberOfGuests());
            view.getContext().startActivity(itemPriceIntent);
        }
    }
}
