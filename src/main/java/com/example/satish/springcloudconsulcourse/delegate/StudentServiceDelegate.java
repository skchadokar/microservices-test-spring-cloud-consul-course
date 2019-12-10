package com.example.satish.springcloudconsulcourse.delegate;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.satish.springcloudconsulcourse.model.Student;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import reactor.core.publisher.Flux;

@Service
public class StudentServiceDelegate {

    public static final String SECRET_KEY = "S@tiSh!=@";
    public static final long EXPIRATION_TIME = 86_400_000; // 1 day   864_000_000 = 10 days
  
    
	@Autowired
	WebClient webClient;

	@LoadBalanced
	public Flux<Student> getStudentByCourse(String courseId) {

		Flux<Student> mlist = webClient.get().uri("http://student-service/students/{courseId}").header("token", createJWT("satish")).retrieve()
				.bodyToFlux(Student.class);

		return mlist;
	}

	@LoadBalanced
	public Flux<Student> updateStudentByCourseId(String courseId) {

		Flux<Student> mlist = webClient.get().uri("http://student-service/students/courses/{courseId}").header("token", createJWT("satish")).retrieve()
				.bodyToFlux(Student.class);

		return mlist;
	}
	
    public static String createJWT(String id) {

        String token = Jwts.builder()
                .setSubject(id)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY.getBytes())
                .compact();

        return token;
    }
}
