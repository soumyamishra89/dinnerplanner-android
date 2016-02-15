package se.kth.csc.iprog.dinnerplanner.android;

import android.app.Application;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.HomeModel;
import se.kth.csc.iprog.dinnerplanner.model.IDinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.IHomeModel;
import se.kth.csc.iprog.dinnerplanner.model.IMenuModel;
import se.kth.csc.iprog.dinnerplanner.model.MenuModel;

public class DinnerPlannerApplication extends Application {
	
	private DinnerModel dinnerModel = new DinnerModel();

	private IHomeModel homeModel = new HomeModel();

	private IMenuModel menuModel = new MenuModel();

	public DinnerModel getDinnerModel(){
		return dinnerModel;
	}

	public void setDinnerModel(DinnerModel dinnerModel){
		this.dinnerModel = dinnerModel;
	}

	public IHomeModel getHomeModel() {
		return homeModel;
	}

	public void setHomeModel(IHomeModel homeModel) {
		this.homeModel = homeModel;
	}

	public IMenuModel getMenuModel(){
		return menuModel;
	}

	public void setMenuModel(IMenuModel menuModel){
		this.menuModel = menuModel;
	}
}
