package com.mydata.model;

public class Todo {
	private int id;
	private String title;
	
	private String targetdate;
	
	private String Todostaus;
	
	private String tododescription;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTargetdate() {
		return targetdate;
	}

	public void setTargetdate(String targetdate) {
		this.targetdate = targetdate;
	}

	public String getTodostaus() {
		return Todostaus;
	}

	public void setTodostaus(String todostaus) {
		Todostaus = todostaus;
	}

	public String getTododescription() {
		return tododescription;
	}

	public void setTododescription(String tododescription) {
		this.tododescription = tododescription;
	}

	public Todo(String title, String targetdate, String todostaus, String tododescription) {
		super();
		this.title = title;
		this.targetdate = targetdate;
		Todostaus = todostaus;
		this.tododescription = tododescription;
	}

	public Todo() {
		super();
		// TODO Auto-generated constructor stub
	}

}