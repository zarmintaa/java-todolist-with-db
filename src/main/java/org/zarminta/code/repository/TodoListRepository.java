package org.zarminta.code.repository;

import org.zarminta.code.entity.TodoList;

public interface TodoListRepository {
    TodoList[] getAll();
    void add(TodoList todoList);
    boolean remove(Integer number);
}
