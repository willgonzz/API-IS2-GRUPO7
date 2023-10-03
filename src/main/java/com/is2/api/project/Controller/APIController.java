package com.is2.api.project.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class APIController {
    
    @PostMapping(value = "home")
    public String home()
    {
        return "Welcome from secure endpoint";
    }
}
