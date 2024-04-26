package com.rateneuprofessor.repository.impl;

import com.rateneuprofessor.entity.Campus;
import com.rateneuprofessor.repository.CampusRepository;
import com.rateneuprofessor.utils.JDBCTools;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CampusRepositoryImpl implements CampusRepository {

  @Override
  public List<Campus> getAllCampus() {
    Connection connection = null;
    PreparedStatement statement = null;
    String sql = "SELECT * FROM campus";
    ResultSet resultSet = null;
    List<Campus> campus = new ArrayList<>();

    try {
      connection = JDBCTools.getConnection();
      statement = connection.prepareStatement(sql);
      resultSet = statement.executeQuery();
      while(resultSet.next()) {
        campus.add(new Campus(
            resultSet.getInt("campus_id"),
            resultSet.getString("campus_name")
        ));
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      JDBCTools.release(resultSet, statement, connection);
    }

    return campus;
  }
}
