package se.kth.csc.iprog.dinnerplanner.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DinnerModel implements IDinnerModel{


	List<Dish> dishes = new ArrayList<>();
	
	/**
	 * TODO: For Lab2 you need to implement the IDinnerModel interface.
	 * When you do this you will have all the needed fields and methods
	 * for the dinner planner (number of guests, selected dishes, etc.). 
	 */

	private int numberOfGuests=0;


	
	/**
	 * The constructor of the overall model. Set the default values here
	 */
	public DinnerModel(){
		}
	
	/**
	 * Returns the set of dishes of specific type. (1 = starter, 2 = main, 3 = desert).
	 */
	public List<Dish> getDishes(){
		return dishes;
	}
	
	/**
	 * Returns the set of dishes of specific type. (1 = starter, 2 = main, 3 = desert).
	 */
	public Set<Dish> getDishesOfType(int type){
		Set<Dish> result = new HashSet<Dish>();
		for(Dish d : dishes){
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
	}

	@Override
	public Dish getSelectedDish(int type) {
		Dish selectedDish=null;
		for(Dish d : dishes){
			if(d.getType() == type){
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
	public void addDishToMenu(Dish dish) {
		dishes.add(dish);
	}

	@Override
	public void removeDishFromMenu(Dish dish) {
		dishes.remove(dish);
	}

	private float calculateTotalPrice() {
		float totalPrice=0;
		for(Dish dish:dishes) {
			for (Ingredient ing : dish.getIngredients()) {
				totalPrice += ing.getPrice();
			}
		}
		return totalPrice*numberOfGuests;
	}

}
