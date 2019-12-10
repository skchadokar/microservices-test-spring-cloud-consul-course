package com.example.satish.springcloudconsulcourse.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;


@Component
@Document(collection = "student")
public class Course implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3539681913322638175L;

	@Id
	private String courseId;
	
	private String cname;

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
	
	

	
}
