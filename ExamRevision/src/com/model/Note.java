package com.model;

public class Note {

	int idn;
	double note;
	
	Matiere m;
	Etudiant e;
	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdn() {
		return idn;
	}
	public void setIdn(int idn) {
		this.idn = idn;
	}
	public double getNote() {
		return note;
	}
	public void setNote(double note) {
		this.note = note;
	}
	public Matiere getM() {
		return m;
	}
	public void setM(Matiere m) {
		this.m = m;
	}
	public Etudiant getE() {
		return e;
	}
	public void setE(Etudiant e) {
		this.e = e;
	}
	
	
}
