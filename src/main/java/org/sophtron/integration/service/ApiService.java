package org.sophtron.integration.service;

import lombok.extern.slf4j.Slf4j;
import org.sophtron.integration.model.ApiDetails;
import org.sophtron.integration.utils.Utils;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.util.Map;

@Slf4j
public class ApiService {


    private ApiDetails _details;
    private WebClient client ;


    protected ApiDetails getApiDetails(){
        return _details;
    }

    public ApiService(ApiDetails details){
        _details = details;
        HttpClient httpClient = HttpClient.newConnection();
        ReactorClientHttpConnector connector = new ReactorClientHttpConnector(httpClient);
        client = WebClient.builder().clientConnector(connector).baseUrl(getApiDetails().getApiUrl()).build();
    }


    protected String encodeUri(String uri, HttpMethod method){
        try {
         return Utils.getSignature(getApiDetails().getSecrets().getAccessKey(),
                        String.format("%s\n%s",method.name().toUpperCase(),uri));
        }catch (Exception e){
            log.error("Could not generate the header {}",e.getMessage());
        }
        return null;
    }

    protected WebClient getClient(){
        return client;
    }

    protected WebClient.RequestHeadersSpec postHeaderSpec(String uri, Map<String,Object> parameters){
        WebClient.RequestHeadersSpec<?> headerSpec = getClient().post().uri(uri).
                header("Authorization",generateAuthorizationHeader(uri)).body(BodyInserters.fromValue(parameters));
        return headerSpec;
    }

    /**
     * Generated header as per the python code reference
     * using HMCA SHA256
     * @param url
     * @return
     */

    protected String generateAuthorizationHeader(String url){
      String apiName = url.substring(url.lastIndexOf("/")).toLowerCase();
      return  String.format("%s:%s:%s:%s",getApiDetails().getSecrets().getAuthHeaderPrefix() ,
                getApiDetails().getSecrets().getUserId(),encodeUri(apiName, HttpMethod.POST),apiName);
    }


}
