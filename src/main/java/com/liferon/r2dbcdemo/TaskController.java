package com.liferon.r2dbcdemo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService service;
    
    @GetMapping
    public ResponseEntity<?> get() {
        return ResponseEntity.ok(this.service.getAllTasks());
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Task task) {
        return service.isValid(task)
                ? ResponseEntity.ok(this.service.createTask(task))
                : ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<?> put(@RequestBody Task task) {
        return service.isValid(task)
                ? ResponseEntity.ok(this.service.updateTask(task))
                : ResponseEntity.badRequest().build();
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam int id) {
        return id > 0 ? ResponseEntity.ok(this.service.deleteTask(id))
                : ResponseEntity.badRequest().build();
    }
}
