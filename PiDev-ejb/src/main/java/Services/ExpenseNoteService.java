package Services;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entities.ExpenseNote;
import interfaces.ExpenseNoteServiceLocal;
import interfaces.ExpenseNoteServiceRemote;


@Stateless
public class ExpenseNoteService implements ExpenseNoteServiceRemote ,ExpenseNoteServiceLocal{

	
	@PersistenceContext(unitName= "PiDev-ejb")

	EntityManager em; 
	@Override
	public void createExpenseNote() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateExpenseNote() {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeExpenseNote() {
		// TODO Auto-generated method stub

	}

	@Override
	public double calculateTotalCosts() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean approveExpenseNote() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ExpenseNote> displayFullExpenseNote() {
		// TODO Auto-generated method stub
		return null;
	}

}
