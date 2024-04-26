package com.rateneuprofessor.repository.impl;

import com.rateneuprofessor.entity.Professor;
import com.rateneuprofessor.repository.ProfessorRepository;

import com.rateneuprofessor.utils.JDBCTools;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfessorRepositoryImpl implements ProfessorRepository {
    @Override
    public void addProfessor(String name, Integer campusId) {
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "INSERT INTO professors (name, campus_id) VALUES (?, ?)";
        try{
            connection = JDBCTools.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setInt(2, campusId);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCTools.release(null, statement, connection);
        }
    }

    @Override
    public List<Professor> searchProfessorByName(String name) {
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "SELECT * FROM professors WHERE name LIKE ?";
        ResultSet resultSet = null;
        List<Professor> professors = new ArrayList<>();
        // search for professor by name
        try{
            connection = JDBCTools.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + name + "%");
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Professor professor = new Professor(
                    resultSet.getInt("professor_id"),
                    resultSet.getString("name"),
                    resultSet.getInt("campus_id"),
                    resultSet.getDouble("rating")
                );
                professors.add(professor);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCTools.release(resultSet, statement, connection);
        }

        return professors;
    }

    @Override
    public Integer getProfessorIdByCourseId(Integer courseId) {
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "SELECT professor_id FROM courses WHERE course_id = ?";
        ResultSet resultSet = null;
        Integer professorId = null;
        try{
            connection = JDBCTools.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, courseId);
            resultSet = statement.executeQuery();
            if(resultSet.next()) {
                professorId = resultSet.getInt("professor_id");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCTools.release(resultSet, statement, connection);
        }

        return professorId;
    }

    @Override
    public void updateRating(Integer professorId) {
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "UPDATE professors SET rating = (SELECT AVG(rating) " +
                "FROM reviews WHERE professor_id = ?) WHERE professor_id = ?";
        try{
            connection = JDBCTools.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, professorId);
            statement.setInt(2, professorId);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCTools.release(null, statement, connection);
        }
    }

    @Override
    public void deleteProfessor(Integer professorId) {
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "DELETE FROM professors WHERE professor_id = ?";
        try{
            connection = JDBCTools.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, professorId);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCTools.release(null, statement, connection);
        }
    }
}
