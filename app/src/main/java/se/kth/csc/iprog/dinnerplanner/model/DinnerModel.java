package se.kth.csc.iprog.dinnerplanner.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Observable;
import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.android.R;

public class DinnerModel extends Observable implements IDinnerModel{


	Set<Dish> dishes = new HashSet<>();

	List<Dish> fullMenu = new ArrayList<>();

	private int numberOfGuests = 0;

	/**
	 * The constructor of the overall model. Set the default values here
	 */
	public DinnerModel(){
		Dish dish1 = new Dish("Mudshroom123",Dish.STARTER, R.drawable.mushroomtart,"");

		fullMenu.add(dish1);

		Dish dish2 = new Dish("Crostini",Dish.STARTER, R.drawable.crostini,"Turn on the oven at 150 C. \nCarve bread \nPut tomato and cheese on bread \nPlace in oven or 10 min.");
		Ingredient dish2ing1 = new Ingredient("Bread",0.5,"loaf", 20);
		Ingredient dish2ing2 = new Ingredient("Tomato",0.5,"pcs", 3);
		Ingredient dish2ing3 = new Ingredient("Cheese",100,"g", 10);

		dish2.addIngredient(dish2ing1);
		dish2.addIngredient(dish2ing2);
		dish2.addIngredient(dish2ing3);

		fullMenu.add(dish2);

		Dish dish3 = new Dish("Springrolls", Dish.STARTER, R.drawable.springrolls, "");
		fullMenu.add(dish3);
		Dish dish4 = new Dish("Chicken", Dish.MAIN, R.drawable.chicken, "Slice chicken. \nFry chicken \nSlice sallad \nPut on plate");
		Ingredient dish4ing1=new Ingredient("Chicken",500,"g", 30);
		Ingredient dish4ing2=new Ingredient("Salad",100,"g", 16);
		dish4.addIngredient(dish4ing1);
		dish4.addIngredient(dish4ing2);
		fullMenu.add(dish4);
		fullMenu.add(new Dish("Chicken Curry", Dish.MAIN, R.drawable.chicken, "Slice chicken. \nFry chicken \nSlice sallad \nPut on plate"));

		Dish dish5=new Dish("Meat", Dish.MAIN, R.drawable.meatballs, "");
		fullMenu.add(dish5);
		Dish dish6=new Dish("Shrimp Plate", Dish.MAIN, R.drawable.shrimp, "");
		fullMenu.add(dish6);
		Dish dish7=new Dish("Sour Dough", Dish.MAIN, R.drawable.sourdough, "");
		fullMenu.add(dish7);
		Dish dish8=new Dish("Berry Cake", Dish.DESERT, R.drawable.berrycake, "");
		fullMenu.add(dish8);
		Dish dish9=new Dish("Icecream", Dish.DESERT, R.drawable.icecream, "");
		fullMenu.add(dish9);
		}
	
	/**
	 * Returns the set of dishes of specific type. (1 = starter, 2 = main, 3 = desert).
	 */
	public Set<Dish> getDishes(){
		return dishes;
	}
	
	/**
	 * Returns the set of dishes of specific type. (1 = starter, 2 = main, 3 = desert).
	 */
	public Set<Dish> getDishesOfType(int type){
		Set<Dish> result = new HashSet<Dish>();
		for(Dish d : fullMenu){
			if(d.getType() == type){
				result.add(d);
			}
		}
		return result;
	}
	
	/**
	 * Returns the set of dishes of specific type, that contain filter in their name
	 * or name of any ingredient. 
	 */
	public Set<Dish> filterDishesOfType(int type, String filter){
		Set<Dish> result = new HashSet<Dish>();
		for(Dish d : dishes){
			if(d.getType() == type && d.contains(filter)){
				result.add(d);
			}
		}
		return result;
	}

	@Override
	public int getNumberOfGuests() {
		return numberOfGuests;
	}

	@Override
	public void setNumberOfGuests(int numberOfGuests) {
		this.numberOfGuests=numberOfGuests;
		setChanged();
		notifyObservers(this.numberOfGuests);
	}

	@Override
	public Dish getSelectedDish(String name) {
		Dish selectedDish=null;
		for(Dish d : fullMenu){
			if(d.getName().equalsIgnoreCase(name)){
				selectedDish=d;
			}
		}

		return selectedDish;
	}

	@Override
	public Set<Dish> getFullMenu() {
		return null;
	}

	@Override
	public Set<Ingredient> getAllIngredients() {
		Set<Ingredient> allIngredients=new HashSet<Ingredient>();

		return new HashSet<Ingredient>(allIngredients);
	}

	@Override
	public float getTotalMenuPrice() {
		return calculateTotalPrice();
	}

	@Override
	public void addDishToMenu(Dish dish){

		dishes.add(dish);
		Log.v("Soumya : ", "" + dishes.size());
		setChanged();
		notifyObservers(dish);

	}

	@Override
	public void removeDishFromMenu(Dish dish) {
		dishes.remove(dish);
	}

	private float calculateTotalPrice() {
		float totalPrice = 0;
		for(Dish dish : dishes) {
			for (Ingredient ing : dish.getIngredients()) {
				totalPrice += ing.getPrice();
			}
		}
		return totalPrice * numberOfGuests;
	}

}
