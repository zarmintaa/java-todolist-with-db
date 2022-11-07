package org.zarminta.code.repository;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zarminta.code.entity.TodoList;
import org.zarminta.code.util.DatabaseUtil;

import javax.sql.DataSource;

public class TodoListRepositoryImplTest {
    private HikariDataSource dataSource;
    private TodoListRepository todoListRepository;
    @BeforeEach
    void setUp(){
        dataSource = DatabaseUtil.getDataSource();
        todoListRepository = new TodoListRepositoryImpl(dataSource);
    }

    @Test
    void testAdd(){
        TodoList todoList = new TodoList();
        todoList.setTodo("Mamang 2");
        todoListRepository.add(todoList);
    }

    @Test
    void testRemove(){
        System.out.println(todoListRepository.remove(1));
        System.out.println(todoListRepository.remove(2));
        System.out.println(todoListRepository.remove(3));
        System.out.println(todoListRepository.remove(4));
    }

    @Test
    void testGetAll() {
        todoListRepository.add(new TodoList("mamang"));
        todoListRepository.add(new TodoList("geming"));
        todoListRepository.add(new TodoList("badas"));

        TodoList[] todoLists = todoListRepository.getAll();
        for (var todo:todoLists){
            System.out.println(todo.getId() + " : " + todo.getTodo());
        }
    }

    @AfterEach
    void tearDown(){
        dataSource.close();
    }
}
