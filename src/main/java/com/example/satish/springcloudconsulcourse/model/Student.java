package com.example.satish.springcloudconsulcourse.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;


public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7235505422723803003L;

	@Id
	private String studentId;
	
	private String name;
	
	private String courseId;

	
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	
	
}
