package com.petadoption.controller;

import java.util.List;

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

import com.petadoption.entity.Foster;
import com.petadoption.service.FosterService;

/**
 * @author bkdo30
 *
 */
@Controller
@RequestMapping("/fosters")
public class FosterController {

	/** Add an init binder to convert trim input strings
	 *  remove leading and trailing whitespace 
	 * @param databinder
	 */
	@InitBinder
	public void initBinder(WebDataBinder databinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		databinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@Autowired
	private FosterService fosterService;
	
	/** List all the fosters
	 * @param theModel
	 * @return the page list all the fosters
	 */
	@GetMapping("/")
	public String listFosters(Model theModel) {
		
		// retrieve all the fosters from database
		List<Foster> fosters = fosterService.getFosters();
		
		// add fosters to the model
		theModel.addAttribute("fosters", fosters);
		
		return "fosters";
		
	}
	
	/** Add foster
	 * @param theModel
	 * @return
	 */
	@GetMapping("/showAddForm")
	public String showAddFosterForm(Model theModel) {
		
		// add foster to the model
		theModel.addAttribute("foster", new Foster());
		
		return "/forms/add-new-foster";
	}
	
	/** Show the update form
	 * @param theId
	 * @param theModel
	 * @return
	 */
	@GetMapping("/showUpdateForm")
	public String showUpdateForm(@RequestParam("fosterId") int theId, Model theModel) {
		
		// get the foster by Id
		Foster foster = fosterService.getFoster(theId);
		
		// add foster to the model
		theModel.addAttribute("foster", foster);
		
		return "/forms/add-new-foster";
	}
	
	/** Save foster to the database
	 * @param foster
	 * @param bindingResult
	 * @return
	 */
	@PostMapping("/saveFoster")
	public String saveFoster(@ModelAttribute("foster") Foster foster, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "/forms/add-new-foster";
		}
		
		// save foster to the database
		fosterService.saveFoster(foster);
		
		return "redirect:/fosters/";
	}
	
	/** Delete foster by id
	 * @param theId
	 * @return
	 */
	@GetMapping("/delete")
	public String deleteFoster(@RequestParam("fosterId") int theId) {
		
		// delete the foster by Id
		fosterService.deleteFoster(theId);

		return "redirect:/fosters/";
	}
}
