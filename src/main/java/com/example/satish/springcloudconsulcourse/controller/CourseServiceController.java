package com.example.satish.springcloudconsulcourse.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.satish.springcloudconsulcourse.delegate.StudentServiceDelegate;
import com.example.satish.springcloudconsulcourse.model.Course;
import com.example.satish.springcloudconsulcourse.model.Student;
import com.example.satish.springcloudconsulcourse.repo.ICourseRepo;
import com.example.satish.springcloudconsulcourse.response.ServiceResponse;

import reactor.core.publisher.Flux;


@RestController
public class CourseServiceController {
	
	@Autowired
	StudentServiceDelegate studentServiceDelegate;

	@Autowired
	ICourseRepo iCourseRepo;

	@GetMapping(path = "/courses", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Course>> getCourses() {
		List<Course> mList = iCourseRepo.findAll();
		return new ResponseEntity<List<Course>>(mList, HttpStatus.OK);

	}
	
	@GetMapping(path = "/courses/{cid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Course>> getCourseByCourseId(@PathVariable String cid) {
		List<Course> mList = iCourseRepo.findByCourseId(cid);
		return new ResponseEntity<List<Course>>(mList, HttpStatus.OK);

	}

	@PostMapping(path = "/Courses", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Course> addCourses(@Valid @RequestBody Course aCourse) {
		Course mCourse = iCourseRepo.save(aCourse);
		return new ResponseEntity<Course>(mCourse, HttpStatus.OK);
	}

	@PostMapping(path = "/courses/{courseId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceResponse> removeCourses(@PathVariable String courseId) {
		ServiceResponse mServiceResponse = new ServiceResponse();
		try {
			iCourseRepo.deleteById(courseId);
			mServiceResponse.setIsSuccess(true);
			studentServiceDelegate.updateStudentByCourseId(courseId);//update student courseId as well to null
		} catch (Exception e) {
			mServiceResponse.setIsSuccess(true);
		}
		mServiceResponse.setAction("delete-course");
		mServiceResponse.setsId(courseId);
		return new ResponseEntity<ServiceResponse>(mServiceResponse, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getStudentsDetails/{courseId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Flux<Student> getCourses(@PathVariable String courseId) {
		return studentServiceDelegate.getStudentByCourse(courseId);
	}

}
