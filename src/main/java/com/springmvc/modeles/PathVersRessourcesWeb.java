package com.springmvc.modeles;

public class PathVersRessourcesWeb {
	
	
//	public static String path = "C:/Users/Aewys/eclipse-workspace/projetfilrouge/src/main/webapp/ressourcesweb/";
//	public static String path =  String.format("%s/webapps/projetfilrouge/src/main/webapp/ressourcesweb/", System.getProperty("catalina.base"));
	public static String path =  String.format("%s/webapps/projetfilrouge/ressourcesweb/", System.getProperty("catalina.base"));

	
	
	public PathVersRessourcesWeb(){}

	public static String getPath() {
		return path;
	}

	public static void setPath(String path) {
		PathVersRessourcesWeb.path = path;
	}
	
}
