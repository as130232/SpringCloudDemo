package com.example.consulproducer.feign.test.api;

import org.springframework.cloud.openfeign.FeignClient;

import com.example.consulproducer.feign.FeignConfig;

@FeignClient(name = "test-service", configuration = FeignConfig.class)
public interface TestFeignClient
//extends TestAPI
{

}
