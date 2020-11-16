package interfaces;

import Entities.*;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
@Remote
public interface TimesheetServicesInterface {
     
	public void ajouterTimesheet(Timesheet timesheet);
	public ArrayList<Timesheet> AllTimesheet();
	public void deleteTimesheetById(int  tmesheetid);
	public void updateTimesheet(Timesheet timesheet);
	public List<Timesheet>  FindTimesheet(int id);
}

