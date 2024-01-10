package com.pomni.pomniapplication.backend.services;

import com.pomni.pomniapplication.backend.model.VisualMemoryColor;
import com.pomni.pomniapplication.backend.repositories.VisualMemoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VisualMemoryService {
    private VisualMemoryRepository repository;

    @Autowired
    public VisualMemoryService (VisualMemoryRepository repository) {
        this.repository=repository;
    }

    /**
     * Возвращает цвета случайно для
     * выбранного количества пар карточек
     * @param couples количество пар
     * @return
     */
    public List<VisualMemoryColor> getRandomColors(int couples) {
        long count = repository.count();
        List<VisualMemoryColor> colors = new ArrayList<VisualMemoryColor>();
        colors.add(repository.findById(createRndId(count)).orElse(null));
        return colors;
    }

    private long createRndId(long count) {
        return  (long) (Math.random() * count) + 1;
    }
}
