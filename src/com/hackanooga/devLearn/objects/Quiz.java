package com.hackanooga.devLearn.objects;

import java.util.ArrayList;

import org.apache.http.NameValuePair;

public class Quiz {
	
	private int points;
	private String instructions;
	private ArrayList<NameValuePair> code = new ArrayList<NameValuePair>();
	private ArrayList<String> answer = new ArrayList<String>(); 
	
	public Quiz() {
		
	}
	
	public Quiz(int points, String instructions, ArrayList<NameValuePair> code, ArrayList<String> answer) {
		this.points = points;
		this.instructions = instructions;
		this.code = code;
		this.answer = answer;
	}
	
	public int getPoints() {
		return this.points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
	
	public String getInstructions() {
		return this.instructions;
	}
	
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	
	public ArrayList<NameValuePair> getCode() {
		return this.code;
	}
	
	public void setCode(ArrayList<NameValuePair> code) {
		this.code = code;
	}
	
	public ArrayList<String> getAnswer() {
		return this.answer;
	}
	
	public void setAnswer(ArrayList<String> answer) {
		this.answer = answer;
	}
}
