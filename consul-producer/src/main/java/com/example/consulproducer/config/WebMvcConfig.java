/**
 * WebMvcConfig.java created 2018年10月5日
 *
 * \$LastChangedBy\$
 * \$Date\$
 * \$Revision\$
 */
package com.example.consulproducer.config;

import java.io.IOException;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WebMvcConfig {

   @Bean
   public RestTemplate restTemplate() {
      return new RestTemplateBuilder().errorHandler(new ResponseErrorHandler() {
         @Override
         public boolean hasError(ClientHttpResponse httpResponse) throws IOException {
            return (httpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR
                  || httpResponse.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR);
         }

         @Override
         public void handleError(ClientHttpResponse httpResponse) throws IOException {
            if (httpResponse.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR) {
               // handle SERVER_ERROR
            } else if (httpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR) {
               // handle CLIENT_ERROR
            }
         }
      }).build();
   }
}
