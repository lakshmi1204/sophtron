package org.sophtron.integration.config;

import org.sophtron.integration.model.ApiDetails;
import org.sophtron.integration.model.ApiSettings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SophtronConfig {

    /**
     * Swagger configuration.
     * @return
     */
    @Bean
    public Docket allocateSwaggerSetting(){
        return new Docket(DocumentationType.SWAGGER_2).select().
                apis(RequestHandlerSelectors.basePackage("org.sophtron.integration.controller")).paths(PathSelectors.any()).build();
    }

    @Bean
    public ApiSettings allocateApiDirectSettings(@Value("${sophtron.api.auth.direct.userId}") final String userId,
            @Value("${sophtron.api.auth.direct.accessKey}") final String accessKey,
            @Value("${sophtron.api.auth.direct.headerPrefix}") final String authHeaderPrefix){
        return new ApiSettings(userId,accessKey,authHeaderPrefix);
    }

    @Bean
    public ApiDetails allocateApiDetails(ApiSettings settings,@Value("${sophtron.api.endpoint}")String apiEndpoint){
        return new ApiDetails(apiEndpoint,settings);
    }







}
