package se.kth.csc.iprog.dinnerplanner.android;

import android.app.Activity;
import android.app.Application;
import android.app.ProgressDialog;

import se.kth.csc.iprog.dinnerplanner.model.BigOvenDataFetch;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

public class DinnerPlannerApplication extends Application {
	
	private DinnerModel dinnerModel = new DinnerModel();

	private BigOvenDataFetch bigOvenDataFetch;// = new BigOvenDataFetch(getDinnerModel());

	public DinnerModel getDinnerModel(){
		return dinnerModel;
	}

	public void setDinnerModel(DinnerModel dinnerModel){
		this.dinnerModel = dinnerModel;
	}

	public BigOvenDataFetch getBigOvenDataFetch( ProgressDialog mprogressdialog, Activity activity){

		bigOvenDataFetch = new BigOvenDataFetch(getDinnerModel());
		this.bigOvenDataFetch.mprogressdialog = mprogressdialog;
		this.bigOvenDataFetch.activity = activity;
		return bigOvenDataFetch;
	}

	public void setBigOvenDataFetch(BigOvenDataFetch bigOvenDataFetch){
		this.bigOvenDataFetch = bigOvenDataFetch;

	}
}
