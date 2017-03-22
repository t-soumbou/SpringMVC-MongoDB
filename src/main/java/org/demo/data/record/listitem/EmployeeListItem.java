/*
 * Created on 2017-03-22 ( Date ISO 2017-03-22 - Time 16:41:52 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */
package org.demo.data.record.listitem;

import org.demo.data.record.EmployeeRecord;
import org.demo.commons.ListItem;

public class EmployeeListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public EmployeeListItem(EmployeeRecord employee) {
		super();

		this.value = ""
			 + employee.getCode()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = employee.toString();
	}

	//@Override
	public String getValue() {
		return value;
	}

	//@Override
	public String getLabel() {
		return label;
	}

}
