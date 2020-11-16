package Services;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import Entities.User;




@Stateless
@LocalBean
public class UserService implements UserServiceRemote {
	
	@PersistenceContext(unitName= "PiDev-ejb")

	EntityManager em ;

	
	

	
	
	
	
	
	
	@Override
	public User getUserByEmailAndPassword(String email, String password) {
		User user = null ; 
		TypedQuery<User> query = em.createQuery("Select e from User e "
				+"where e.email=:email and "
				+"e.password=:password"
				, User.class);
		
		query.setParameter("email",email);
		query.setParameter("password",password);
		
	
		
		try {
			user = query.getSingleResult();
		} catch (NoResultException e ) {
			Logger.getAnonymousLogger().info("Aucun user trouvé avec email :" + email);
		}
		return user;
	}

	



	@Override
	public List<User> users() {
		List<User> users=null;
		TypedQuery<User> query = em.createQuery("Select e from User e "
				, User.class);	
		try {
			users = query.getResultList();
		} catch (NoResultException e ) {
			
		}
		return users;
	}
	@Override

public int ajoutUser(User u) {
	em.persist(u);
	return 
			u.getUserId();
	
}
	@Override
public void suppUser(int id) {
	em.remove(em.find(User.class, id));
}
@Override
public void modifUser(User u) {
	em.merge(u);
}
@Override
public List<User> affiAllUser()
{
	List<User> users=null;
TypedQuery<User> q=em.createQuery("select u from User u",User.class);
try {
	users = q.getResultList();
} catch (NoResultException e ) {
	
}
return users;
}

@Override

public User affUser(int id)
{
return em.find(User.class, id);	
}

}
