package com.petadoption.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.petadoption.entity.Pet;

/**
 * @author bkdo30
 *
 */

@Repository
public class PetDAOImpl implements PetDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Get the list of pets
	 */
	
	@Override
	public List<Pet> getPets() {
		
		// get the current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create query
		Query<Pet> theQuery = currentSession.createQuery("from Pet order by name", Pet.class);
		
		// execute the query and get the result list
		List<Pet> pets = theQuery.getResultList();
		
		// return pets
		return pets;
	}

	/**
	 * Get pet by Id
	 */
	@Override
	public Pet getPet(int theId) {

		// get the current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// retrieve from database using primary key
		Pet pet = currentSession.get(Pet.class, theId);
		
		return pet;
	}

	/**
	 * Save pet to the database
	 */
	@Override
	public void savePet(Pet pet) {

		// get the current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save pet to the database
		currentSession.saveOrUpdate(pet);
		
	}

	/**
	 * Delete pet by Id
	 */
	@Override
	public void deletePet(int theId) {

		// get the current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete the Pet by id
		Query theQuery = currentSession.createQuery("delete from Pet where id=: petId");
		theQuery.setParameter("petId", theId);
		
		// execute delete
		theQuery.executeUpdate();
	}

}
