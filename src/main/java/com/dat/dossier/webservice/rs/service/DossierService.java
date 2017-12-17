package com.dat.dossier.webservice.rs.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

//import com.wordnik.swagger.*;
//import com.wordnik.swagger.annotations.Api;

import com.dat.dossier.webservice.rs.model.Dossier;
import com.dat.dossier.webservice.rs.model.DossierList;
import com.dat.dossier.webservice.rs.domain.DossierManager;
import com.dat.dossier.webservice.rs.domain.DossierStorage;

//@Api(value = "dossiers")
@Path("/dossiers")
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public class DossierService {
	
	@Context
	private UriInfo uriInfo;

	@POST
	@Path("dossier")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Dossier createDossier(Dossier dossier) {
		
		if (dossier == null)
			throw new BadRequestException();

		if (DossierManager.find(dossier.getNameDossier()) == null) {
			DossierManager.add(dossier);
		}
		return dossier;
	}
	
	@POST
	@Path("dossier")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Dossier createDossierParams(MultivaluedMap<String, String> formParams) {
		
		System.out.println(formParams.getFirst("description"));
		System.out.println(formParams.getFirst("duration"));
		
		Dossier dossier = new Dossier();
		dossier.setIdDossier(Integer.parseInt(formParams.getFirst("dossierId")));   
		dossier.setNameDossier(formParams.getFirst("nameDossier"));
		dossier.setCountryDossier(formParams.getFirst("countryDossier"));
		dossier.setLanguageDosier(formParams.getFirst("languageDosssier"));
		
		if (DossierManager.find(dossier.getNameDossier()) == null) {
			DossierManager.add(dossier);
		}
		
		return dossier;
	}

	@PUT
	@Path("{dossierName}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response updateDossier(Dossier dossier) {
		if (dossier == null)
			throw new BadRequestException();
		
		if (DossierManager.find(dossier.getNameDossier()) != null) {
			DossierManager.update(dossier);
		}
		
		return Response.ok().entity(dossier).build();
	}

	@GET
	@Path("{dossierId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getDossier(@PathParam("dossierId") String dossierId) {
		//AC always use Response object
		if(dossierId == null || dossierId.length() < 5) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		
		if (isStringInt(dossierId)) {
			int id = Integer.parseInt(dossierId);
			Dossier dossier = DossierManager.findId(id);
			
			if (dossier == null) {
				//throw new NotFoundException();
				//return Response.ok(dossier).build();
				return Response.status(Status.NOT_FOUND).build();
			}
			return Response.ok().entity(dossier).build();
		}

		
		Dossier dossier = DossierManager.find(dossierId);
		
		if (dossier == null) {
			//throw new NotFoundException();
			//return Response.ok(dossier).build();
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok().entity(dossier).build();
	}
	
	public boolean isStringInt(String s) {
	    try {
	        Integer.parseInt(s);
	        return true;
	    } catch (NumberFormatException ex) {
	        return false;
	    }
	}
	
//	@GET
//	@Path("{id}")
//	public Response getId(@PathParam("id") int id) {
//		Dossier dossier = DossierManager.findId(id);
//		
//		if (dossier == null)
//			throw new NotFoundException();
//		
//		return Response.ok(dossier).build();
//	}
//
//	@GET
//	public Response getAll() {
//		DossierList dossierList = DossierManager.getDossiers();
//		
//		GenericEntity<List<Dossier>> list = new GenericEntity<List<Dossier>>(dossierList) {};
//		
//		return Response.ok(list).build();
//	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Dossier> get() {
		DossierList dossierList = DossierManager.getDossiers();
		
		return dossierList.getDossiers(); 
	}

	@DELETE
	@Path("{dossierId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response delete (@PathParam ("dossierId") String dossierId) {
		Dossier dossier = DossierManager.find(dossierId);
		
		if (dossier == null)
			throw new NotFoundException();
		
		DossierManager.delete(dossierId);
		
		return Response.ok().build();
	}
}
