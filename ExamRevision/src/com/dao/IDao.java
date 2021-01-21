package com.dao;

import java.util.List;

import com.model.Etudiant;
import com.model.Matiere;
import com.model.Note;

public interface IDao {

	public int AddEtudiant(String nom, String prenom, String log, String pass);
	public Etudiant Auth(String log,String pass);
	public List<Etudiant> Alletudiants();
	public Etudiant findEtudiant(int ide);
	public int AddMatiere(String libelle, double coiff);
	public Matiere findMatier(int idm);
	
	public List<Matiere> AllMatier();

	public int AddNote(double note, int idm, int ide);
	public List<Note> allnote4Etudiant(int ide);

	public double moyenne(int ide);
}



