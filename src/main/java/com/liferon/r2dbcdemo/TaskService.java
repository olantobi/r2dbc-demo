package com.liferon.r2dbcdemo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository repository;

    public Boolean isValid(final Task task) {
        return task != null && task.getDescription() != null && !task.getDescription().isBlank();
    }

    public Flux<?> getAllTasks() {
        return this.repository.findAll();
    }

    public Mono<?> createTask(final Task task) {
        return this.repository.save(task);
    }

    @Transactional
    public Mono<?> updateTask(final Task task) {
        return this.repository.findById(task.getId())
                .flatMap(t -> {
                    t.setDescription(task.getDescription());
                    t.setCompleted(task.isCompleted());
                    return this.repository.save(t);
                });
    }

    @Transactional
    public Mono<?> deleteTask(final int id) {
        return this.repository.findById(id)
                .flatMap(this.repository::delete);
    }
}
