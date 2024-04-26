package com.rateneuprofessor.controller;

import com.rateneuprofessor.service.CourseService;
import com.rateneuprofessor.service.impl.CourseServiceImpl;
import com.rateneuprofessor.utils.GsonTools;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/course")
public class CourseServlet extends HttpServlet {
    private CourseService courseService = new CourseServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json; charset=UTF-8");
        String courseName = req.getParameter("course_name");
        String courseCode = req.getParameter("course_code");
        String professorName = req.getParameter("professor_name");
        Integer campusId = Integer.valueOf(req.getParameter("campus_id"));
        try {
            courseService.addCourse(courseName, professorName,courseCode, campusId);
            resp.getWriter().write(
                    GsonTools.success("Course added successfully")
            );
        }catch (NullPointerException e){
            resp.getWriter().write(
                    GsonTools.error("Professor not found")
            );
        }

    }
}
