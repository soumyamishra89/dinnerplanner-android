package se.kth.csc.iprog.dinnerplanner.android.view;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.IMenuModel;

import static android.graphics.drawable.Drawable.*;

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

    TextView starter;
    TextView main;
    TextView dessert;

    Button btnCreate;

    public MainView(View view, IMenuModel menuModel, DinnerModel dinnerModel){

        int itemPos=0;
        this.view = view;

        txtNumberofGuests = (TextView)view.findViewById(R.id.txtNumberofGuests);
        txtTotalCost = (TextView)view.findViewById(R.id.txtTotalCost);
        txtStarterItem_1 = (TextView)view.findViewById(R.id.txtStarterItem_1);
        txtStarterItem_1.setText(menuModel.getAllMenuItems().get(itemPos).getName());
        imgStarterItem_1 = (ImageView)view.findViewById(R.id.imgStarterItem_1);
        imgStarterItem_1.setBackgroundResource(menuModel.getAllMenuItems( ).get(itemPos).getImage( ));

        txtStarterItem_2 = (TextView)view.findViewById(R.id.txtStarterItem_2);
        txtStarterItem_2.setText(menuModel.getAllMenuItems( ).get(++itemPos).getName( ));
        imgStarterItem_2 = (ImageView)view.findViewById(R.id.imgStarterItem_2);
        imgStarterItem_2.setBackgroundResource(menuModel.getAllMenuItems( ).get(itemPos).getImage( ));

        txtStarterItem_3 = (TextView)view.findViewById(R.id.txtStarterItem_3);
        txtStarterItem_3.setText(menuModel.getAllMenuItems( ).get(++itemPos).getName( ));
        imgStarterItem_3 = (ImageView)view.findViewById(R.id.imgStarterItem_3);
        imgStarterItem_3.setBackgroundResource(menuModel.getAllMenuItems( ).get(itemPos).getImage( ));

        txtMainCourseItem_1 = (TextView)view.findViewById(R.id.txtMainCourseItem_1);
        txtMainCourseItem_1.setText(menuModel.getAllMenuItems( ).get(++itemPos).getName( ));
        imgMainCourseItem_1 = (ImageView)view.findViewById(R.id.imgMainCourseItem_1);
        imgMainCourseItem_1.setBackgroundResource(menuModel.getAllMenuItems( ).get(itemPos).getImage( ));

        txtMainCourseItem_2 = (TextView)view.findViewById(R.id.txtMainCourseItem_2);
        txtMainCourseItem_2.setText(menuModel.getAllMenuItems( ).get(++itemPos).getName( ));
        imgMainCourseItem_2 = (ImageView)view.findViewById(R.id.imgMainCourseItem_2);
        imgMainCourseItem_2.setBackgroundResource(menuModel.getAllMenuItems( ).get(itemPos).getImage( ));

        txtMainCourseItem_3 = (TextView)view.findViewById(R.id.txtMainCourseItem_3);
        txtMainCourseItem_3.setText(menuModel.getAllMenuItems( ).get(++itemPos).getName( ));
        imgMainCourseItem_3 = (ImageView)view.findViewById(R.id.imgMainCourseItem_3);
        imgMainCourseItem_3.setBackgroundResource(menuModel.getAllMenuItems( ).get(itemPos).getImage( ));

        txtMainCourseItem_4 = (TextView)view.findViewById(R.id.txtMainCourseItem_4);
        txtMainCourseItem_4.setText(menuModel.getAllMenuItems( ).get(++itemPos).getName( ));
        imgMainCourseItem_4 = (ImageView)view.findViewById(R.id.imgMainCourseItem_4);
        imgMainCourseItem_4.setBackgroundResource(menuModel.getAllMenuItems( ).get(itemPos).getImage( ));

        txtDessertItem_1 = (TextView)view.findViewById(R.id.txtDessertItem_1);
        txtDessertItem_1.setText(menuModel.getAllMenuItems( ).get(++itemPos).getName( ));
        imgDessertItem_1 = (ImageView)view.findViewById(R.id.imgDessertItem_1);
        imgDessertItem_1.setBackgroundResource(menuModel.getAllMenuItems( ).get(itemPos).getImage( ));

        txtDessertItem_2 = (TextView)view.findViewById(R.id.txtDessertItem_2);
        txtDessertItem_2.setText(menuModel.getAllMenuItems( ).get(++itemPos).getName( ));
        imgDessertItem_2 = (ImageView)view.findViewById(R.id.imgDessertItem_2);
        imgDessertItem_2.setBackgroundResource(menuModel.getAllMenuItems( ).get(itemPos).getImage( ));

        starter = (TextView) view.findViewById(R.id.starter);
        starter.setText(menuModel.getStarterText( ));

        main = (TextView) view.findViewById(R.id.maincourse);
        main.setText(menuModel.getMainText( ));

        dessert = (TextView) view.findViewById(R.id.dessert);
        dessert.setText(menuModel.getDessertText());

        btnCreate = (Button)view.findViewById(R.id.btnCreate);

        txtNumberofGuests.setText(Integer.toString(dinnerModel.getNumberOfGuests()));
        txtTotalCost.setText("Total cost: "+ Float.toString(dinnerModel.getTotalMenuPrice()));

        //You can set others using model


    }
}
