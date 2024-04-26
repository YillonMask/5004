package com.rateneuprofessor.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

public class JDBCTools {
  private static DataSource dataSource;

  static {
    dataSource = new ComboPooledDataSource("rate-my-professor");
  }

  public static Connection getConnection() {
    Connection conn = null;
    try {
      conn = dataSource.getConnection();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return conn;
  }

  public static void release(ResultSet resultSet, Statement statement, Connection connection) {
    try {
      if (resultSet != null) { resultSet.close();}
      if (statement != null) { statement.close();}
      if (connection != null) { connection.close();}
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
