package com.worktogether.webService;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class WSReturn {
	
	private Object value;
	
	public WSReturn(){
	}
	
	public WSReturn(Object value){
		this.value = value;
	}
	
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	
	

}
