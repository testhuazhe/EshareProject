package eshare.model;

import java.util.Date;

public class food {
	String venue;
	Date timefood;
	Date datefood;
	String foodType;
	String comments;
	int foodStatus;
	double foodPrice;
	int peopleNeeded;
	String paymentType;
	String foodQuantity;
	double priceperPerson;
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public Date getTimefood() {
		return timefood;
	}
	public void setTimefood(Date timefood) {
		this.timefood = timefood;
	}
	public Date getDatefood() {
		return datefood;
	}
	public void setDatefood(Date datefood) {
		this.datefood = datefood;
	}
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public int getFoodStatus() {
		return foodStatus;
	}
	public void setFoodStatus(int foodStatus) {
		this.foodStatus = foodStatus;
	}
	public double getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}
	public int getPeopleNeeded() {
		return peopleNeeded;
	}
	public void setPeopleNeeded(int peopleNeeded) {
		this.peopleNeeded = peopleNeeded;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getFoodQuantity() {
		return foodQuantity;
	}
	public void setFoodQuantity(String foodQuantity) {
		this.foodQuantity = foodQuantity;
	}
	public double getPriceperPerson() {
		return priceperPerson;
	}
	public void setPriceperPerson(double priceperPerson) {
		this.priceperPerson = priceperPerson;
	}
}
