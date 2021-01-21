package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Etudiant;
import com.model.Matiere;
import com.model.Note;

public class Manager implements IDao{

	@Override
	public int AddEtudiant(String nom, String prenom, String log, String pass) {
		DBInteraction.connect();
		String sql="insert into etudiant(nom,prenom,log, pass) values('"+nom+"','"+prenom+"','"+log+"','"+pass+"')";
		int nb =DBInteraction.Maj(sql);
		DBInteraction.disconnect();
		return nb;
	}

	@Override
	public Etudiant Auth(String log, String pass) {
		
		return null;
	}

	@Override
	public int AddMatiere(String libelle, double coiff) {
		DBInteraction.connect();
		String sql="insert into matiere values(null,'"+libelle+"',"+coiff+")";
		int nb =DBInteraction.Maj(sql);
		DBInteraction.disconnect();
		return nb;
	}

	@Override
	public int AddNote(double note, int idm, int ide) {
		DBInteraction.connect();
		String sql="insert into note(idm,ide,note) values("+idm+","+ide+","+note+")";
		int nb =DBInteraction.Maj(sql);
		DBInteraction.disconnect();
		return nb;
	}

	@Override
	public List<Etudiant> Alletudiants() {
		List<Etudiant> ets=new ArrayList<Etudiant>();
		DBInteraction.connect();
		String sql="select * from etudiant";
		ResultSet rs = DBInteraction.Select(sql);
		try {
			while(rs.next())
			{
				Etudiant e=new Etudiant(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				e.setId(rs.getInt(1));
				ets.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBInteraction.disconnect();
		
		return ets;
	}

	public List<Note> allnote4Etudiant(int ide)
	{
		List<Note> notes=new ArrayList<Note>();
		
		DBInteraction.connect();
		String sql="select * from note where ide="+ide;
		ResultSet rs = DBInteraction.Select(sql);
		
			try {
				while(rs.next())
				{
					Note n=new Note();
					n.setIdn(rs.getInt(1));
					n.setNote(rs.getDouble(2));
					int idee = rs.getInt(3);
					int idmm=rs.getInt(4);
					//n.setM(m);
					//n.setE(e);
					notes.add(n);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return notes;
	}

	@Override
	public Etudiant findEtudiant(int ide) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Matiere findMatier(int idm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Matiere> AllMatier() {
List<Matiere> mts=new ArrayList<Matiere>();
		
		DBInteraction.connect();
		String sql="select * from matiere";
		ResultSet rs = DBInteraction.Select(sql);
		
			try {
				while(rs.next())
				{
					Matiere n=new Matiere();
					n.setIdm(rs.getInt(1));
					n.setLibelle(rs.getString(2));
					n.setCoiff(rs.getDouble(3));
					mts.add(n);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return mts;
	}

	@Override
	public double moyenne(int ide) {
		//les notes + les coifficients 
		List<Note> notes = allnote4Etudiant(ide);
		double m=0;
		for (Note n : notes) {
			m+=n.getNote();
		}
		m=m/notes.size();
		return m;
	}
}
