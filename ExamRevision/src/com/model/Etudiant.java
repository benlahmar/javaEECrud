package com.model;

public class Etudiant {

	int id ;
	String nom,prenom,log,pass;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getLog() {
		return log;
	}
	public void setLog(String log) {
		this.log = log;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Etudiant(String nom, String prenom, String log, String pass) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.log = log;
		this.pass = pass;
	}
	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
