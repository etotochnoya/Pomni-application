package com.pomni.pomniapplication.backend.controllers;

import com.pomni.pomniapplication.backend.model.InputString;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FastTypingController {
    @RequestMapping("/fastTyping")
    public String fastTyping() {
        return "fastTyping.html";
    }
    @GetMapping ("/fastTyping/data")
    @ResponseBody
    public ResponseEntity <InputString> string(){
        InputString s = new InputString();
        s.setText("TEST STRING OOO AAA UUU");
        return ResponseEntity
                .ok()
                .body(s);
    }
}
