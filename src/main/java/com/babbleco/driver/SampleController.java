package com.babbleco.driver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication(scanBasePackages="com.babbleco")
public class SampleController {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleController.class, args);
	}
}