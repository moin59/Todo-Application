package com.example.todo.controllers

import com.example.todo.entities.ToDo
import com.example.todo.entities.ToDoRepository
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/todos")
class ToDoController(val todoRepository: ToDoRepository) {

    @PostMapping
    fun newTodo(@RequestBody todo: ToDo): ToDo {
        return todoRepository.save(todo)
    }

    @GetMapping
    fun getTodos() = todoRepository.findAll()

    @GetMapping("/{id}")
    fun getTodoById(@PathVariable id: Long) = todoRepository.findById(id)

    @PutMapping("/{id}")
    fun updateTodoById(@PathVariable id: Long, @RequestBody todo: ToDo): ToDo? {

        val oldTodo = todoRepository.findById(id)

        if (oldTodo.isEmpty) {
            return oldTodo.get()
        }

        return todoRepository.save(todo)
    }

    @DeleteMapping("/{id}")
    fun deleteTodoById(@PathVariable id: Long) {
        val oldTodo = todoRepository.findById(id)

        if (oldTodo.isPresent) {
            todoRepository.deleteById(id)
        }else{
            println("Todo not found with id: $id")
        }
    }
}