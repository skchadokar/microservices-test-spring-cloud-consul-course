package com.example.satish.springcloudconsulcourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudConsulSchoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConsulSchoolApplication.class, args);
	}
}
