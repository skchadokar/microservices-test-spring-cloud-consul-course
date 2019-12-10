package com.example.satish.springcloudconsulcourse;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Primary;

@ConfigurationProperties(prefix = "spring.data")
@Primary
public class DataSource {

	public DataSource dataSource() {
		return (DataSource) DataSourceBuilder.create().build();

	}
}
