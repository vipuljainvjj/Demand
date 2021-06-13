package com.vipul.demand;

import java.io.Serializable;

/**
 * Individual product that are bought on a particular demand
 * @author vipul
 *
 */

public class DemandItemData implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public DemandItemData(long demandItemID, int demandID, String orderQuantity, String availableQuantity, double mrp,
			double cost, String seller, String manufacture, String medicineName) {
		this.demandItemID = demandItemID;
		this.demandID = demandID;
		this.orderQuantity = orderQuantity;
		this.availableQuantity = availableQuantity;
		this.mrp = mrp;
		this.cost = cost;
		this.seller = seller;
		this.manufacture = manufacture;
		this.medicineName = medicineName;
	}
	
	private long demandItemID;
	private long demandID;
	private String orderQuantity;
	private String availableQuantity;
	private double mrp;
	private double cost;
	private String seller;
	private String manufacture;
	private String medicineName;
	
	public long getDemandItemID() {
		return demandItemID;
	}
	
	public void setDemandItemID(long demandItemID) {
		this.demandItemID = demandItemID;
	}
	
	public long getDemandID() {
		return demandID;
	}
	
	public void setDemandID(long demandID) {
		this.demandID = demandID;
	}
	
	public String getOrderQuantity() {
		return orderQuantity;
	}
	
	public void setOrderQuantity(String orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	
	public String getAvailableQuantity() {
		return availableQuantity;
	}
	
	public void setAvailableQuantity(String availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	
	public double getMrp() {
		return mrp;
	}
	
	public void setMrp(double mrp) {
		this.mrp = mrp;
	}
	
	public double getCost() {
		return cost;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public String getSeller() {
		return seller;
	}
	
	public void setSeller(String seller) {
		this.seller = seller;
	}
	
	public String getManufacture() {
		return manufacture;
	}
	
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	
	public String getMedicineName() {
		return medicineName;
	}
	
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
}