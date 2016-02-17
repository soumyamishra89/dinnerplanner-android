package se.kth.csc.iprog.dinnerplanner.model;

import java.util.List;
import java.util.Set;

/**
 * Created by SOMU on 15/02/16.
 */
public interface IMenuModel {

    List<Dish> getAllMenuItems();

    String getStarterText();

    String getMainText();

    String getDessertText();

    void setStarterText(String starterText);

    void setMainText(String mainText);

    void setDessertText(String dessertText);

}
