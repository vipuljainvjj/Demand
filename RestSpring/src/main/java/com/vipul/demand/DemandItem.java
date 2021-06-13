package com.vipul.demand;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DemandItem implements Serializable { 
	private static final long serialVersionUID = 1L;
	
	public DemandItem() {}
	
	public DemandItem(Long demandID, String orderQuantity, String availableQuantity,
			Double mrp, Double cost, String seller, String manufacture, String medicineName) {
		this.demandID = demandID;
		this.orderQuantity = orderQuantity;
		this.availableQuantity = availableQuantity;
		this.mrp = mrp;
		this.cost = cost;
		this.seller = seller;
		this.manufacture = manufacture;
		this.medicineName = medicineName;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long demandItemID;
	private Long demandID;
	private String orderQuantity;
	private String availableQuantity;
	private Double mrp;
	private Double cost;
	private String seller;
	private String manufacture;
	private String medicineName;
	
	public Long getDemandItemID() {
		return demandItemID;
	}
	
	public void setDemandItemID(Long demandItemID) {
		this.demandItemID = demandItemID;
	}
	
	public Long getDemandID() {
		return demandID;
	}
	
	public void setDemandID(Long demandID) {
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
	
	public Double getMrp() {
		return mrp;
	}
	public void setMrp(Double mrp) {
		this.mrp = mrp;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
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
	
	public DemandItemData getDemandItemData() {
		DemandItemData dItemData = new DemandItemData(
			demandItemID == null ? 0 : demandItemID.intValue(), 
			demandID == null ? 0 : demandID.intValue(), 
			orderQuantity == null ? "" : orderQuantity, 
			availableQuantity == null ? "" : availableQuantity, 
			mrp == null ? 0.0 : mrp.doubleValue(), 
			cost == null ? 0.0 : cost.doubleValue(), 
			seller == null ? "" : seller, 
			manufacture == null ? "" : manufacture,
			medicineName == null ? "" : medicineName
		);		
		return dItemData;
	}
	
	public static DemandItem setDemandItem(DemandItemData demandItemData) {
		DemandItem demandItem = new DemandItem(
				demandItemData.getDemandID(),
				demandItemData.getOrderQuantity(), 
				demandItemData.getAvailableQuantity(),
				Double.valueOf(demandItemData.getMrp()), 
				Double.valueOf(demandItemData.getCost()), 
				demandItemData.getSeller(),
				demandItemData.getManufacture(),
				demandItemData.getMedicineName()
		);
		return demandItem;
	}
}