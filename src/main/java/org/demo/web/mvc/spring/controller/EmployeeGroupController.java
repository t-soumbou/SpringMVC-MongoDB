/*
 * Created on 2017-03-22 ( Time 16:30:54 )
 * Generated by Telosys Tools Generator ( version 3.0.0 )
 */
package org.demo.web.mvc.spring.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;


//--- Common classes
import org.demo.web.mvc.spring.commons.AbstractController;
import org.demo.web.mvc.spring.commons.FormMode;
import org.demo.web.mvc.spring.commons.Message;
import org.demo.web.mvc.spring.commons.MessageType;

//--- Entities
import org.demo.data.record.EmployeeGroupRecord;

//--- Persistence services 
import org.demo.persistence.EmployeeGroupPersistence;


/**
 * Spring MVC controller for 'EmployeeGroup' management.
 */
@Controller
@RequestMapping("/employeeGroup")
public class EmployeeGroupController extends AbstractController {

	//--- Variables names ( to be used in JSP with Expression Language )
	private static final String MAIN_ENTITY_NAME = "employeeGroup";
	private static final String MAIN_LIST_NAME   = "list";

	//--- JSP pages names ( View name in the MVC model )
	private static final String JSP_FORM   = "employeeGroup/form";
	private static final String JSP_LIST   = "employeeGroup/list";

	//--- SAVE ACTION ( in the HTML form )
	private static final String SAVE_ACTION_CREATE   = "/employeeGroup/create";
	private static final String SAVE_ACTION_UPDATE   = "/employeeGroup/update";

	//--- Main entity service
	@Resource
    private EmployeeGroupPersistence employeeGroupService; // Injected by Spring
	//--- Other service(s)

	//--------------------------------------------------------------------------------------
	/**
	 * Default constructor
	 */
	public EmployeeGroupController() {
		super(EmployeeGroupController.class, MAIN_ENTITY_NAME );
		log("EmployeeGroupController created.");
	}

	//--------------------------------------------------------------------------------------
	// Spring MVC model management
	//--------------------------------------------------------------------------------------

	/**
	 * Populates the Spring MVC model with the given entity and eventually other useful data
	 * @param model
	 * @param employeeGroup
	 */
	private void populateModel(Model model, EmployeeGroupRecord employeeGroup, FormMode formMode) {
		//--- Main entity
		model.addAttribute(MAIN_ENTITY_NAME, employeeGroup);
		if ( formMode == FormMode.CREATE ) {
			model.addAttribute(MODE, MODE_CREATE); // The form is in "create" mode
			model.addAttribute(SAVE_ACTION, SAVE_ACTION_CREATE); 			
			//--- Other data useful in this screen in "create" mode (all fields)
		}
		else if ( formMode == FormMode.UPDATE ) {
			model.addAttribute(MODE, MODE_UPDATE); // The form is in "update" mode
			model.addAttribute(SAVE_ACTION, SAVE_ACTION_UPDATE); 			
			//--- Other data useful in this screen in "update" mode (only non-pk fields)
		}
	}

	//--------------------------------------------------------------------------------------
	// Request mapping
	//--------------------------------------------------------------------------------------
	/**
	 * Shows a list with all the occurrences of EmployeeGroup found in the database
	 * @param model Spring MVC model
	 * @return
	 */
	@RequestMapping()
	public String list(Model model) {
		log("Action 'list'");
		List<EmployeeGroupRecord> list = employeeGroupService.findAll();
		model.addAttribute(MAIN_LIST_NAME, list);		
		return JSP_LIST;
	}

	/**
	 * Shows a form page in order to create a new EmployeeGroup
	 * @param model Spring MVC model
	 * @return
	 */
	@RequestMapping("/form")
	public String formForCreate(Model model) {
		log("Action 'formForCreate'");
		//--- New record instance (it will be used to initialize the web form fields ) 
		EmployeeGroupRecord employeeGroup = new EmployeeGroupRecord();	
		//--- Initialize the instance here if necessary...
		// employeeGroup.setXxxx("XX");
		//--- Populates the model with the new instance
		populateModel( model, employeeGroup, FormMode.CREATE);
		//--- Redirect to the 'FORM VIEW' ( JSP )
		return JSP_FORM;
	}

