package com.pomni.pomniapplication.backend.model;

/**
 * Модель строки для быстрой печати
 */
public class InputString {
    /**
     * Поле текста
     */
    private String text;

    /**
     * Возвращает строку текста
     * @return Строка текста
     */
    public String getText() {
        return text;
    }

    /**
     * Устанавливает переданную строку текста
     * @param text переданная строка текста
     */
    public void setText(String text) {
        this.text = text;
    }
}
