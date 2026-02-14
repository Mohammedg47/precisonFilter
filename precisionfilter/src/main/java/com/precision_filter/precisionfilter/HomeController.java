package com.precision_filter.precisionfilter;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";  // returns index.html from templates
    }
    
}
