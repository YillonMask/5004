package com.rateneuprofessor.service.impl;

import com.rateneuprofessor.entity.Comment;
import com.rateneuprofessor.repository.CommentRepository;
import com.rateneuprofessor.repository.CourseRepository;
import com.rateneuprofessor.repository.ProfessorRepository;
import com.rateneuprofessor.repository.impl.CommentRepositoryImpl;
import com.rateneuprofessor.repository.impl.CourseRepositoryImpl;
import com.rateneuprofessor.repository.impl.ProfessorRepositoryImpl;
import com.rateneuprofessor.service.CommentService;

import java.time.LocalDateTime;
import java.util.List;

public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository = new CommentRepositoryImpl();
    private ProfessorRepository professorRepository = new ProfessorRepositoryImpl();
    private CourseRepository courseRepository = new CourseRepositoryImpl();

    @Override
    public void addComment(Integer courseId, Integer rating, String content) {
        Integer professorId = professorRepository.getProfessorIdByCourseId(courseId);
        commentRepository.addComment(courseId, professorId, rating, content, LocalDateTime.now());
        professorRepository.updateRating(professorId);
        courseRepository.updateRating(courseId);
    }
    @Override
    public List<Comment> getCommentsByProfessorId(Integer professorId) {
        return commentRepository.getCommentsByProfessorId(professorId);
    }

    @Override
    public List<Comment> getCommentsByCourseId(Integer courseId) {
        return commentRepository.getCommentsByCourseId(courseId);
    }

    @Override
    public void deleteComment(Integer commentId) {
        commentRepository.deleteComment(commentId);
    }
}
