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
    @PostMapping(value="/",consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Map> getUserInstitutionsByUser(@RequestBody ApiRequest data){
       return  userService.getUserInstitutionsByUser(data);
    }

    @PostMapping(value="/account",consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Map> getUserInstitutionAccountsByID(@RequestBody ApiRequest data){
        return userService.getUserInstitutionAccount(data);
    }

    @PostMapping(value="/account/transaction",consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Map> getTransactionsForAccount(@RequestBody ApiRequest data){
        return userService.getAccountTransactionByDate(data);
    }



}
