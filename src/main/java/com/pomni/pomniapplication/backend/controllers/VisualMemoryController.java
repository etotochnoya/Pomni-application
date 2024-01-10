package com.pomni.pomniapplication.backend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Контроллер отвечающий за обработку запросов, связанных с страницей для тренировки визуальной памяти.
 */
@Controller
public class VisualMemoryController {
    /**
     * Метод обработчик GET-запроса с путём /visual.
     * Используется чтобы показать страницу визуальной памяти.
     * @return Имя представления, которое будет отображаться пользователю.
     */
    @GetMapping("/visual")
    public String showVisualMemoryPage() {
        return "visual.html";
    }
}
