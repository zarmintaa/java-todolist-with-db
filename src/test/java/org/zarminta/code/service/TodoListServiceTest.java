package org.zarminta.code.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.zarminta.code.entity.TodoList;
import org.zarminta.code.repository.TodoListRepository;
import org.zarminta.code.repository.TodoListRepositoryImpl;

import java.util.Arrays;

@DisplayName("Test Todo List Service")
public class TodoListServiceTest {
/*    public static void main(String[] args) {
        testRemoveTodoList();
    }*/

  /*  @Test
    public static void testShowTodoList(){
        TodoListRepositoryImpl todoListRepository = new TodoListRepositoryImpl();
        todoListRepository.data[0] = new TodoList("Belajar 1");
        todoListRepository.data[1] = new TodoList("Belajar 2");
        todoListRepository.data[2] = new TodoList("Belajar 3");
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.showTodoList();
    }*/

    @Test
    public void testShowTodoList(){
        TodoListRepositoryImpl todoListRepository = new TodoListRepositoryImpl();
        todoListRepository.data[0] = new TodoList("Belajar 1");
        todoListRepository.data[1] = new TodoList("Belajar 2");
        todoListRepository.data[2] = new TodoList("Belajar 3");

        Assertions.assertEquals(todoListRepository.data[0].getTodo(), "Belajar 1");
        Assertions.assertEquals(todoListRepository.data[1].getTodo(), "Belajar 2");
        Assertions.assertEquals(todoListRepository.data[2].getTodo(), "Belajar 3");
    }

    @Test
    public void testAddTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.addTodoList("Belajar 1");
        todoListService.addTodoList("Belajar 2");
        todoListService.addTodoList("Belajar 3");

//        todoListService.showTodoList();
        Assertions.assertEquals(todoListRepository.getAll()[0].getTodo(), "Belajar 1");
        Assertions.assertEquals(todoListRepository.getAll()[1].getTodo(), "Belajar 2");
        Assertions.assertEquals(todoListRepository.getAll()[2].getTodo(), "Belajar 3");

    }

    @Test
    public  void testRemoveTodoList() {
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.addTodoList("Belajar 1");
        todoListService.addTodoList("Belajar 2");
        todoListService.addTodoList("Belajar 3");

        todoListService.showTodoList();
        todoListService.removeTodoList(2);
        todoListService.removeTodoList(1);

        todoListService.showTodoList();
        Assertions.assertEquals(todoListRepository.getAll()[0].getTodo(), "Belajar 3");
        Assertions.assertThrows(NullPointerException.class, () -> {
            todoListRepository.getAll()[5].getTodo();
        });

    }
}
