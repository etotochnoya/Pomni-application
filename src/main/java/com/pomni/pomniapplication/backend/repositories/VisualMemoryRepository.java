package com.pomni.pomniapplication.backend.repositories;

import com.pomni.pomniapplication.backend.model.FastTypingString;
import com.pomni.pomniapplication.backend.model.VisualMemoryColor;
import org.springframework.data.repository.CrudRepository;

public interface VisualMemoryRepository extends CrudRepository<VisualMemoryColor, Long> {
}
