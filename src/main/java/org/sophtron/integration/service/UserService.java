package org.sophtron.integration.service;

import lombok.extern.slf4j.Slf4j;
import org.sophtron.integration.model.ApiDetails;
import org.sophtron.integration.model.ApiRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
@Slf4j
public class UserService extends ApiService {

    public UserService(ApiDetails details){
        super(details);
    }

    /**
     * Returns JobId and UserInstitution
     * @param request
     * @return
     */
    public Flux<Map> createUserInstitution(ApiRequest request) {
        WebClient.RequestHeadersSpec<?> headersSpec = postHeaderSpec(Endpoints.CREATE_USER_INSTITUTION,request.getRequest());
        //Transforming the data here if needed before sending the response.

        return headersSpec.exchangeToFlux(v->
        {
            if(v.statusCode()== HttpStatus.OK)
            {
            return v.bodyToFlux(Map.class);
            }
            else {
                log.debug("Status code is not 200 , instead it is  {}", v.statusCode());
                return Flux.error(new RuntimeException("error"));
            }
        });


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

    public Mono<String> deleteUserInstitution(ApiRequest request){
        return postHeaderSpec(Endpoints.DELETE_USER_INSTITUTION,request.getRequest()).retrieve().bodyToMono(String.class);
    }





}
