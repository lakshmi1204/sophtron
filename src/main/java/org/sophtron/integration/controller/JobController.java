package org.sophtron.integration.controller;

import org.sophtron.integration.model.ApiRequest;
import org.sophtron.integration.service.JobService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.Map;

@RestController
@RequestMapping("/sophtron/job")
public class JobController {

    private JobService service;

    public JobController(final JobService pService){
        service = pService;
    }

    @PostMapping(value = "/status",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Map> getJobStatus(@RequestBody ApiRequest request){
        return service.getJobStatus(request);
    }

    @PostMapping(value = "/update",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<String> updateJobStatus(@RequestBody ApiRequest request){
        return service.updateJobDetails(request);
    }
}
