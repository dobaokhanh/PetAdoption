package com.petadoption.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.petadoption.entity.Foster;

/**
 * @author bkdo30
 *
 */
@Repository
public class FosterDAOImpl implements FosterDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	/**
	 * Get all the fosters
	 */
	@Override
	public List<Foster> getFosters() {

		// get the current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// retrive all of the fosters from database
		Query<Foster> theQuery = currentSession.createQuery("from Foster order by name", Foster.class);
		
		// get the results
		List<Foster> fosters = theQuery.getResultList();
		
		// return 
		return fosters;
	}


	/**
	 *	Get Foster by Id
	 */
	@Override
	public Foster getFoster(int theId) {

		// get the current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// get the foster by id
		Foster foster = currentSession.get(Foster.class, theId);
		
		// return
		return foster;
	}

	/**
	 * Save foster
	 */
	@Override
	public void saveFoster(Foster theFoster) {
		
		// get the current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save foster
		currentSession.saveOrUpdate(theFoster);
		
	}

	/**
	 * Delete foster by Id
	 */
	@Override
	public void deleteFoster(int theId) {

		// get the current session 
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete foster
		Query theQuery = currentSession.createQuery("delete from Foster where id=: fosterId");
		theQuery.setParameter("fosterId", theId);
		
		// execute the query
		theQuery.executeUpdate();
	}

}
