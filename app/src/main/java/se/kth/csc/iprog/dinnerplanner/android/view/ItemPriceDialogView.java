package se.kth.csc.iprog.dinnerplanner.android.view;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import se.kth.csc.iprog.dinnerplanner.android.R;

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
    public ItemPriceDialogView(View view){
        this.view = view;

        txtDishName = (TextView)view.findViewById(R.id.txtDishName);
        txtDishCost = (TextView)view.findViewById(R.id.txtDishCost);
        txtTotalDishCost = (TextView)view.findViewById(R.id.txttotalDishCost);

        imgDish = (ImageView)view.findViewById(R.id.imgDish);

        txtDishName.setText("Crostini");
        txtDishCost.setText("20 Kr / Person");
        txtTotalDishCost.setText("Cost: 80 Kr");

        imgDish.setBackgroundResource(R.drawable.crostini);
    }
}
