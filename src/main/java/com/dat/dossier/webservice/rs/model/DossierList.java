package com.dat.dossier.webservice.rs.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso(Dossier.class)
public class DossierList extends ArrayList<Dossier> {
	private static final long serialVersionUID = 1L;

	public DossierList() {
		super();
	}

	public DossierList(Collection<? extends Dossier> c) {
		super(c);
	}

	@XmlElement(name = "dossiers") 
	public List<Dossier> getDossiers() {
		return this;
	}

	public void addFoods(List<Dossier> dossiers) {
		this.addAll(dossiers);
	}

	public void addDossiers(List<Dossier> dossiers) {
		this.addAll(dossiers);
	}
}
