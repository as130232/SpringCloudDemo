package com.example.consulconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableConfigurationProperties(value=ConfigModel.class)
public class ConsulConfigApplication {

	@Autowired
	private ConfigModel configModel;
	
	@GetMapping("/config")
	public ConfigModel getConfigModel() {
		return configModel;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ConsulConfigApplication.class, args);
	}

}
