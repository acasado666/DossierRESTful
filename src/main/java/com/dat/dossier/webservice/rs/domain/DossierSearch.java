package com.dat.dossier.webservice.rs.domain;

import java.util.List;

public class DossierSearch {

	private int yearFrom;
	private int yearTo;
	private List<String> descriptions;
	private DossierSearchType searchType;

	public DossierSearchType getSearchType() {
		return searchType;
	}

	public void setSearchType(DossierSearchType searchType) {
		this.searchType = searchType;
	}

	public List<String> getDescriptions() {
		return descriptions;
	}

	public int getYearFrom() {
		return yearFrom;
	}

	public int getYearTo() {
		return yearTo;
	}

	public void setDescriptions(List<String> descriptions) {
		this.descriptions = descriptions;
	}

	public void setDurationFrom(int yearFrom) {
		this.yearFrom = yearFrom;
	}

	public void setDurationTo(int yearTo) {
		this.yearTo = yearTo;
	}
	
}
