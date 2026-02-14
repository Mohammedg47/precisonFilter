package com.precision_filter.precisionfilter;

import java.util.Map;

import org.springframework.web.bind.annotation.*;

@RestController
public class APIController {

    private final BackboardService backboardService;

    public APIController(BackboardService backboardService) {
        this.backboardService = backboardService;
    }

    @PostMapping("/analyzeEmail")
    public Map<String, Object> analyze(@RequestBody Map<String, String> body) {

        String emailText = body.get("text");

        return backboardService.analyzeEmail(emailText);
    }
}
