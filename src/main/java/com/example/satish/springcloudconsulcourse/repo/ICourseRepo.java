package com.example.satish.springcloudconsulcourse.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.satish.springcloudconsulcourse.model.Course;


public interface ICourseRepo extends MongoRepository<Course, String> {

	List<Course> findByCourseId(String cid);

}
