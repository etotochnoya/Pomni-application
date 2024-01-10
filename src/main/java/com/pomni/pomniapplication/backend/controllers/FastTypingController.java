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
 * Аннотация @Controller отмечает класс как контроллер для Spring
 */
@Controller
public class FastTypingController {

    /* Сервис для работы с объектами быстрой печати.
    Должен быть внедрен в класс через конструктор
     */
    private final FastTypingService fastTypingService;

    /**
     * Конструктор принимающий объект сервиса быстрой печати
     * Аннотация @Autowired указывает на то, что Spring автоматически вставит параметр из Spring контекста.
     * @param fastTypingService Сервис для работы с объектами быстрой печати
     */
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
     * Возвращает случайную строку используя getRandomString из сервиса FastTypingService
     * @return HTTP-ответ с статусом OK, объектом FastTypingString в теле.
     */
    @GetMapping ("/fastTyping/data")
    @ResponseBody
    public ResponseEntity <FastTypingString> passString(){
        return ResponseEntity
                .ok()
                .body(fastTypingService.getRandomString());
    }
}
