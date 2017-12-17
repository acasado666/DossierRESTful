package com.dat.dossier.webservice.rs.model;

//import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement
public class Dossier {

	String nameDossier;
	int idDossier;
	String countryDossier;
	String languageDosier;
	String description;
	int creationYearDossier;
	Vehicle vehicle;
	
	public Dossier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dossier(String nameDossier, int idDossier, String countryDossier, String languageDosier, String description, int creationYearDossier) {
		super();
		this.nameDossier = nameDossier;
		this.idDossier = idDossier;
		this.countryDossier = countryDossier;
		this.languageDosier = languageDosier;
		this.description = description;
		this.creationYearDossier = creationYearDossier;
	}

	public Dossier(String nameDossier, int idDossier, String countryDossier, String languageDosier, String description, int creationYearDossier, Vehicle vehicle) {
		super();
		this.nameDossier = nameDossier;
		this.idDossier = idDossier;
		this.countryDossier = countryDossier;
		this.languageDosier = languageDosier;
		this.description = description;
		this.creationYearDossier = creationYearDossier;
		this.vehicle = vehicle;
	}

	public String getNameDossier() {
		return nameDossier;
	}

	public void setNameDossier(String nameDossier) {
		this.nameDossier = nameDossier;
	}

	public int getIdDossier() {
		return idDossier;
	}

	public void setIdDossier(int idDossier) {
		this.idDossier = idDossier;
	}

	public String getCountryDossier() {
		return countryDossier;
	}

	public void setCountryDossier(String countryDossier) {
		this.countryDossier = countryDossier;
	}

	public String getLanguageDosier() {
		return languageDosier;
	}

	public void setLanguageDosier(String languageDosier) {
		this.languageDosier = languageDosier;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCreationYear() {
		return creationYearDossier;
	}

	public void setCreationYear(int creationYearDossier) {
		this.creationYearDossier = creationYearDossier;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Dossier [nameDossier=" + nameDossier + ", idDossier=" + idDossier + ", countryDossier=" 
				+ countryDossier + ", languageDosier=" + languageDosier + "description" + "creationYear"
				+ ", getNameDossier()=" + getNameDossier() 
				+ ", getIdDossier()=" + getIdDossier() 
				+ ", getCountryDossier()=" + getCountryDossier()  
				+ ", getLanguageDosier()=" + getLanguageDosier()
				+ ", getDescription()=" + getDescription()
				+ ", getCreationYear()=" + getCreationYear()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	//	TODO
	public Vehicle getvehicle() {
		return vehicle;
	}

	public void setvehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
}
