/*
 * Created on 2017-03-22 ( Time 16:30:53 )
 * Generated by Telosys Tools Generator ( version 3.0.0 )
 */
package org.demo.web.mvc.spring.controller;

import java.util.LinkedList;
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
import org.demo.data.record.BookOrderItemRecord;
import org.demo.data.record.BookOrderRecord;
import org.demo.data.record.BookRecord;

//--- Persistence services 
import org.demo.persistence.BookOrderItemPersistence;
import org.demo.persistence.BookOrderPersistence;
import org.demo.persistence.BookPersistence;

//--- List Items 
import org.demo.data.record.listitem.BookOrderListItem;
import org.demo.data.record.listitem.BookListItem;

/**
 * Spring MVC controller for 'BookOrderItem' management.
 */
@Controller
@RequestMapping("/bookOrderItem")
public class BookOrderItemController extends AbstractController {

	//--- Variables names ( to be used in JSP with Expression Language )
	private static final String MAIN_ENTITY_NAME = "bookOrderItem";
	private static final String MAIN_LIST_NAME   = "list";

	//--- JSP pages names ( View name in the MVC model )
	private static final String JSP_FORM   = "bookOrderItem/form";
	private static final String JSP_LIST   = "bookOrderItem/list";

	//--- SAVE ACTION ( in the HTML form )
	private static final String SAVE_ACTION_CREATE   = "/bookOrderItem/create";
	private static final String SAVE_ACTION_UPDATE   = "/bookOrderItem/update";

	//--- Main entity service
	@Resource
    private BookOrderItemPersistence bookOrderItemService; // Injected by Spring
	//--- Other service(s)
	@Resource
    private BookOrderPersistence bookOrderService; // Injected by Spring
	@Resource
    private BookPersistence bookService; // Injected by Spring

	//--------------------------------------------------------------------------------------
	/**
	 * Default constructor
	 */
	public BookOrderItemController() {
		super(BookOrderItemController.class, MAIN_ENTITY_NAME );
		log("BookOrderItemController created.");
	}

	//--------------------------------------------------------------------------------------
	// Spring MVC model management
	//--------------------------------------------------------------------------------------

	private List<BookOrderListItem> getListOfBookOrderItems() {
		List<BookOrderRecord> list = bookOrderService.findAll();
		List<BookOrderListItem> items = new LinkedList<BookOrderListItem>();
		for ( BookOrderRecord bookOrder : list ) {
			items.add(new BookOrderListItem( bookOrder ) );
		}
		//model.addAttribute("listOfBookOrderItems", items ) ;
		return items ;
	}

	private List<BookListItem> getListOfBookItems() {
		List<BookRecord> list = bookService.findAll();
		List<BookListItem> items = new LinkedList<BookListItem>();
		for ( BookRecord book : list ) {
			items.add(new BookListItem( book ) );
		}
		//model.addAttribute("listOfBookItems", items ) ;
		return items ;
	}

	/**
	 * Populates the Spring MVC model with the given entity and eventually other useful data
	 * @param model
	 * @param bookOrderItem
	 */
	private void populateModel(Model model, BookOrderItemRecord bookOrderItem, FormMode formMode) {
		//--- Main entity
		model.addAttribute(MAIN_ENTITY_NAME, bookOrderItem);
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
		// populateListOfBookOrderItems(model);
		model.addAttribute("listOfBookOrderItems", getListOfBookOrderItems() ) ;
		// populateListOfBookItems(model);
		model.addAttribute("listOfBookItems", getListOfBookItems() ) ;
	}

	//--------------------------------------------------------------------------------------
	// Request mapping
	//--------------------------------------------------------------------------------------
	/**
	 * Shows a list with all the occurrences of BookOrderItem found in the database
	 * @param model Spring MVC model
	 * @return
	 */
	@RequestMapping()
	public String list(Model model) {
		log("Action 'list'");
		List<BookOrderItemRecord> list = bookOrderItemService.findAll();
		model.addAttribute(MAIN_LIST_NAME, list);		
		return JSP_LIST;
	}

	/**
	 * Shows a form page in order to create a new BookOrderItem
	 * @param model Spring MVC model
	 * @return
	 */
	@RequestMapping("/form")
	public String formForCreate(Model model) {
		log("Action 'formForCreate'");
		//--- New record instance (it will be used to initialize the web form fields ) 
		BookOrderItemRecord bookOrderItem = new BookOrderItemRecord();	
		//--- Initialize the instance here if necessary...
		// bookOrderItem.setXxxx("XX");
		//--- Populates the model with the new instance
		populateModel( model, bookOrderItem, FormMode.CREATE);
		//--- Redirect to the 'FORM VIEW' ( JSP )
		return JSP_FORM;
	}

