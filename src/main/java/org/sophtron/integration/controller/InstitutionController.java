package org.sophtron.integration.controller;

import org.sophtron.integration.model.ApiRequest;
import org.sophtron.integration.service.InstitutionService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.Map;

@RestController
@RequestMapping("/sophtron/institutions")
public class InstitutionController {

    private InstitutionService service;

    public InstitutionController(InstitutionService pService){
        service = pService;
    }

    @PostMapping(value="/",consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Map> getInstitutions(@RequestBody ApiRequest request){
         return service.getInstitutions(request);

    }
}
