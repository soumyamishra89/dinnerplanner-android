package se.kth.csc.iprog.dinnerplanner.android.view;

import android.view.View;
import android.widget.TextView;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

public class ExampleView {

	View view;
	DinnerModel model;

	public ExampleView(View view, DinnerModel model) {

		// store in the class the reference to the Android View
		this.view = view;
		this.model=model;
		model.setNumberOfGuests(4);

		TextView example = (TextView) view.findViewById(R.id.example_text);
		example.setText("Total price: " + this.model.getTotalMenuPrice());
		// Setup the rest of the view layout
	}

}
