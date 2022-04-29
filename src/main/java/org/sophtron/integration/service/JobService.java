package org.sophtron.integration.service;

import lombok.extern.slf4j.Slf4j;
import org.sophtron.integration.model.ApiDetails;
import org.sophtron.integration.model.ApiRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Map;

@Service
@Slf4j
public class JobService extends ApiService{
    public JobService(ApiDetails details){
        super(details);
    }


    public Flux<Map> getJobStatus(ApiRequest request){
        return postHeaderSpec(Endpoints.JOB_INFORMATION,request.getRequest()).retrieve().bodyToFlux(Map.class);
    }

    public Flux<String> updateJobDetails(ApiRequest request){
        String  updateType =  (String) request.getRequest().get("updateType");
        String uri ="";
        switch (updateType){
            case "security_answer":
                uri = Endpoints.JOB_UPDATE_SECURITY_ANSWER;
                break;
            case "captcha":
                uri = Endpoints.JOB_UPDATE_JOB_CAPTCHA_INPUT;
                break;
            case "token":
                uri = Endpoints.JOB_UPDATE_JOB_TOKEN_INPUT;
                break;
        }
        if("".equals(uri)) {
            return Flux.error(new RuntimeException("updateType cannot be null"));
        }
        return postHeaderSpec(uri,request.getRequest()).retrieve().bodyToFlux(String.class);
    }


}
