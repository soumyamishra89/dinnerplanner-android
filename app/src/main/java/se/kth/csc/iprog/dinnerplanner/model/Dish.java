package se.kth.csc.iprog.dinnerplanner.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Dish implements Parcelable {
	public static final String EXTRA_DISH = "DISH";
	public static final int STARTER = 1;
	public static final int MAIN = 2;
	public static final int DESERT = 3;

	public static final List<String> STARTER_KEYWORDS = Arrays.asList("Salad", "Appetizers", "Soups, Stews and Chili");
	public static final List<String> MAIN_KEYWORDS = Arrays.asList("Main Dish", "Breakfast");
	public static final List<String> DESSERTS_KEYWORD = Arrays.asList("Desserts", "Drinks");
	
	String name;
	int type; // starter (1), main (2) or desert (3)  
	Bitmap imageUrl;
	String description;
	String recipeId;
	
	Set<Ingredient> ingredients = new HashSet<Ingredient>();
	
	public Dish(String name, int type, Bitmap image, String description, String recipeId) {
		this.name = name;
		this.type = type;
		this.imageUrl = image;
		this.description = description;
		this.recipeId = recipeId;
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
	public Bitmap getImage() {
		return imageUrl;
	}
	public void setImage(Bitmap image) {
		this.imageUrl = image;
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

	public String getRecipeId( ){
		return recipeId;
	}

	public void setRecipeId(String recipeId){
		this.recipeId = recipeId;
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

	public static int getDishType(String category) {
		if (STARTER_KEYWORDS.contains(category)) {
			return STARTER;
		} else if (MAIN_KEYWORDS.contains(category)) {
			return MAIN;
		} else {
			return DESERT;
		}
	}

	@Override
	public int describeContents( ){
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags){
		dest.writeString(name);
		dest.writeString(description);
		dest.writeString(recipeId);
		dest.writeInt(type);
		dest.writeParcelable(imageUrl, flags);
		if(!getIngredients().isEmpty()){
			dest.writeTypedArray(( Ingredient[])getIngredients().toArray(), flags);
		}
	}

	public static final Parcelable.Creator<Dish> CREATOR
			= new Parcelable.Creator<Dish>() {
		public Dish createFromParcel(Parcel in) {
			return new Dish(in);
		}

		public Dish[] newArray(int size) {
			return new Dish[size];
		}
	};

	private Dish(Parcel in) {
		name = in.readString();
		description = in.readString();
		recipeId = in.readString();
		type = in.readInt();
		imageUrl = in.readParcelable(Bitmap.class.getClassLoader());
		if(!getIngredients().isEmpty()) {
			Ingredient[] ingredients = new Ingredient[0];
			in.readTypedArray(ingredients, Ingredient.CREATOR);
			for(Ingredient ingredient : ingredients) {
				getIngredients().add(ingredient);
			}
		}
	}
}
