package org.zarminta.code.entity;

public class TodoList {
    private String todo;
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TodoList(String todo) {
        this.todo = todo;
    }

    public TodoList() {
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }
}
