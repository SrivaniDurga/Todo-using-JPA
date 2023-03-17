package com.example.todo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import com.example.todo.repository.TodoJpaRepository;
import com.example.todo.repository.TodoRepository;
import com.example.todo.model.Todo;
@Service
public class TodoJpaService implements TodoRepository{
    @Autowired
    TodoJpaRepository tjp;
    @Override
    public ArrayList<Todo> getallTodos(){
        List<Todo> t = tjp.findAll();
        ArrayList<Todo> ts = new ArrayList<>(t);
        return ts;
    }
    @Override
    public Todo getTodoById(int id){
        try{
            Todo n = tjp.findById(id).get();
            return n;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    @Override
    public Todo addTodo(Todo todo){
        tjp.save(todo);
        return todo;
    }
    @Override
    public Todo updateTodo(int id , Todo todo){
        try{
            Todo t = tjp.findById(id).get();
            if(todo.getTodo() != null){
                t.setTodo(todo.getTodo());
            }
            if(todo.getPriority() != null){
                t.setPriority(todo.getPriority());
            }
            if(todo.getStatus() != null){
                t.setStatus(todo.getStatus());
            }
            tjp.save(t);
            return t;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    @Override
    public void deleteTodo(int id){
        try{
            tjp.deleteById(id);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}