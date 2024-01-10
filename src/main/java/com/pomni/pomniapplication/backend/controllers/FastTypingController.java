package com.pomni.pomniapplication.backend.controllers;

import com.pomni.pomniapplication.backend.model.FastTypingString;
import com.pomni.pomniapplication.backend.services.FastTypingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Контроллер отвечающий за обработку запросов, связанных с страницей для тренировки быстрой печати.
 */
@Controller
public class FastTypingController {
    private final FastTypingService fastTypingService;

    @Autowired
    public FastTypingController (FastTypingService fastTypingService) {
        this.fastTypingService = fastTypingService;
    }
    /**
     * Метод обработчик GET-запроса с путём /fastTyping.
     * Используется чтобы показать страницу быстрой печати.
     * @return Имя представления, которое будет отображаться пользователю
     */
    @GetMapping("/fastTyping")
    public String showTypingPage() {
        return "fastTyping.html";
    }

    /**
     * Метод обработчик GET-запроса с путём /fastTyping/data.
     * Используется для передачи строки на страницу быстрой печати.
     * @return HTTP-ответ с статусом OK, объектом InputString в теле.
     */
    @GetMapping ("/fastTyping/data")
    @ResponseBody
    public ResponseEntity <FastTypingString> passString(){
        return ResponseEntity
                .ok()
                .body(fastTypingService.getRandomString());
    }

    public int getRandomID(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
