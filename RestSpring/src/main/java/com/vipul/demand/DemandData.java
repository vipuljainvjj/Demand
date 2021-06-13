package com.vipul.demand;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Demand Details 
 * @author vipul
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class DemandData extends RepresentationModel<DemandData> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonCreator
	public DemandData(long demandID, Date date, double predictedAmount, double investedAmount) {
		this.demandID  = demandID;
		this.date = date;
		this.predictedAmount = predictedAmount;
		this.investedAmount = investedAmount;
	}

	private long demandID;
	private Date date;
	private double predictedAmount;
	private double investedAmount;
	
	public long getDemandID() {
		return demandID;
	}
	
	public void setDemandID(long demandID) {
		this.demandID = demandID;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public double getPredictedAmount() {
		return predictedAmount;
	}
	
	public void setPredictedAmount(double predictedAmount) {
		this.predictedAmount = predictedAmount;
	}
	
	public double getInvestedAmount() {
		return investedAmount;
	}
	
	public void setInvestedAmount(double investedAmount) {
		this.investedAmount = investedAmount;
	}
}