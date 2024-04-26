package com.rateneuprofessor.repository.impl;

import com.rateneuprofessor.entity.Comment;
import com.rateneuprofessor.repository.CommentRepository;
import com.rateneuprofessor.utils.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CommentRepositoryImpl implements CommentRepository {
    @Override
    public void addComment(Integer courseId, Integer professorId, Integer rating,String content, LocalDateTime datePosted) {
        // add comment to database

            Connection connection = null;
            PreparedStatement statement = null;
            String sql = "INSERT INTO reviews (course_id, professor_id, rating, comment,date_posted) VALUES (?, ?,?, ?, ?)";
            try{
                connection = JDBCTools.getConnection();
                statement = connection.prepareStatement(sql);
                statement.setInt(1, courseId);
                statement.setInt(2, professorId);
                statement.setInt(3, rating);
                statement.setString(4, content);
                statement.setObject(5, datePosted);
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                JDBCTools.release(null, statement, connection);
            }

    }

    @Override
    public List<Comment> getCommentsByProfessorId(Integer professorId) {
        // get comments by professor id
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "SELECT*\n" +
                "FROM reviews\n" +
                "JOIN courses ON reviews.course_id = courses.course_id\n" +
                "JOIN professors ON reviews.professor_id = professors.professor_id\n" +
                " WHERE reviews.professor_id = ?;";
        ResultSet resultSet = null;
    List<Comment> comments = new ArrayList<>();
        try{
            connection = JDBCTools.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, professorId);
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Comment comment = new Comment(
                    resultSet.getInt("review_id"),
                    resultSet.getInt("course_id"),
                    resultSet.getString("courses.course_name"),
                    resultSet.getString("courses.course_code"),
                    resultSet.getInt("professor_id"),
                    resultSet.getString("professors.name"),
                    resultSet.getInt("courses.campus_id"),
                    resultSet.getInt("rating"),
                    resultSet.getString("comment"),
                    resultSet.getObject("date_posted", LocalDateTime.class)
                );
                comments.add(comment);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCTools.release(resultSet, statement, connection);

        }
        return comments;
    }

    @Override
    public List<Comment> getCommentsByCourseId(Integer courseId) {
        // get comments by course id
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "SELECT reviews.*,courses.course_code as course_code, courses.course_name as course_name," +
                    "courses.campus_id as campus_id, professors.name as professor_name\n" +
                    "FROM reviews\n" +
                    "JOIN courses ON reviews.course_id = courses.course_id\n" +
                    "JOIN professors ON reviews.professor_id = professors.professor_id\n" +
                    " WHERE reviews.course_id = ?;";
        ResultSet resultSet = null;
        List<Comment> comments = new ArrayList<>();
        try{
            connection = JDBCTools.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, courseId);
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Comment comment = new Comment(
                        resultSet.getInt("review_id"),
                        resultSet.getInt("course_id"),
                        resultSet.getString("course_name"),
                        resultSet.getString("course_code"),
                        resultSet.getInt("professor_id"),
                        resultSet.getString("professor_name"),
                        resultSet.getInt("campus_id"),
                        resultSet.getInt("rating"),
                        resultSet.getString("comment"),
                        resultSet.getObject("date_posted", LocalDateTime.class)
                );
                comments.add(comment);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCTools.release(resultSet, statement, connection);
        }
        return comments;
    }

    @Override
    public void deleteComment(Integer commentId) {
        // delete comment by comment id
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "DELETE FROM reviews WHERE review_id = ?";
        try{
            connection = JDBCTools.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, commentId);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCTools.release(null, statement, connection);
        }
    }
}
