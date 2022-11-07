package org.zarminta.code.util;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseUtilTest {
    @Test
    void testConnection() throws SQLException {
        HikariDataSource dataSource = DatabaseUtil.getDataSource();
        Connection connection = dataSource.getConnection();
        dataSource.close();
        connection.close();
    }
}
