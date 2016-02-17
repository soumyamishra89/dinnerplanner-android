package se.kth.csc.iprog.dinnerplanner.model;

/**
 * Created by SOMU on 15/02/16.
 */
public class HomeModel implements IHomeModel{

    private String homeViewText;

    private String startText;

    public HomeModel(){
        this.homeViewText = homeViewText;
    }
    @Override
    public String getHomeViewText( ) {
        return homeViewText;
    }

    @Override
    public void setHomeViewText(String homeViewText) {
        this.homeViewText = homeViewText;
    }

    @Override
    public void setStartText(String text) {
        this.startText=text;
    }

    @Override
    public String getStartText( ) {
        return startText;
    }
}
