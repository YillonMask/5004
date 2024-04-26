package com.rateneuprofessor.controller;

import com.rateneuprofessor.service.CommentService;
import com.rateneuprofessor.service.impl.CommentServiceImpl;
import com.rateneuprofessor.utils.GsonTools;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/comment")
public class CommentServlet extends HttpServlet {
    private CommentService commentService = new CommentServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json; charset=UTF-8");
        Integer courseId = Integer.valueOf(req.getParameter("course_id"));
        Integer rating = Integer.valueOf(req.getParameter("rating"));
        String content = req.getParameter("content");
        commentService.addComment(courseId, rating, content);
        resp.getWriter().write(
            GsonTools.success("Comment added successfully")
        );
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json; charset=UTF-8");
        String action = req.getParameter("action");
        if(action != null){
            switch(action){
                case "getCommentsByProfessorId":
                    Integer professorId = Integer.valueOf(req.getParameter("professor_id"));
                    resp.getWriter().write(
                        GsonTools.success("Get comments by professor id successfully", commentService.getCommentsByProfessorId(professorId))
                    );
                    break;
                case "getCommentsByCourseId":
                    Integer courseId = Integer.valueOf(req.getParameter("course_id"));
                    resp.getWriter().write(
                        GsonTools.success("Get comments by course id successfully", commentService.getCommentsByCourseId(courseId))
                    );
                    break;
                default:
                    resp.getWriter().write(
                        GsonTools.error("Invalid action")
                    );
            }
        }

    }
}
