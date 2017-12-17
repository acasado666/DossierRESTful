package com.dat.dossier.webservice.rs.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dat.dossier.webservice.rs.domain.DossierStorage;
import com.dat.dossier.webservice.rs.model.Dossier;
import com.dat.dossier.webservice.rs.model.DossierList;


public class DossierManager {
	private static DossierList dossierList = DossierStorage.getList();

	public static DossierList getDossiers() {
		return dossierList;
	}

	public static Dossier find(String name) {
		final Optional<Dossier> foundDossier = dossierList.stream()
				.filter(dossier -> dossier.getNameDossier()
				.equalsIgnoreCase(name)).findFirst();
		
		return foundDossier.orElse(null);
	}
	
	public static Dossier findId (int id) {
		for (Dossier dossier:dossierList) {
			if( dossier.getIdDossier() == id ) {
				return dossier;
			}
        }
		return null;
	}


	public static void add(Dossier dossier) {
		dossierList.add(dossier);
	}

	public static void delete(String name) {
		Dossier dossier = find(name);
		dossierList.remove(dossier);
	}
	
	public static void update(Dossier dossier) {
		
		Dossier dossierToUpdate = DossierManager.find(dossier.getNameDossier());
		
		dossierToUpdate.setIdDossier(dossier.getIdDossier());
		dossierToUpdate.setNameDossier(dossier.getNameDossier());
		dossierToUpdate.setCountryDossier(dossier.getCountryDossier());
		dossierToUpdate.setLanguageDosier(dossier.getLanguageDosier());
		// 	TO-DO for sub-resource mapping
		//	dossierToUpdate.setvehicle(vehicle);
	}
	
	public static List<Dossier> findByConstraints(DossierSearch search) {
		
		//I grab anything I want from search object
		System.out.println(search.getYearTo());
		System.out.println(search.getYearFrom());
		System.out.println(search.getDescriptions());
		System.out.println(search.getSearchType());
		
		List<Dossier> searchedDossiers = new ArrayList<Dossier>();
		
		if (search.getSearchType().equals(DossierSearchType.SEARCH_BY_YEAR_RANGE)) {
			
			for(Dossier dos: dossierList) {
				if ( (dos.getCreationYear() > search.getYearFrom()) &&
					(dos.getCreationYear() > search.getYearTo()) ) {
					searchedDossiers.add(dos);
				}
			}

		} else if (search.getSearchType().equals(DossierSearchType.SEARCH_BY_DESCRIPTION)) {
			
			for(Dossier dos: dossierList) {
				if ( search.getDescriptions().contains(dos.getDescription()) ) {
					searchedDossiers.add(dos);
				}
			}
		}
		
		return searchedDossiers;
	}
	
	public static List<Dossier> findByDescription(List<String> descriptions, int yearFrom, int yearTo) {
		// select * from activities where description in (?,?,?) and duration > ? and duration < ?
		
		List<Dossier> searchedDossiers = new ArrayList<Dossier>();
		for(Dossier dos: dossierList) {
			if ( descriptions.contains(dos.getDescription()) ) {
				searchedDossiers.add(dos);
			}
		}
		
		return searchedDossiers;
	}
}
