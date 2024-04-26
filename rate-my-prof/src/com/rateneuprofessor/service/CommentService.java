package com.rateneuprofessor.service;

import com.rateneuprofessor.entity.Comment;

import java.util.List;

/**
 * Service interface for Comment service.
 */
public interface CommentService {
    /**
     * Add a comment to a course.
     *
     * @param courseId The course id.
     * @param rating The rating.
     * @param content The content of the comment.
     */
    void addComment(Integer courseId,Integer rating,String content);

    /**
     * Get comments by professor id.
     * @param professorId
     * @return List of comments.
     */
    List<Comment> getCommentsByProfessorId(Integer professorId);;

    /**
     * Get comments by course id.
     * @param courseId
     * @return List of comments.
     */
    List<Comment> getCommentsByCourseId(Integer courseId);

    /**
     * delete a comment by commentId
     * @param commentId
     */
    void deleteComment(Integer commentId);
}
