package com.example.todo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.todo.service.TodoJpaService;
import com.example.todo.model.Todo;

@RestController
public class TodoController{
    @Autowired
    TodoJpaService tjs;
    @GetMapping("/todos")
    public ArrayList<Todo> getallTodos(){
        return tjs.getallTodos();
    }
    @GetMapping("/todos/{id}")
    public Todo getTodoById(@PathVariable ("id") int id){
        return tjs.getTodoById(id);
    }
    @PostMapping("/todos")
    public Todo addTodo(@RequestBody Todo todo){
        return tjs.addTodo(todo);
    }
    @PutMapping("/todos/{id}")
    public Todo updateTodo(@PathVariable ("id") int id , @RequestBody Todo todo){
        return tjs.updateTodo(id, todo);
    }
    @DeleteMapping("/todos/{id}")
    public void deleteTodo(@PathVariable ("id") int id){
        tjs.deleteTodo(id);
    }
}
