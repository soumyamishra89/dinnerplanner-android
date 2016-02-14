package se.kth.csc.iprog.dinnerplanner.android.view;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import se.kth.csc.iprog.dinnerplanner.android.R;

/**
 * Created by Adnan Sakel on 2/13/2016.
 */
public class MainView {
    View view;
    TextView txtTotalCost;
    //TextView txtSearchMenu;
    TextView txtNumberofGuests;

    ImageView imgStarterItem_1;
    ImageView imgStarterItem_2;
    ImageView imgStarterItem_3;
    ImageView imgDessertItem_1;
    ImageView imgDessertItem_2;
    ImageView imgMainCourseItem_1;
    ImageView imgMainCourseItem_2;
    ImageView imgMainCourseItem_3;
    ImageView imgMainCourseItem_4;

    TextView txtStarterItem_1;
    TextView txtStarterItem_2;
    TextView txtStarterItem_3;
    TextView txtMainCourseItem_1;
    TextView txtMainCourseItem_2;
    TextView txtMainCourseItem_3;
    TextView txtMainCourseItem_4;
    TextView txtDessertItem_1;
    TextView txtDessertItem_2;

    Button btnCreate;

    public MainView(View view){

        this.view = view;

        txtNumberofGuests = (TextView)view.findViewById(R.id.txtNumberofGuests);
        txtTotalCost = (TextView)view.findViewById(R.id.txtTotalCost);
        txtStarterItem_1 = (TextView)view.findViewById(R.id.txtStarterItem_1);
        txtStarterItem_2 = (TextView)view.findViewById(R.id.txtStarterItem_2);
        txtStarterItem_3 = (TextView)view.findViewById(R.id.txtStarterItem_3);
        txtMainCourseItem_1 = (TextView)view.findViewById(R.id.txtMainCourseItem_1);
        txtMainCourseItem_2 = (TextView)view.findViewById(R.id.txtMainCourseItem_2);
        txtMainCourseItem_3 = (TextView)view.findViewById(R.id.txtMainCourseItem_3);
        txtMainCourseItem_4 = (TextView)view.findViewById(R.id.txtMainCourseItem_4);
        txtDessertItem_1 = (TextView)view.findViewById(R.id.txtDessertItem_1);
        txtDessertItem_2 = (TextView)view.findViewById(R.id.txtDessertItem_2);

        imgStarterItem_1 = (ImageView)view.findViewById(R.id.imgStarterItem_1);
        imgStarterItem_2 = (ImageView)view.findViewById(R.id.imgStarterItem_2);
        imgStarterItem_3 = (ImageView)view.findViewById(R.id.imgStarterItem_3);
        imgMainCourseItem_1 = (ImageView)view.findViewById(R.id.imgMainCourseItem_1);
        imgMainCourseItem_2 = (ImageView)view.findViewById(R.id.imgMainCourseItem_2);
        imgMainCourseItem_3 = (ImageView)view.findViewById(R.id.imgMainCourseItem_3);
        imgMainCourseItem_4 = (ImageView)view.findViewById(R.id.imgMainCourseItem_4);
        imgDessertItem_1 = (ImageView)view.findViewById(R.id.imgDessertItem_1);
        imgDessertItem_2 = (ImageView)view.findViewById(R.id.imgDessertItem_2);

        btnCreate = (Button)view.findViewById(R.id.btnCreate);


        txtNumberofGuests.setText("4");
        txtTotalCost.setText("Total Cost: 0 Kr");
        txtStarterItem_1.setText("Crostini");
        imgStarterItem_1.setBackgroundResource(R.drawable.crostini);
        //You can set others using model


    }
}
