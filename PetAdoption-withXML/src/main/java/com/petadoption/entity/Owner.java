package com.petadoption.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "owner")
public class Owner extends PersonnalInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Pet> pets;

	public Owner() {
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Pet> getPets() {
		if (this.pets == null) {
			this.pets = new ArrayList<>();
		}
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}
	
	public void addPet(Pet pet) {
		if (pet.isNew()) {
			getPets().add(pet);
		}
		
		pet.setOwner(this);
	}

	@Override
	public String toString() {
		return "Owner [id=" + id + ", getName()=" + getName() + ", getAddress()=" + getAddress()
				+ ", getCity()=" + getCity() + ", getPhone()=" + getPhone() + ", getEmail()=" + getEmail()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}



}
