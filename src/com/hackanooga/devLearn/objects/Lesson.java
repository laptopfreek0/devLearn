package com.hackanooga.devLearn.objects;

public class Lesson {
	
	private String introduction;
	private String htmlSource;
	private String htmlTruncatedSource;
	
	public Lesson() {
		htmlSource = "";
		htmlTruncatedSource = "";
		introduction = "";
	}
	
	public Lesson(String intro, String source, String truncatedSource) {
		introduction = intro;
		htmlSource = source;
		htmlTruncatedSource = truncatedSource;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getHtmlSource() {
		return htmlSource;
	}

	public void setHtmlSource(String htmlSource) {
		this.htmlSource = htmlSource;
	}

	public String getHtmlTruncatedSource() {
		return htmlTruncatedSource;
	}

	public void setHtmlTruncatedSource(String htmlTruncatedSource) {
		this.htmlTruncatedSource = htmlTruncatedSource;
	}
	
	

}
