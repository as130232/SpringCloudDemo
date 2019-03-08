package com.example.consulconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties
@Data
public class ConfigModel {
	
	private String username;
}
