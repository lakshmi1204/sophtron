package org.sophtron.integration.service;

import lombok.extern.slf4j.Slf4j;
import org.sophtron.integration.model.ApiDetails;
import org.sophtron.integration.model.ApiRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Map;

@Service
@Slf4j
public class UserService extends ApiService {

    public UserService(ApiDetails details){
        super(details);
    }


    public void createUserInstitution() {

    }


    public Flux<Map> getUserInstitutionsByUser(ApiRequest data){
        return  postHeaderSpec(Endpoints.INSTITUTIONS_BY_USER,data.getRequest()).retrieve().bodyToFlux(Map.class);
    }


    public Flux<Map> getUserInstitutionAccount(ApiRequest data) {
        return postHeaderSpec(Endpoints.USER_INSTITUTION_ACCOUNTS_BY_ID,data.getRequest()).retrieve().bodyToFlux(Map.class);
    }

    public Flux<Map> getAccountTransactionByDate(ApiRequest data){
        return postHeaderSpec(Endpoints.USER_INSTITUTION_ACCOUNT_TRANSACTION_BY_DATE,data.getRequest()).retrieve().bodyToFlux(Map.class);
    }


}
