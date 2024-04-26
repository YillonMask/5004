package com.rateneuprofessor.repository.impl;

import com.rateneuprofessor.entity.Course;
import com.rateneuprofessor.repository.CourseRepository;
import com.rateneuprofessor.utils.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseRepositoryImpl implements CourseRepository {
    @Override
    public void addCourse(String courseName, Integer professorId, String courseCode, Integer campusId) {
        // add course to database
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String query = "INSERT INTO courses (course_name, professor_id, course_code, campus_id) VALUES (?, ?, ?, ?)";
        try {
            connection = JDBCTools.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, courseName);
            preparedStatement.setInt(2, professorId);
            preparedStatement.setString(3, courseCode);
            preparedStatement.setInt(4, campusId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCTools.release(null, preparedStatement, connection);
        }
    }

    @Override
    public List<Course> searchCourseByName(String name) {
        // search course by name
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String query = "SELECT courses.*, professors.*\n" +
                        "FROM courses\n" +
                        "JOIN professors ON courses.professor_id = professors.professor_id\n" +
                        "WHERE courses.course_name LIKE ?;";
        ResultSet resultSet = null;
        List<Course> courses = new ArrayList<>();
        try {
            connection = JDBCTools.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, '%' + name + '%');
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Course course = new Course(
                    resultSet.getInt("course_id"),
                    resultSet.getString("course_name"),
                    resultSet.getString("course_code"),
                    resultSet.getInt("professor_id"),
                    resultSet.getString("professors.name"),
                    resultSet.getInt("campus_id"),
                    resultSet.getDouble("courses.rating")
                );
                courses.add(course);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCTools.release(null, preparedStatement, connection);
        }
        return courses;
    }

    @Override
    public List<Course> searchCourseByCode(String code) {
        // search course by code
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String query = "SELECT courses.*, professors.*\n" +
                        "FROM courses\n" +
                        "JOIN professors ON courses.professor_id = professors.professor_id\n" +
                        "WHERE courses.course_code LIKE ?;";
        ResultSet resultSet = null;
        List<Course> courses = new ArrayList<>();
        try {
            connection = JDBCTools.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, '%' + code + '%');
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Course course = new Course(
                    resultSet.getInt("course_id"),
                    resultSet.getString("course_name"),
                    resultSet.getString("course_code"),
                    resultSet.getInt("professor_id"),
                    resultSet.getString("professors.name"),
                    resultSet.getInt("campus_id"),
                    resultSet.getDouble("courses.rating")
                );
                courses.add(course);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCTools.release(null, preparedStatement, connection);
        }
        return courses;
    }

    @Override
    public void updateRating(Integer courseId) {
        // update rating
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String query = "UPDATE courses\n" +
                        "SET rating = (SELECT AVG(rating) FROM reviews WHERE course_id = ?)\n" +
                        "WHERE course_id = ?;";
        try {
            connection = JDBCTools.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, courseId);
            preparedStatement.setInt(2, courseId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCTools.release(null, preparedStatement, connection);
        }
    }

    @Override
    public void deleteCourse(Integer courseId) {
        // delete course
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String query = "DELETE FROM courses WHERE course_id = ?;";
        try {
            connection = JDBCTools.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, courseId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCTools.release(null, preparedStatement, connection);
        }
    }
}
