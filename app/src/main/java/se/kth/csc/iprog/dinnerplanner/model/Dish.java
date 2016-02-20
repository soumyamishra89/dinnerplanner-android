package se.kth.csc.iprog.dinnerplanner.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Dish implements Serializable {
	public static final String EXTRA_DISH = "DISH";
	public static final int STARTER = 1;
	public static final int MAIN = 2;
	public static final int DESERT = 3;
	
	String name;
	int type; // starter (1), main (2) or desert (3)  
	int image;
	String description;
	
	Set<Ingredient> ingredients = new HashSet<Ingredient>();
	
	public Dish(String name, int type, int image, String description) {
		this.name = name;
		this.type = type;
		this.image = image;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getImage() {
		return image;
	}
	public void setImage(int image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Set<Ingredient> getIngredients(){
		return ingredients;
	}
	
	public void addIngredient(Ingredient ing){
		ingredients.add(ing);
	}
	
	public void removeIngredient(Ingredient ing){
		ingredients.remove(ing);
	}
	
	public boolean contains(String filter){
		if(name.toLowerCase().contains(filter.toLowerCase())){
			return true;
		}
		for(Ingredient i : ingredients){
			if(i.getName().toLowerCase().contains(filter.toLowerCase())){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean equals(Object o){
		if(o instanceof Dish){
			return ((Dish) o).getName().equals(name);
		}
		return super.equals(o);
	}

	@Override
	public int hashCode(){
		return name.hashCode();
	}
}
