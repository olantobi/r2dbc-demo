package com.liferon.r2dbcdemo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TaskRepository extends ReactiveCrudRepository<Task, Integer> {
}
