package se.kth.csc.iprog.dinnerplanner.android.view;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.IHomeModel;

/**
 * Created by Adnan Sakel on 2/13/2016.
 */
public class HomeView {
    View view;
    Button btnStart;
    TextView txtAppDescription;

    public HomeView(View view, IHomeModel homeModel){
        this.view = view;
        btnStart = (Button)view.findViewById(R.id.btnStart);
        txtAppDescription = (TextView)view.findViewById(R.id.txtAppDescription);
        btnStart.setText(homeModel.getStartText());
        txtAppDescription.setText(homeModel.getHomeViewText());
    }
}
