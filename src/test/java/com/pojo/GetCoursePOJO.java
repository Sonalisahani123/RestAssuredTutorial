package com.pojo;

public class GetCoursePOJO {
	
	private String instructor;
	private String url;
	private String services;
	private String expertise;
	private CoursesPOJO courses;
	private String linkedIN;
	
	
	public CoursesPOJO getCourses() {
		return courses;
	}
	public void setCourses(CoursesPOJO courses) {
		this.courses = courses;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	public String getLinkedIN() {
		return linkedIN;
	}
	public void setLinkedIN(String linkedIN) {
		this.linkedIN = linkedIN;
	}
	

}
