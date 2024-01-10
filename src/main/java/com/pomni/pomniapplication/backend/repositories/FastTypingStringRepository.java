package com.pomni.pomniapplication.backend.repositories;

import com.pomni.pomniapplication.backend.model.FastTypingString;
import org.springframework.data.repository.CrudRepository;

/**
 * FastTypingStringRepository наследуется от CrudRepository и предоставляет набор стандартных CRUD операций.
 * Используется для работы с базой данных
 * Spring Data сам создает имплементацию интерфейса при использовании dependency injection
 */
public interface FastTypingStringRepository extends CrudRepository<FastTypingString, Long> {
}
