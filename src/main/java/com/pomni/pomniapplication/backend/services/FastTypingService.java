package com.pomni.pomniapplication.backend.services;

import com.pomni.pomniapplication.backend.model.FastTypingString;
import com.pomni.pomniapplication.backend.repositories.FastTypingStringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FastTypingService {
    private FastTypingStringRepository repository;

    @Autowired
    public FastTypingService (FastTypingStringRepository repository) {
        this.repository=repository;
    }

    public FastTypingString getRandomString() {
        long count = repository.count();
        long randomId = (long) (Math.random() * count) + 1;
        return repository.findById(randomId).orElse(null);
    }
}
