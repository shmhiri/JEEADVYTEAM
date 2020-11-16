package Bean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import Entities.Employe;
import Entities.FicheCompetence;
import Enumerates.MaitriseCompetence;
import Services.CompetenceService;

@ManagedBean(name= "FicheBean", eager = true)
@SessionScoped
public class FicheBean implements Serializable {
	
		private static final long serialVersionUID = 1L;
		private Employe user;

		private int NoteConception;
		private int NoteGestionProjet;
	    private int NoteReporting;
		private int NoteDevLogiciel;
		private int NoteMethodesAgile;
		private MaitriseCompetence maitrise;
		@EJB
		CompetenceService cos;
		public void Ajoutfiche() {
			FicheCompetence f =new FicheCompetence(NoteConception, NoteGestionProjet, NoteReporting, NoteDevLogiciel, NoteMethodesAgile, maitrise);
			cos.ajouterFiche(f);
		}
		

		public MaitriseCompetence getMaitrise() {
			return maitrise;
		}



		public void setMaitrise(MaitriseCompetence maitrise) {
			this.maitrise = maitrise;
		}


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

		
		public CompetenceService getCos() {
			return cos;
		}
		public void setCos(CompetenceService cos) {
			this.cos = cos;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
		
}
