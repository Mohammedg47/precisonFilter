package com.precision_filter.precisionfilter;

import java.util.Map;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@RestController
public class APIController {

    @GetMapping("/queryAI")//ToDo add response mapping should be a string with a / ie "/joke"
    @ResponseBody
    public Map<String, Object> getResponseToText() {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = ""; //ToDo add url
    
        Map<String, Object> response = restTemplate.getForObject(apiUrl, Map.class);
        return response;  // automatically returned as JSON
    }

}

