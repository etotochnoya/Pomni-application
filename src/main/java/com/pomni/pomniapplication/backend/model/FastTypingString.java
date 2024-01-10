package com.pomni.pomniapplication.backend.model;

import jakarta.persistence.*;

/**
 * Модель строки для быстрой печати.
 * Аннотация @Entity указывает что класс является сущностью базы данных.
 * Аннотация @Table указывает имя таблицы в базе данных.
 */
@Entity
@Table(name = "texts")
public class FastTypingString {
    /**
     * Поле id.
     * Аннотация @Id чтобы пометить первичный ключ.
     * Аннотация @GeneratedValue чтобы указать способ генерации значения для поля id. IDENTITY говорит о том, что это поле auto_increment.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


     // Аннотация @Column указывает что поле text будет соответствовать столбцу с именем "string" в базе данных.
    @Column(name="string")
    private String text;

    /**
     * Возвращает строку текста.
     * @return Строка текста.
     */
    public String getText() {
        return text;
    }

    /**
     * Устанавливает переданную строку текста.
     * @param text переданная строка текста.
     */
    public void setText(String text) {
        this.text = text;
    }
}
