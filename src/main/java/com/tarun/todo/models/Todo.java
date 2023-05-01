package com.tarun.todo.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Todo {
    private String Title;
    private int id;
    private String content;
    private Status status;

    private Date addedDate;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date todoDate;

    public Todo(String title, int id, String content, Status status,Date addedDate,Date todoDate) {
        Title = title;
        this.id = id;
        this.content = content;
        this.status = status;
        this.addedDate = addedDate;
        this.todoDate = todoDate;
    }
    public Todo(){

    }
    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public Date getTodoDate() {
        return todoDate;
    }

    public void setTodoDate(Date todoDate) {
        this.todoDate = todoDate;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "Title='" + Title + '\'' +
                ", id=" + id +
                ", content='" + content + '\'' +
                ", status=" + status +
                ", addedDate=" + addedDate +
                ", todoDate=" + todoDate +
                '}';
    }
}
