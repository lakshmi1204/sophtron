package org.sophtron.integration.service;

import lombok.extern.slf4j.Slf4j;
import org.sophtron.integration.model.ApiDetails;
import org.sophtron.integration.model.ApiRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Map;

@Service
@Slf4j
public class InstitutionService extends ApiService {


    public InstitutionService(ApiDetails details){
        super(details);
    }

    public Flux<Map> getInstitutions(ApiRequest requestData){
        return postHeaderSpec(Endpoints.INSTITUTION_BY_NAME,requestData.getRequest()).retrieve().bodyToFlux(Map.class);
    }

}
