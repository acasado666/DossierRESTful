package com.dat.dossier.webservice.rs.model;

public class Vehicle {
	String idVevhicle;
	int idVehicleNumer;
	String manufacturer;
	String descriptionEngine;
	Long mileage;
	
	public Vehicle() {
		super();
	}
	
	/**
	 * @param idVevhicle
	 * @param idVehicleNumer
	 * @param manufacturer
	 * @param descriptionEngine
	 * @param mileage
	 */
	public Vehicle(String idVevhicle, int idVehicleNumer, String manufacturer, String descriptionEngine, Long mileage) {
		super();
		this.idVevhicle = idVevhicle;
		this.idVehicleNumer = idVehicleNumer;
		this.manufacturer = manufacturer;
		this.descriptionEngine = descriptionEngine;
		this.mileage = mileage;
	}
	
	/**
	 * @return the idVevhicle
	 */
	public String getIdVevhicle() {
		return idVevhicle;
	}
	
	/**
	 * @param idVevhicle the idVevhicle to set
	 */
	public void setIdVevhicle(String idVevhicle) {
		this.idVevhicle = idVevhicle;
	}
	
	/**
	 * @return the idVehicleNumer
	 */
	public int getIdVehicleNumer() {
		return idVehicleNumer;
	}
	
	/**
	 * @param idVehicleNumer the idVehicleNumer to set
	 */
	public void setIdVehicleNumer(int idVehicleNumer) {
		this.idVehicleNumer = idVehicleNumer;
	}
	
	/**
	 * @return the manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}
	
	/**
	 * @param manufacturer the manufacturer to set
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	/**
	 * @return the descriptionEngine
	 */
	public String getDescriptionEngine() {
		return descriptionEngine;
	}
	
	/**
	 * @param descriptionEngine the descriptionEngine to set
	 */
	public void setDescriptionEngine(String descriptionEngine) {
		this.descriptionEngine = descriptionEngine;
	}
	
	/**
	 * @return the mileage
	 */
	public Long getMileage() {
		return mileage;
	}
	
	/**
	 * @param mileage the mileage to set
	 */
	public void setMileage(Long mileage) {
		this.mileage = mileage;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Vehicle [idVevhicle=" + idVevhicle + ", idVehicleNumer=" + idVehicleNumer + ", Manufacturer="
				+ this.manufacturer + ", descriptionEngine=" + descriptionEngine + ", mileage=" + mileage
				+ ", getIdVevhicle()=" + getIdVevhicle() + ", getIdVehicleNumer()=" + getIdVehicleNumer()
				+ ", getManufacturer()=" + getManufacturer() + ", getDescriptionEngine()=" + getDescriptionEngine()
				+ ", getMileage()=" + getMileage() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
}
