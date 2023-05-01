package com.tarun.todo.controllers;

import com.tarun.todo.models.Todo;
import com.tarun.todo.services.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/todo")
public class TodoController {
    Logger logger = LoggerFactory.getLogger(TodoController.class);
    @Autowired
    private TodoService todoService;
    //create
    Random random = new Random();
    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo){
        int id = random.nextInt(999999);
        //create date with system default
        Date currentDate = new Date();
        logger.info("Current Date {}",currentDate);
        todo.setAddedDate(currentDate);
        logger.info("Creating Todo");
        //call service to Create todo
        todo.setId(id);
        Todo todo1 = todoService.createTodo(todo);
        return new ResponseEntity<>(todo1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getAll(){
        List<Todo> all=  todoService.getAllTodos();
        return new ResponseEntity<>(all,HttpStatus.OK);
    }

    //get single
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getSingle(@PathVariable int id){
         Todo todo = todoService.getTodo(id);
         return ResponseEntity.ok(todo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@RequestBody Todo newTodo,@PathVariable int id){
        Todo todo = todoService.updateTodo(id, newTodo);
        return ResponseEntity.ok(todo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable int id){
        todoService.deleteTodo(id);
        return ResponseEntity.ok("Todo successfully Deleted");
    }
}
