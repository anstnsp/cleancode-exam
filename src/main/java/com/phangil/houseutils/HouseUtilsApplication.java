package com.phangil.houseutils;

import java.lang.reflect.Method;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.phangil.houseutils.constants.MyAnnotation;
import com.phangil.houseutils.controller.HealthCheckController;

@SpringBootApplication
@EnableCaching
public class HouseUtilsApplication {

	public static void main(String[] args) {

		SpringApplication.run(HouseUtilsApplication.class, args);
		Method[] methodList = HealthCheckController.class.getMethods();

		for (Method method : methodList) {
			if(method.isAnnotationPresent(MyAnnotation.class)) {
				MyAnnotation annotation=method.getDeclaredAnnotation(MyAnnotation.class);
				String value=annotation.value();
				System.out.println(method.getName() + ":" + value);
			}
		}
	}

}
