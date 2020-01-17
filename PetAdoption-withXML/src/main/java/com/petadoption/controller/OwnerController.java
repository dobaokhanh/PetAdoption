package com.petadoption.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.petadoption.entity.Owner;
import com.petadoption.service.OwnerService;

@Controller
@RequestMapping("/owners")
public class OwnerController {
	
	/** Add an initbinder to convert trim input strings
	 *  remove leading and trailing whitespace 
	 * @param databinder
	 */
	@InitBinder
	public void initBinder(WebDataBinder databinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		databinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@Autowired
	private OwnerService ownerService;

	/**
	 * Show all the owners
	 * 
	 * @param theModel
	 * @return list of all owners page
	 */
	@GetMapping("/")
	public String listOwner(Model theModel) {

		// get the owners from dao
		List<Owner> owners = ownerService.getOwners();

		// add the owners to the model
		theModel.addAttribute("owners", owners);
		return "owners";
	}

	/**
	 * Show add new owner form
	 * 
	 * @param theModel
	 * @return add new owner form
	 */
	@GetMapping("/showAddForm")
	public String showAddOwnerForm(Model theModel) {

		// Add owner to the model attribute
		theModel.addAttribute("owner", new Owner());

		return "/forms/add-new-owner";
	}

	/**
	 * Show update form
	 * 
	 * @param theId
	 * @param theModel
	 * @return form for update
	 */
	@GetMapping("/showUpdateForm")
	public String showUpdateOwnerForm(@RequestParam("ownerId") int theId, Model theModel) {

		// get the owner from database
		Owner owner = ownerService.getOwner(theId);
		
		// add the owner to the model
		theModel.addAttribute("owner", owner);
		return "/forms/add-new-owner";
	}

	/**
	 * Add new owner to the database
	 * 
	 * @param theOwner
	 * @return the page list all the owners
	 */
	@PostMapping("/saveOwner")
	public String saveOwner(@Valid @ModelAttribute("owner") Owner theOwner, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "forms/add-new-owner";
		}
		// save the owner
		ownerService.saveOwner(theOwner);
		return "redirect:/owners/";
	}

	/**	
	 * Delete owner by Id
	 * 
	 * @param theId
	 * @return the page list all the owners
	 */
	@GetMapping("/delete")
	public String deleteOwner(@RequestParam("ownerId") int theId) {

		// delete the owner
		ownerService.deleteOwner(theId);

		return "redirect:/owners/";
	}
}
