package com.tarun.todo.services;

import com.tarun.todo.models.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TodoService {

    //create Todo Method
    Logger logger = LoggerFactory.getLogger(TodoService.class);
    List<Todo> todos = new ArrayList<>();
    public Todo createTodo(Todo todo){
        todos.add(todo);
        logger.info("Todos {}",this.todos);
        return todo;
    }

    public List<Todo> getAllTodos() {
        return todos;
    }

    public Todo getTodo(int id) {
        Todo todo = todos.stream().filter(t->id==t.getId()).findAny().get();
        logger.info("TODO :{}",todo);
        return todo;
    }

    public Todo updateTodo(int id, Todo newTodo) {
        List<Todo> newUpdatedList = todos.stream().map(t -> {
            if (t.getId() == id) {
                t.setTitle(newTodo.getTitle());
                t.setContent(newTodo.getContent());
                t.setStatus(newTodo.getStatus());
                return t;
            } else {
                return t;
            }
        }).collect(Collectors.toList());
        todos = newUpdatedList;
        newTodo.setId(id);
        return newTodo;
    }

    public void deleteTodo(int id) {
        logger.info("DELETING TODO");
        List<Todo> collect = todos.stream().filter(t -> t.getId() != id).collect(Collectors.toList());
        todos = collect;
    }
}
