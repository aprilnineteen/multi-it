package com.multi.campus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.multi.campus","com.multi.controller","com"})
@MapperScan(basePackages= {"com.multi.mapper"})
public class Spring07NcapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring07NcapiApplication.class, args);
	}

}
