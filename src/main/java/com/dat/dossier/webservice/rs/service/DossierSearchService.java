package com.dat.dossier.webservice.rs.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.dat.dossier.webservice.rs.domain.DossierManager;
import com.dat.dossier.webservice.rs.domain.DossierSearch;
import com.dat.dossier.webservice.rs.model.Dossier;
import com.dat.dossier.webservice.rs.model.DossierList;


@Path("search/dossiers")
public class DossierSearchService {

	@POST
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response searchForDossiers(DossierSearch search) {
		System.out.println(search.getDescriptions() + ", " + search.getYearFrom());
		
		List<Dossier> dossiers = DossierManager.findByConstraints(search);
		
		if(dossiers == null || dossiers.size() <= 0) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.ok().entity(new GenericEntity<List<Dossier>>(dossiers) {}).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response searchForDossiers(@QueryParam(value = "description") List<String> descriptions, 
			@QueryParam(value = "yearFrom") int yearFrom, 
			@QueryParam(value = "yearTo") int yearTo) {
		
		System.out.println(descriptions + ", " + yearFrom + ", " + yearTo);
		
		List<Dossier> dossiers = DossierManager.findByDescription(descriptions, yearFrom, yearTo);
		
		if(dossiers == null || dossiers.size() <= 0) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.ok().entity(new GenericEntity<List<Dossier>>(dossiers) {}).build();
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Dossier> get() {
		DossierList dossierList = DossierManager.getDossiers();
		
		return dossierList.getDossiers(); 
	}

}