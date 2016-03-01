package se.kth.csc.iprog.dinnerplanner.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Ingredient implements Parcelable {
	
	String name;
	String quantity;
	String unit; // can be empty, for example in case of eggs (there is not unit)
	double price;
	
	public Ingredient(String name, String quantity, String unit, double price){
		this.name = name;
		this.quantity=quantity;
		this.unit = unit;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int describeContents( ){
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags){
		dest.writeString(name);
		dest.writeString(quantity);
		dest.writeString(unit);
		dest.writeDouble(price);
	}

	public static final Parcelable.Creator<Ingredient> CREATOR
			= new Parcelable.Creator<Ingredient>() {
		public Ingredient createFromParcel(Parcel in) {
			return new Ingredient(in);
		}

		public Ingredient[] newArray(int size) {
			return new Ingredient[size];
		}
	};

	private Ingredient(Parcel in) {
		name = in.readString();
		quantity = in.readString();
		unit = in.readString();
		price = in.readDouble();

	}
}
