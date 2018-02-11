package com.dat.dossier.webservice.client;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dat.dossier.webservice.rs.domain.DossierSearch;
import com.dat.dossier.webservice.rs.domain.DossierSearchType;
import com.dat.dossier.webservice.rs.model.Dossier;

public class DossierClientTest {

	@Test
	public void testGet() {
		DossierClient client = new DossierClient();
		
		Dossier dossier = client.get("11234");
		
		System.out.println(dossier);
		
		assertNotNull(dossier);
	}
	
	@Test
	public void testGetList() {
		DossierClient client = new DossierClient();
		
		List<Dossier> dossier = client.get();
		
		System.out.println(dossier);
		
		assertNotNull(dossier);
	}
	
	@Test
	public void testCreate() {
		DossierClient client = new DossierClient();
		
		Dossier dossier = new Dossier("RADEON", 69696,"A", "DE", "COMPLETE", 2015);
		
		dossier = client.create(dossier);
		
		assertNotNull(dossier);
	}
	
	@Test
	public void tesPut() {
		DossierClient client = new DossierClient();
		
		Dossier dossier = new Dossier("RADEON", 67776,"A", "DE", "COMPLETE", 2015);

		dossier = client.update(dossier);
		
		assertNotNull(dossier);
	}
	
	@Test
	public void testDelete() {
		DossierClient client = new DossierClient();
		
		client.delete("RADEON");
	}
	
	@Test(expected=RuntimeException.class)
	public void testGetWithBadRequest() {
		
		DossierClient client = new DossierClient();
		
		client.get("123");
	}
	
	@Test(expected=RuntimeException.class)
	public void testGetWithNotFound() {
		
		DossierClient client = new DossierClient();
		
		client.get("7777");
	}
	
	@Test
	public void testSearch() {
		DossierSearchClient client = new DossierSearchClient();
		
		String param= "dossierType";
		List<String> searchValues = new ArrayList<String>();
		searchValues.add("COMPLETE");
		searchValues.add("SIMPLE");
		
		String secondParam = "yearFrom";
		int yearFrom = 2013;
		
		String thirdParam = "yearTo";
		int yearTo = 2017;
		
		List<Dossier> dossiers = client.search(param, searchValues, 
												secondParam, yearFrom, 
												thirdParam, yearTo);
		
		System.out.println(dossiers);
		
		assertNotNull(dossiers);
	}
	
	@Test
	public void testSearchObject() {
		
		DossierSearchClient client = new DossierSearchClient();
		
		List<String> searchValues = new ArrayList<String>();
		searchValues.add("COMPLETE");
		searchValues.add("SIMPLE");
		
		
		DossierSearch search = new DossierSearch();
		search.setDescriptions(searchValues);
		search.setDurationFrom(30);
		search.setDurationTo(55);
		search.setSearchType(DossierSearchType.SEARCH_BY_DESCRIPTION);
		
		List<Dossier> dossiers = client.search(search);
		
		System.out.println(dossiers);
		
		assertNotNull(dossiers);
		
	}
}
