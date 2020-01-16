package com.petadoption.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.petadoption.entity.Owner;

/**
 * @author bkdo30
 *
 */
@Repository
public class OwnerDAOImpl implements OwnerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Get all the owners
	 */
	@Override
	public List<Owner> getOwners() {
		// get the current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create query
		Query<Owner> theQuery = currentSession.createQuery("from Owner order by name", Owner.class);
		
		// execute query and get the result list
		List<Owner> owners = theQuery.getResultList();
		
		// return the list of owners
		return owners;
	}

	/**
	 * Get owner by Id
	 */
	@Override
	public Owner getOwner(int theId) {

		// get the current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create query
		Owner owner = currentSession.get(Owner.class, theId);
		return owner;
	}

	/**
	 * Save owner to the database
	 */
	@Override
	public void saveOwner(Owner owner) {

		// get the current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save the owner
		currentSession.saveOrUpdate(owner);
	}

	/**
	 * Delete owner by Id
	 */
	@Override
	public void deleteOwner(int theId) {

		// get the current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete the owner
		Query theQuery = currentSession.createQuery("delete from Owner where id=: ownerId");
		theQuery.setParameter("ownerId", theId);
		
		// execute delete
		theQuery.executeUpdate();
	}

}
