package se.kth.csc.iprog.dinnerplanner.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.android.R;

/**
 * Created by SOMU on 15/02/16.
 */
public class MenuModel implements IMenuModel{

    private List<Dish> allMenuItems=new ArrayList<>();

    private String starterText;

    private String mainText;

    private String dessertText;

    public MenuModel(){

        //Adding some example data, you can add more
        Dish dish1 = new Dish("Mudshroom123",Dish.STARTER, R.drawable.mushroomtart,"");

        allMenuItems.add(dish1);

        Dish dish2 = new Dish("Crostini",Dish.STARTER, R.drawable.crostini,"Turn on the oven at 150 C. \nCarve bread \nPut tomato and cheese on bread \nPlace in oven or 10 min.");
        Ingredient dish2ing1 = new Ingredient("Bread",0.5,"loaf",20);
        Ingredient dish2ing2 = new Ingredient("Tomato",0.5,"pcs",3);
        Ingredient dish2ing3 = new Ingredient("Cheese",100,"g",10);

        dish2.addIngredient(dish2ing1);
        dish2.addIngredient(dish2ing2);
        dish2.addIngredient(dish2ing3);

        allMenuItems.add(dish2);

        Dish dish3 = new Dish("Springrolls", Dish.STARTER, R.drawable.springrolls, "");
        allMenuItems.add(dish3);
        Dish dish4 = new Dish("Chicken", Dish.MAIN, R.drawable.chicken, "Slice chicken. \nFry chicken \nSlice sallad \nPut on plate");
        Ingredient dish4ing1=new Ingredient("Chicken",500,"g",30);
        Ingredient dish4ing2=new Ingredient("Salad",100,"g",16);
        dish4.addIngredient(dish4ing1);
        dish4.addIngredient(dish4ing2);
        allMenuItems.add(dish4);

        Dish dish5=new Dish("Meat", Dish.MAIN, R.drawable.meatballs, "");
        allMenuItems.add(dish5);
        Dish dish6=new Dish("Shrimp Plate", Dish.MAIN, R.drawable.shrimp, "");
        allMenuItems.add(dish6);
        Dish dish7=new Dish("Sour Dough", Dish.MAIN, R.drawable.sourdough, "");
        allMenuItems.add(dish7);
        Dish dish8=new Dish("Berry Cake", Dish.DESERT, R.drawable.berrycake, "");
        allMenuItems.add(dish8);
        Dish dish9=new Dish("Icecream", Dish.DESERT, R.drawable.icecream, "");
        allMenuItems.add(dish9);

    }
    @Override
    public List<Dish> getAllMenuItems(){
        return allMenuItems;
    }

    @Override
    public String getStarterText( ){
        return starterText;
    }

    @Override
    public String getMainText( ){
        return mainText;
    }

    @Override
    public String getDessertText( ){
        return dessertText;
    }

    @Override
    public void setStarterText(String starterText){
        this.starterText=starterText;
    }

    @Override
    public void setMainText(String mainText){
        this.mainText=mainText;
    }

    @Override
    public void setDessertText(String dessertText){
        this.dessertText=dessertText;
    }
}