	/**
	 * Shows a form page in order to update an existing BookOrderItem
	 * @param model Spring MVC model
	 * @param bookOrderId  primary key element
	 * @param bookId  primary key element
	 * @return
	 */
	@RequestMapping(value = "/form/{bookOrderId}/{bookId}")
	public String formForUpdate(Model model, @PathVariable("bookOrderId") Integer bookOrderId, @PathVariable("bookId") Integer bookId ) {
		log("Action 'formForUpdate'");
		//--- Search the entity by its primary key
		BookOrderItemRecord bookOrderItem = bookOrderItemService.findById(bookOrderId, bookId);
		//--- Populates the model with the instance
		populateModel( model, bookOrderItem, FormMode.UPDATE);		
		//--- Redirect to the 'FORM VIEW' ( JSP )
		return JSP_FORM;
	}

	/**
	 * 'CREATE' action processing. <br>
	 * This action is based on the 'Post/Redirect/Get (PRG)' pattern, so it ends by 'http redirect'<br>
	 * @param bookOrderItem  entity to be created
	 * @param bindingResult Spring MVC binding result (to retrieve validation errors)
	 * @param model Spring MVC model
	 * @param redirectAttributes Spring MVC redirect attributes
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "/create" ) // GET or POST
	public String create(@Valid @ModelAttribute("bookOrderItem") BookOrderItemRecord bookOrderItem, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest) {
		log("Action 'create'");
		try {
			if (!bindingResult.hasErrors()) {
				BookOrderItemRecord recordCreated = bookOrderItemService.create(bookOrderItem); 
				log("BookOrderItem created : " + recordCreated );
				model.addAttribute(MAIN_ENTITY_NAME, recordCreated);

				//---
				messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
				return redirectToForm(httpServletRequest, bookOrderItem.getBookOrderId(), bookOrderItem.getBookId() );
			} else {
				log("Action 'create' : binding error(s) " );
				logBindingErrors(bindingResult);
				populateModel( model, bookOrderItem, FormMode.CREATE);
				return JSP_FORM;
			}
		} catch(Exception e) {
			log("Action 'create' : Exception - " + e.getMessage() );
			messageHelper.addException(model, "bookOrderItem.error.create", e);
			populateModel( model, bookOrderItem, FormMode.CREATE);
			return JSP_FORM;
		}
	}

	/**
	 * 'UPDATE' action processing. <br>
	 * This action is based on the 'Post/Redirect/Get (PRG)' pattern, so it ends by 'http redirect'<br>
	 * @param bookOrderItem  entity to be updated
	 * @param bindingResult Spring MVC binding result (to retrieve validation errors)
	 * @param model Spring MVC model
	 * @param redirectAttributes Spring MVC redirect attributes
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "/update" ) // GET or POST
	public String update(@Valid @ModelAttribute("bookOrderItem") BookOrderItemRecord bookOrderItem, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest) {
		log("Action 'update'");
		try {
			if (!bindingResult.hasErrors()) {
				//--- Perform database operations
				boolean updated = bookOrderItemService.update(bookOrderItem);
				log("BookOrderItem updated : result = " + updated );
				model.addAttribute(MAIN_ENTITY_NAME, bookOrderItem);
				//--- Set the result message
				messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
				log("Action 'update' : update done - redirect");
				return redirectToForm(httpServletRequest, bookOrderItem.getBookOrderId(), bookOrderItem.getBookId());
			} else {
				log("Action 'update' : binding errors");
				logBindingErrors(bindingResult);
				populateModel( model, bookOrderItem, FormMode.UPDATE);
				return JSP_FORM;
			}
		} catch(Exception e) {
			messageHelper.addException(model, "bookOrderItem.error.update", e);
			log("Action 'update' : Exception - " + e.getMessage() );
			populateModel( model, bookOrderItem, FormMode.UPDATE);
			return JSP_FORM;
		}
	}

	/**
	 * 'DELETE' action processing. <br>
	 * This action is based on the 'Post/Redirect/Get (PRG)' pattern, so it ends by 'http redirect'<br>
	 * @param redirectAttributes
	 * @param bookOrderId  primary key element
	 * @param bookId  primary key element
	 * @return
	 */
	@RequestMapping(value = "/delete/{bookOrderId}/{bookId}") // GET or POST
	public String delete(RedirectAttributes redirectAttributes, @PathVariable("bookOrderId") Integer bookOrderId, @PathVariable("bookId") Integer bookId) {
		log("Action 'delete'" );
		try {
			boolean deleted = bookOrderItemService.deleteById( bookOrderId, bookId );
			log("BookOrderItem deleted. Key : " + toString(bookOrderId, bookId) + " result = " + deleted );
			//--- Set the result message
			messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));	
		} catch(Exception e) {
			messageHelper.addException(redirectAttributes, "bookOrderItem.error.delete", e);
		}
		return redirectToList();
	}

}
