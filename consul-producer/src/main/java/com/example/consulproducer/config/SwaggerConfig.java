package com.example.consulproducer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.example.commutils.swagger.SwaggerDefaultConfiguation;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends SwaggerDefaultConfiguation {

//   @Value("${deploy.version}")
   private String deployVersion = "1.0";

   @Override
   public String packageName() {
      return "com.example.consulproducer";
   }

   protected ApiInfo getApiInfo() {
      // @formatter:off 這裡資訊自己改成對應service的
      Contact contact = new Contact("Chen, Charles", "url", "charles.chen@google.com");
      return new ApiInfoBuilder()
              .title("consul-producer API")
              .version(deployVersion)
              .description("測試 API")
              .termsOfServiceUrl("Terms of service url")
              .license("Apache 2.0")
              .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
              .contact(contact)
              .build();
      // @formatter:on
   }
}
