package com.example.apigateway.feign.model;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
	private Integer userId;
	private String username;
	private String password;
}
