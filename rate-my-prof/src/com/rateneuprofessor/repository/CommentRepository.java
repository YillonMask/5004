package com.rateneuprofessor.repository;

import com.rateneuprofessor.entity.Comment;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Repository interface for Comment repository.
 */
public interface CommentRepository {
    /**
     * Add a comment to a course.
     *
     * @param courseId    The course id.
     * @param professorId The professor id.
     * @param rating      The rating.
     * @param content     The content of the comment.
     * @param datePosted  The date the comment was posted.
     */
    void addComment(Integer courseId,Integer professorId, Integer rating,String content, LocalDateTime datePosted);

    /**
     * Get all comments.
     *
     * @param professorId The professor id.
     * @return List of all comments.
     */
    List<Comment> getCommentsByProfessorId(Integer professorId);

    /**
     * Get all comments.
     *
     * @param courseId The course id.
     * @return List of all comments.
     */
    List<Comment> getCommentsByCourseId(Integer courseId);

    /**
     * delete a comment by commentId
     * @param commentId
     */
    void deleteComment(Integer commentId);
}
