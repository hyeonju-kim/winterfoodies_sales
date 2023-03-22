package com.winterfoodies;

import com.winterfoodies.aop.target.SalesLogTarget;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@MapperScan(basePackages = "com.winterfoodies.mapper")
@EnableAspectJAutoProxy //2023.03.05 2.AOP 버튼을 켠다.
@SpringBootApplication
public class SalesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesApplication.class, args);
	}

}
