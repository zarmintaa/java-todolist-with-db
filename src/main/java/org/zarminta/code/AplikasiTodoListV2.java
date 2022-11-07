package org.zarminta.code;

import org.zarminta.code.repository.TodoListRepository;
import org.zarminta.code.repository.TodoListRepositoryImpl;
import org.zarminta.code.service.TodoListService;
import org.zarminta.code.service.TodoListServiceImpl;
import org.zarminta.code.view.TodoListView;

public class AplikasiTodoListV2 {
    public static void main(String[] args) {
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListView(todoListService);

        todoListView.showTodoList();

    }
}