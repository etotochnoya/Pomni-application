package com.pomni.pomniapplication.backend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Контроллер отвечающий за обработку запросов, связанных с главной страницей index.
 */
@Controller
public class IndexController {
    /**
     * Метод обработчик GET-запроса с путём /index.
     * Используется чтобы показать главную страницу.
     * @return Имя представления, которое будет отображаться пользователю.
     */
    @GetMapping("/index")
    public String showMainPage() {
        return "index.html";
    }
}
