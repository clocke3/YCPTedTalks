package edu.ycp.cs320.aroby.controller;

import edu.ycp.cs320.aroby.model.Numbers;

public class NumbersController {
	private Numbers model;
	
	public void setModel(Numbers model) {
		this.model = model;
	}
	
	public Double add() {
		return model.getFirst() + model.getSecond() + model.getThird();
	}
	
	public Double multiply() {
		return model.getFirst() * model.getSecond();
	}
}
