package com.HQLExample;

import javax.persistence.Embeddable;

@Embeddable
public class Certificate5 {
	
	private String course;
	private String duration;
	
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	public Certificate5() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Certificate5(String course, String duration) {
		super();
		this.course = course;
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "Certificate5 [course=" + course + ", duration=" + duration + "]";
	}
	
}
