package com.pomni.pomniapplication.backend.services;

import com.pomni.pomniapplication.backend.model.FastTypingString;
import com.pomni.pomniapplication.backend.repositories.FastTypingStringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Сервис для работы с моделью FastTypingString содержащий бизнес-логику для работы с базой данных.
 * Стереотипная аннотация @Service помечает класс как сервис для Spring.
 */
@Service
public class FastTypingService {

    /* Репозиторий для работы с объектами FastTypingString.
    Должен быть внедрен в класс через конструктор
     */
    private FastTypingStringRepository repository;

    /**
     * Конструктор принимающий объект репозитория.
     * Аннотация @Autowired указывает на то, что Spring автоматически вставит параметр из Spring контекста.
     * @param repository Репозиторий для работы с строками быстрой печати.
     */
    @Autowired
    public FastTypingService (FastTypingStringRepository repository) {
        this.repository=repository;
    }

    /**
     * Функция для получения случайной строки из базы данных.
     * Находит количество записей и затем генерируется случайное число id от 1 до количества записей.
     * Возвращает FastTypingString с выбранным случайным id или null если строка не найдена.
     * @return FastTypingString с случайным id или null.
     */
    public FastTypingString getRandomString() {
        long count = repository.count();
        long randomId = (long) (Math.random() * count) + 1;
        return repository.findById(randomId).orElse(null);
    }
}
