 package com.dat.dossier.webservice.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dat.dossier.webservice.rs.model.*;

public class DossierClient {

	private Client client;

	public DossierClient () {
		client = ClientBuilder.newClient();
	}
	
//	public void delete(String dossierId) {
//		WebTarget target = client.target("http://localhost:8080/exercise-services/webapi/");
//		
//		Response response = target.path("dossiers/" + dossierId).request(MediaType.APPLICATION_JSON).delete();
//		
//		if(response.getStatus() != 200) {
//			throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
//		}
//	}
//	
	public Dossier get(String dossierId) {
		
		//AC 	http://localhost:8080/webservices/webapi/dossiers/1234
		WebTarget target = client.target("http://localhost:8080/webservices/webapi/");
		
		//		Dossier responseDossier = target.path("dossiers/" + dossierId).request(MediaType.APPLICATION_JSON).get(Dossier.class);
		//		if(responseDossier == null) {
		//			throw new RuntimeException(responseDossier.toString() + ": there was an error on the server.");
		//		}
		//		return responseDossier;
		//		
		//		String stringDossier = target.path("dossiers/" + dossierId).request().get(String.class);
		//		if(stringDossier == null) {
		//			throw new RuntimeException("Response as a String object:" + ": there was an error on the server.");
		//		} else {
		//			System.out.println("Response as a String object:" + stringDossier.toString());
		//		}
		//		return null;
		
		Response response = target.path("dossiers/" + dossierId).request(MediaType.APPLICATION_JSON).get(Response.class);
		if(response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
		}
		
		return response.readEntity(Dossier.class);
	}
	
	public List<Dossier> get () {
		
		//AC 	http://localhost:8080/webservices/webapi/dossiers
		WebTarget target = client.target("http://localhost:8080/webservices/webapi/");
		
		// restful problem, Lists (generics in general) must be wrap on GenericType
		List<Dossier> response = target.path("dossiers")
				.request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<Dossier>>() {});
		
		return response;
	}

	public Dossier create(Dossier dossier) {
		
		//AC 	http://localhost:8080/webservices/webapi/dossiers/dossier		
		WebTarget target = client.target("http://localhost:8080/webservices/webapi/");
		
		Response response = target.path("dossiers/dossier")
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(dossier, MediaType.APPLICATION_JSON));
		
		if ((response.getStatus() != 201) && 
			(response.getStatus() != 304) && 
			(response.getStatus() != 200)) { //304 not modified //201 created
			System.out.println(response.getStatus() + ": there was an error on the server.");
			throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
			
		}
		Dossier readEntity = response.readEntity(Dossier.class);
		return readEntity;
	}

	public Dossier update(Dossier dossier) {
		
		//AC 	http://localhost:8080/webservices/webapi/dossiers/dossier
		WebTarget target = client.target("http://localhost:8080/webservices/webapi/");
		
		Response response = target.path("dossiers/" + dossier.getIdDossier())
				.request(MediaType.APPLICATION_JSON)
				.put(Entity.entity(dossier, MediaType.APPLICATION_JSON));
		
		if(response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
		}
		
		return response.readEntity(Dossier.class);
	}

	public void delete(String string) {
		//AC 	http://localhost:8080/webservices/webapi/dossiers/dossier
		WebTarget target = client.target("http://localhost:8080/webservices/webapi/");
		
		Response response = target.path("dossiers/" + string)
				.request(MediaType.APPLICATION_JSON)
				.delete();
		
		if(response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
		}
		
	}	
}
