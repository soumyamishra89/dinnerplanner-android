package se.kth.csc.iprog.dinnerplanner.android;

import android.app.Application;

import se.kth.csc.iprog.dinnerplanner.model.BigOvenDataFetch;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

public class DinnerPlannerApplication extends Application {
	
	private DinnerModel dinnerModel = new DinnerModel();

	private BigOvenDataFetch bigOvenDataFetch = new BigOvenDataFetch(getDinnerModel());

	public DinnerModel getDinnerModel(){
		return dinnerModel;
	}

	public void setDinnerModel(DinnerModel dinnerModel){
		this.dinnerModel = dinnerModel;
	}

	public BigOvenDataFetch getBigOvenDataFetch( ){
		return bigOvenDataFetch;
	}

	public void setBigOvenDataFetch(BigOvenDataFetch bigOvenDataFetch){
		this.bigOvenDataFetch = bigOvenDataFetch;
	}
}
