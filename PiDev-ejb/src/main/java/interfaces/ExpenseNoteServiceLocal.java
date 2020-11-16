package interfaces;

import java.util.List;

import javax.ejb.Local;

import Entities.*;
@Local
public interface ExpenseNoteServiceLocal {

	void createExpenseNote();
	void updateExpenseNote();
	void removeExpenseNote();
	double calculateTotalCosts();
	boolean approveExpenseNote();
	List<ExpenseNote> displayFullExpenseNote();
}
