package com.example.consulproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@SpringCloudApplication
public class ConsulProducerApplication {
	
	/**
	 * 開啟顯示API路由的LOG日誌
	 * @author charles.chen
	 * @date 2019年4月2日 上午11:35:11
	 */
	@Bean
	public CommonsRequestLoggingFilter logFilter() {
	    CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
	    filter.setIncludeQueryString(true);
	    filter.setIncludePayload(true);
	    filter.setMaxPayloadLength(5120);
	    return filter;
	}	
	
	public static void main(String[] args) {
		SpringApplication.run(ConsulProducerApplication.class, args);
	}

}
