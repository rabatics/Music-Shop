
package cs636.music.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import cs636.music.domain.User;

/**
 * 
 * Access site_user table through this class.
 
 */
public class UserDAO {
	
	private DbDAO dbdao;

	
	/**
	 * An Data Access Object for site_user table

	 */
	public UserDAO(DbDAO db) {
		dbdao = db;
	}
	
	/**
	 * 

	 */
	public void insertUser(User user) {
		dbdao.getEM().persist(user);
	}
	
	/**
	 * Find a user from site user table by its email
	
	 */
	public User findUserByEmail(String email) {
		EntityManager em = dbdao.getEM();
		TypedQuery<User> q = em.createQuery("select u from User u where u.emailAddress = '" + email + "'", User.class);
		List<User> user = q.getResultList();
		if (user.size() > 0)
			return user.get(0);
		else
			return null;
	}
	

}
