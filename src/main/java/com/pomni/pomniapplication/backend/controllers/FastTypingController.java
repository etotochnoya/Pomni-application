package com.pomni.pomniapplication.backend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FastTypingController {
    @RequestMapping("/fastTyping")
    public String fastTyping() {
        return "fastTyping.html";
    }
}
