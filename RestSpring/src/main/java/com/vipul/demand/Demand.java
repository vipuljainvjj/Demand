package com.vipul.demand;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Demand implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public Demand() {}
	
	public Demand(Date date, Double predictedAmount, Double investedAmount) {
		this.date = date;
		this.predictedAmount = predictedAmount;
		this.investedAmount = investedAmount;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long demandID;
	private Date date;
	private Double predictedAmount;
	private Double investedAmount;
	
	public Long getDemandID() {
		return demandID;
	}
	
	public void setDemandID(Long demandID) {
		this.demandID = demandID;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Double getPredictedAmount() {
		return predictedAmount;
	}
	
	public void setPredictedAmount(Double predictedAmount) {
		this.predictedAmount = predictedAmount;
	}
	
	public Double getInvestedAmount() {
		return investedAmount;
	}
	
	public void setInvestedAmount(Double investedAmount) {
		this.investedAmount = investedAmount;
	}
	
	public DemandData getDemandData() {
		DemandData demandData  = new DemandData(
			this.demandID == null ? 0 : demandID.intValue(),
			this.date,
			this.predictedAmount == null ? 0.0 : predictedAmount.doubleValue(),
			this.investedAmount == null ? 0.0 : investedAmount.doubleValue()
		);
		return demandData;
	}
	
	public static Demand setDemand(DemandData demandData) {
		Demand demand = new Demand(
				demandData.getDate() == null ? new Date() : demandData.getDate(), 
				Double.valueOf(demandData.getPredictedAmount()),
				Double.valueOf(demandData.getInvestedAmount())
		);
		return demand;
	}
}