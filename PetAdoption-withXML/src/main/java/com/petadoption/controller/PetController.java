package com.petadoption.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.petadoption.entity.Pet;
import com.petadoption.service.PetService;

@Controller
@RequestMapping("/pets")
public class PetController {

	/** Add an initbinder to conver trim input strings
	 *  remove leading and trailing whitespace 
	 * @param databinder
	 */
	@InitBinder
	public void initBinder(WebDataBinder databinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		databinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@Autowired
	private PetService petService;

	@Value("#{breedOptions}")
	private Map<String, String> breedOptions;
	
	/**
	 * List all the pets
	 * 
	 * @param theModel
	 * @return page list all the pets
	 */
	@GetMapping("/")
	private String listPets(Model theModel) {

		// get the list of pets in the dao
		List<Pet> pets = petService.getPets();
				
		// add list of pets to the model
		theModel.addAttribute("pets", pets);

		return "pets";
	}

	/**
	 * Show add form
	 * 
	 * @param theModel
	 * @return the add new pet form
	 */
	@GetMapping("/showAddForm")
	private String showAddNewPetForm(Model theModel) {

		// add Pet to the model
		theModel.addAttribute("pet", new Pet());
		
		// add breed options to the model
		theModel.addAttribute("breedOptions", breedOptions);

		return "/forms/add-new-pet-form";
	}
	
	@GetMapping("/showUpdateForm")
	private String showUpdateForm(@RequestParam("petId") int theId, Model theModel) {
		
		// retrieve pet from database
		Pet pet = petService.getPet(theId);
		
		// add Pet to the Model
		theModel.addAttribute("pet", pet);
		
		// add the breed options to the model
		theModel.addAttribute("breedOptions", breedOptions);
		
		return "/forms/add-new-pet-form";
	}

	/**
	 * Add new pet
	 * 
	 * @param thePet
	 * @return the page list all the pets
	 */
	@PostMapping("/addNewPet")
	public String addNewPet(@Valid @ModelAttribute("pet") Pet thePet, BindingResult bindingResult, Model theModel) {
		
		if (bindingResult.hasErrors()) {
			theModel.addAttribute("breedOptions", breedOptions);
			return "/forms/add-new-pet-form";
		}
		
		// add new pet to the database
		petService.savePet(thePet);
		return "redirect:/pets/";
	}
	
	/** Adopt pet
	 * @param theId
	 * @return the list of updated pets
	 */
	@GetMapping("/adopt")
	public String adoptPet(@RequestParam("petId") int theId) {
		
		// retrieve pet by id from database
		Pet pet = petService.getPet(theId);
		
		// set adopted to true
		pet.setAdopted(true);
		System.out.println(pet.getBreed());
		// update pet
		petService.savePet(pet);
		// return to list of pets
		return "redirect:/pets/";
	}

	/**
	 * Delete pet by Id
	 * 
	 * @param theId
	 * @return the page list all the pets
	 */
	@GetMapping("/delete")
	public String deletePet(@RequestParam("petId") int theId) {

		// delete pet from database
		petService.deletePet(theId);

		return "redirect:/pets/";
	}
}
