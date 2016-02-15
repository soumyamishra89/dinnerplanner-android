package se.kth.csc.iprog.dinnerplanner.android.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Iterator;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

/**
 * Created by Adnan Sakel on 2/14/2016.
 */
public class Instructions1View {

    View view;

    TextView txtTotalCost;
    TextView txtCookingInstruction;

    TextView txtDishName_1;
    TextView txtDishName_2;
    TextView txtDishName_3;



    ImageView imgInstructionDish_1;
    ImageView imgInstructionDish_2;
    ImageView imgInstructionDish_3;

    public Instructions1View(View view, DinnerModel dinnerModel){
        this.view = view;

        txtTotalCost = (TextView)view.findViewById(R.id.txtTotalCost);

        txtDishName_1 = (TextView)view.findViewById(R.id.txtNameDish_1);
        txtDishName_2 = (TextView)view.findViewById(R.id.txtNameDish_2);
        txtDishName_3 = (TextView)view.findViewById(R.id.txtNameDish_3);
        txtCookingInstruction = (TextView)view.findViewById(R.id.txtCookingInstruction);

        imgInstructionDish_1 = (ImageView)view.findViewById(R.id.imgInstructionDish_1);
        imgInstructionDish_2 = (ImageView)view.findViewById(R.id.imgInstructionDish_2);
        imgInstructionDish_3 = (ImageView)view.findViewById(R.id.imgInstructionDish_3);

        txtTotalCost.setText(Float.toString(dinnerModel.getTotalMenuPrice()));

        Dish dish = dinnerModel.getDishes().get(0);
        txtDishName_1.setText(dish.getName());
        txtCookingInstruction.setText(dish.getDescription());
        dish = dinnerModel.getDishes().get(1);
        txtDishName_2.setText(dish.getName());
        txtDishName_3.setText("");

        imgInstructionDish_1.setBackgroundResource(R.drawable.crostini);
        imgInstructionDish_2.setBackgroundResource(R.drawable.chicken);

        txtCookingInstruction.setText(R.string.ins_crostini);

    }
}
