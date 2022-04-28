package org.sophtron.integration.service;

import org.sophtron.integration.model.ApiDetails;
import org.springframework.stereotype.Service;

@Service
public class JobTracker extends ApiService{
    public JobTracker(ApiDetails details){
        super(details);
    }

}
