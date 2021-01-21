package com.model;

public class Matiere {

	int idm;
	String libelle;
	double coiff;
	public int getIdm() {
		return idm;
	}
	public void setIdm(int idm) {
		this.idm = idm;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public double getCoiff() {
		return coiff;
	}
	public void setCoiff(double coiff) {
		this.coiff = coiff;
	}
	public Matiere() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Matiere(String libelle, double coiff) {
		super();
		this.libelle = libelle;
		this.coiff = coiff;
	}
	
	
}
