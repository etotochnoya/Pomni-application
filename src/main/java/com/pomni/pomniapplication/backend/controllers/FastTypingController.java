package com.pomni.pomniapplication.backend.controllers;

import com.pomni.pomniapplication.backend.model.InputString;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Контроллер отвечающий за обработку запросов, связанных с страницей для тренировки быстрой печати.
 */
@Controller
public class FastTypingController {
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
     * Создает объект класса InputString, устанавливает в нём текст и передает его в теле HTTP-ответа.
     * @return HTTP-ответ с статусом OK, объектом InputString в теле.
     */
    //TODO: Метод должен получать строку из базы данных и передавать её в body HTTP-ответа
    @GetMapping ("/fastTyping/data")
    @ResponseBody
    public ResponseEntity <InputString> passString(){
        InputString stringSample = new InputString();
        stringSample.setText("TEST STRING OOO AAA UWU");
        return ResponseEntity
                .ok()
                .body(stringSample);
    }
}
