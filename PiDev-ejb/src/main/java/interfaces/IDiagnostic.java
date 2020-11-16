package interfaces;

import javax.ejb.Remote;

import Entities.Entrepreneur;



@Remote
public interface IDiagnostic {

	public String diagnostic(Entrepreneur e);
}
