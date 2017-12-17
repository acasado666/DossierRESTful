package com.dat.dossier.webservice.rs.domain;

import com.dat.dossier.webservice.rs.model.*;

public class DossierStorage {
	
	private static DossierList list = new DossierList();

	static { // initialize with some data
		list.add(new Dossier("VW-Golf", 11234, "DE", "Deutsch", "COMPLETE", 2015));
		list.add(new Dossier("BMW-118D", 11235, "DE", "Deutsch", "SIMPLE", 2012));
		list.add(new Dossier("A3-2.0", 11236, "AS", "Deutsch", "FULL", 2013));
		list.add(new Dossier("AlfaGiulia-2.2", 22237, "IT", "Italy", "ADVANCED", 2015));
		list.add(new Dossier("AlfaGiulia-3.0 GTI", 23456, "DE", "Italy", "COMPLETE", 2017));
//		list.add(new Dossier("AlfaGiulia-3.0", 11237, "CN", "Chinese", new Vehicle("CNAG3.0", 3111, "Alfa Romeo", "3.0 turbocharged 510", new Long(12340))));
//		list.add(new Dossier("BMW-120D", 22345, "DE", "Deutsch", new Vehicle("DEBMW2.0D", 3111, "BMW AG", "2.0 turbocharged 193", new Long(43215))));
	}

	public static DossierList getList() {
		return list;
	}

	public static void setList(DossierList list) {
		DossierStorage.list = list;
	}
}
