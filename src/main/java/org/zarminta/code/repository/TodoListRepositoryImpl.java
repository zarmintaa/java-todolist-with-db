package org.zarminta.code.repository;

import org.zarminta.code.entity.TodoList;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodoListRepositoryImpl implements TodoListRepository{

    private DataSource dataSource;

    public TodoListRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public TodoList[] getAll() {
        String sql = "SELECT id, todo FROM todolist";
        try(Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
            List<TodoList>  list = new ArrayList<>();
            while (resultSet.next()){
                TodoList todoList = new TodoList();
                todoList.setId(resultSet.getInt("id"));
                todoList.setTodo(resultSet.getString("todo"));
                list.add(todoList);
            }
            return list.toArray(new TodoList[]{});
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(TodoList todoList) {
        String sql = "INSERT INTO todolist(todo) VALUES (?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, todoList.getTodo());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    private boolean isExist(Integer number){
        String sql = "SELECT id FROM todolist WHERE id = ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, number);
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()){
                    return true;
                } else {
                    return false;
                }
            }
        } catch (SQLException exception){
            throw  new RuntimeException(exception);
        }
    }

    @Override
    public boolean remove(Integer number) {
        if (isExist(number)){
            String sql = "DELETE FROM todolist WHERE id = ?";
            try(Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setInt(1, number);
                preparedStatement.executeUpdate();
                return true;
            } catch (SQLException e){
                throw new RuntimeException(e);
            }
        } else {
            return false;
        }
    }
}
