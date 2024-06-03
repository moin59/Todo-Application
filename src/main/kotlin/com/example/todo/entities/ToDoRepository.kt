package com.example.todo.entities;

import org.springframework.data.jpa.repository.JpaRepository

interface ToDoRepository : JpaRepository<ToDo, Long> {
}