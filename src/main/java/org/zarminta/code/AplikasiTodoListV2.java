package org.zarminta.code;

import org.zarminta.code.repository.TodoListRepository;
import org.zarminta.code.repository.TodoListRepositoryImpl;
import org.zarminta.code.service.TodoListService;
import org.zarminta.code.service.TodoListServiceImpl;
import org.zarminta.code.util.DatabaseUtil;
import org.zarminta.code.view.TodoListView;

import javax.sql.DataSource;

public class AplikasiTodoListV2 {
    public static void main(String[] args) {
        DataSource dataSource = DatabaseUtil.getDataSource();
        TodoListRepository todoListRepository = new TodoListRepositoryImpl(dataSource);
      /*  TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListView(todoListService);

        todoListView.showTodoList();*/

    }
}