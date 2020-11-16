package Entities;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import Enumerates.MaitriseCompetence;

@Entity 
@Table(name = "FicheCompetence") 
public class FicheCompetence implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_fiche")
	private int id_fiche;
	@OneToOne
	private Employe user;
	
	@Column(name = "NoteConception")
	private int NoteConception;
	
	@Column(name = "NoteGestionProjet")
	private int NoteGestionProjet;
	
	@Column(name = "NoteReporting")
	private int NoteReporting;
	
	@Column(name = "NoteDevLogiciel")
	private int NoteDevLogiciel;
	
	@Column(name = "NoteMethodesAgile")
	private int NoteMethodesAgile;
	
	@Enumerated(EnumType.STRING)
	private MaitriseCompetence maitrise;

	public Employe getUser() {
		return user;
	}

	public void setUser(Employe user) {
		this.user = user;
	}

	public int getNoteConception() {
		return NoteConception;
	}

	public void setNoteConception(int noteConception) {
		NoteConception = noteConception;
	}

	public int getNoteGestionProjet() {
		return NoteGestionProjet;
	}

	public void setNoteGestionProjet(int noteGestionProjet) {
		NoteGestionProjet = noteGestionProjet;
	}

	public int getNoteReporting() {
		return NoteReporting;
	}

	public void setNoteReporting(int noteReporting) {
		NoteReporting = noteReporting;
	}

	public int getNoteDevLogiciel() {
		return NoteDevLogiciel;
	}

	public void setNoteDevLogiciel(int noteDevLogiciel) {
		NoteDevLogiciel = noteDevLogiciel;
	}

	public int getNoteMethodesAgile() {
		return NoteMethodesAgile;
	}

	public void setNoteMethodesAgile(int noteMethodesAgile) {
		NoteMethodesAgile = noteMethodesAgile;
	}

	public MaitriseCompetence getMaitrise() {
		return maitrise;
	}

	public void setMaitrise(MaitriseCompetence maitrise) {
		this.maitrise = maitrise;
	}

	public FicheCompetence(int noteConception, int noteGestionProjet, int noteReporting, int noteDevLogiciel,
			int noteMethodesAgile, MaitriseCompetence maitrise) {
		super();
		NoteConception = noteConception;
		NoteGestionProjet = noteGestionProjet;
		NoteReporting = noteReporting;
		NoteDevLogiciel = noteDevLogiciel;
		NoteMethodesAgile = noteMethodesAgile;
		this.maitrise = maitrise;
	}

	public FicheCompetence() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}

