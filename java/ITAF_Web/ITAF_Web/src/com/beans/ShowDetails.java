package com.beans;
import  java.io.Serializable;

public class ShowDetails implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String testcasename;
	private String sourcetablename;
	private String targettablename;
 	private String sourcequery;
 	private String targetquery;
 	private String type;
	
	public ShowDetails(String testcasename, String sourcetablename, String targettablename, String sourcequery,
			String targetquery, String type) {
		
		this.testcasename = testcasename;
		this.sourcetablename = sourcetablename;
		this.targettablename = targettablename;
		this.sourcequery = sourcequery;
		this.targetquery = targetquery;
		this.type = type;
	}
	
	public String getTestcasename() {
		return testcasename;
	}
	public void setTestcasename(String testcasename) {
		this.testcasename = testcasename;
	}
	public String getSourcetablename() {
		return sourcetablename;
	}
	public void setSourcetablename(String sourcetablename) {
		this.sourcetablename = sourcetablename;
	}
	public String getTargettablename() {
		return targettablename;
	}
	public void setTargettablename(String targettablename) {
		this.targettablename = targettablename;
	}
	public String getSourcequery() {
		return sourcequery;
	}
	public void setSourcequery(String sourcequery) {
		this.sourcequery = sourcequery;
	}
	public String getTargetquery() {
		return targetquery;
	}
	public void setTargetquery(String targetquery) {
		this.targetquery = targetquery;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	

}