	/**
	 * Shows a form page in order to update an existing EmployeeGroup
	 * @param model Spring MVC model
	 * @param employeeCode  primary key element
	 * @param groupId  primary key element
	 * @return
	 */
	@RequestMapping(value = "/form/{employeeCode}/{groupId}")
	public String formForUpdate(Model model, @PathVariable("employeeCode") String employeeCode, @PathVariable("groupId") Short groupId ) {
		log("Action 'formForUpdate'");
		//--- Search the entity by its primary key
		EmployeeGroupRecord employeeGroup = employeeGroupService.findById(employeeCode, groupId);
		//--- Populates the model with the instance
		populateModel( model, employeeGroup, FormMode.UPDATE);		
		//--- Redirect to the 'FORM VIEW' ( JSP )
		return JSP_FORM;
	}

	/**
	 * 'CREATE' action processing. <br>
	 * This action is based on the 'Post/Redirect/Get (PRG)' pattern, so it ends by 'http redirect'<br>
	 * @param employeeGroup  entity to be created
	 * @param bindingResult Spring MVC binding result (to retrieve validation errors)
	 * @param model Spring MVC model
	 * @param redirectAttributes Spring MVC redirect attributes
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "/create" ) // GET or POST
	public String create(@Valid @ModelAttribute("employeeGroup") EmployeeGroupRecord employeeGroup, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest) {
		log("Action 'create'");
		try {
			if (!bindingResult.hasErrors()) {
				EmployeeGroupRecord recordCreated = employeeGroupService.create(employeeGroup); 
				log("EmployeeGroup created : " + recordCreated );
				model.addAttribute(MAIN_ENTITY_NAME, recordCreated);

				//---
				messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
				return redirectToForm(httpServletRequest, employeeGroup.getEmployeeCode(), employeeGroup.getGroupId() );
			} else {
				log("Action 'create' : binding error(s) " );
				logBindingErrors(bindingResult);
				populateModel( model, employeeGroup, FormMode.CREATE);
				return JSP_FORM;
			}
		} catch(Exception e) {
			log("Action 'create' : Exception - " + e.getMessage() );
			messageHelper.addException(model, "employeeGroup.error.create", e);
			populateModel( model, employeeGroup, FormMode.CREATE);
			return JSP_FORM;
		}
	}

	/**
	 * 'UPDATE' action processing. <br>
	 * This action is based on the 'Post/Redirect/Get (PRG)' pattern, so it ends by 'http redirect'<br>
	 * @param employeeGroup  entity to be updated
	 * @param bindingResult Spring MVC binding result (to retrieve validation errors)
	 * @param model Spring MVC model
	 * @param redirectAttributes Spring MVC redirect attributes
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "/update" ) // GET or POST
	public String update(@Valid @ModelAttribute("employeeGroup") EmployeeGroupRecord employeeGroup, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest) {
		log("Action 'update'");
		try {
			if (!bindingResult.hasErrors()) {
				//--- Perform database operations
				boolean updated = employeeGroupService.update(employeeGroup);
				log("EmployeeGroup updated : result = " + updated );
				model.addAttribute(MAIN_ENTITY_NAME, employeeGroup);
				//--- Set the result message
				messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
				log("Action 'update' : update done - redirect");
				return redirectToForm(httpServletRequest, employeeGroup.getEmployeeCode(), employeeGroup.getGroupId());
			} else {
				log("Action 'update' : binding errors");
				logBindingErrors(bindingResult);
				populateModel( model, employeeGroup, FormMode.UPDATE);
				return JSP_FORM;
			}
		} catch(Exception e) {
			messageHelper.addException(model, "employeeGroup.error.update", e);
			log("Action 'update' : Exception - " + e.getMessage() );
			populateModel( model, employeeGroup, FormMode.UPDATE);
			return JSP_FORM;
		}
	}

	/**
	 * 'DELETE' action processing. <br>
	 * This action is based on the 'Post/Redirect/Get (PRG)' pattern, so it ends by 'http redirect'<br>
	 * @param redirectAttributes
	 * @param employeeCode  primary key element
	 * @param groupId  primary key element
	 * @return
	 */
	@RequestMapping(value = "/delete/{employeeCode}/{groupId}") // GET or POST
	public String delete(RedirectAttributes redirectAttributes, @PathVariable("employeeCode") String employeeCode, @PathVariable("groupId") Short groupId) {
		log("Action 'delete'" );
		try {
			boolean deleted = employeeGroupService.deleteById( employeeCode, groupId );
			log("EmployeeGroup deleted. Key : " + toString(employeeCode, groupId) + " result = " + deleted );
			//--- Set the result message
			messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));	
		} catch(Exception e) {
			messageHelper.addException(redirectAttributes, "employeeGroup.error.delete", e);
		}
		return redirectToList();
	}

}
