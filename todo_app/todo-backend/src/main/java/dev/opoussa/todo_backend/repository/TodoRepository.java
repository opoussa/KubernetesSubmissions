package dev.opoussa.todo_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.opoussa.todo_backend.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
}
