package org.sophtron.integration.controller;

import org.sophtron.integration.model.ApiRequest;
import org.sophtron.integration.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.Map;

@RestController
@RequestMapping("/sophtron/user")
public class UserController {

    private UserService userService;

    public  UserController(final UserService pService){
        userService = pService;
    }

    @Deprecated
    @PostMapping(value="",consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Map> getUserInstitutionsByUser(@RequestBody ApiRequest request){
       return  userService.getUserInstitutionsByUser(request);
    }


    @PostMapping(value="/account",consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Map> getUserInstitutionAccountsByID(@RequestBody ApiRequest request){
        return userService.getUserInstitutionAccount(request);
    }

    @PostMapping(value="/account/transaction",consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Map> getTransactionsForAccount(@RequestBody ApiRequest request){
        return userService.getAccountTransactionByDate(request);
    }

    @PostMapping(value="/create",consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Map> createUserInstitution(@RequestBody ApiRequest request){
        return userService.createUserInstitution(request);
    }





}
