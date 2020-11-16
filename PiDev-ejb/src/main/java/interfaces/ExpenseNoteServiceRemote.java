package interfaces;

import java.util.List;

import javax.ejb.Remote;

import Entities.*;
@Remote

public interface ExpenseNoteServiceRemote {
	void createExpenseNote();
	void updateExpenseNote();
	void removeExpenseNote();
	double calculateTotalCosts();
	boolean approveExpenseNote();
	List<ExpenseNote> displayFullExpenseNote();

}
