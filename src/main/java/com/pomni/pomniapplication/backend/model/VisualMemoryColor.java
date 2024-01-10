package com.pomni.pomniapplication.backend.model;

import jakarta.persistence.*;

/**
 * Модель цвета для выбора пар карточек.
 */
@Entity
@Table(name = "colors")
public class VisualMemoryColor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="color")
    private String text;

    public String getColorCode() {
        return text;
    }

    public void setColorCode(String text) {
        this.text = text;
    }
}
