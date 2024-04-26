package com.rateneuprofessor.controller;

import com.rateneuprofessor.entity.Course;
import com.rateneuprofessor.entity.Professor;
import com.rateneuprofessor.entity.Sort;
import com.rateneuprofessor.service.SearchService;
import com.rateneuprofessor.service.impl.SearchServiceImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rateneuprofessor.utils.GsonTools;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    private SearchService searchService = new SearchServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json; charset=UTF-8");
        String keyword = req.getParameter("keyword");
        Integer sort = Integer.valueOf(req.getParameter("sort"));
        Integer campusId;
        if(req.getParameter("campus_id") == null){
            campusId = null;
        }else{
            campusId = Integer.valueOf(req.getParameter("campus_id"));
        }
        boolean NoCourse = Boolean.parseBoolean(req.getParameter("no_course"));
        boolean NoProfessor = Boolean.parseBoolean(req.getParameter("no_professor"));
        Map<String, Object> result = new HashMap<>();
        if(!NoCourse && !NoProfessor){
            List<Course> courses = searchService.searchCourses(keyword,campusId, Sort.values()[sort]);
            List<Professor> professors = searchService.searchProfessors(keyword,campusId,Sort.values()[sort]);
            result.put("courses", courses);
            result.put("professors", professors);
            resp.getWriter().write(GsonTools.success("search completed", result));
        }
        else if(!NoCourse){
            List<Course> courses = searchService.searchCourses(keyword,campusId,Sort.values()[sort]);

            resp.getWriter().write(GsonTools.success("search completed", courses));
        }
        else if(!NoProfessor){
            List<Professor> professors = searchService.searchProfessors(keyword,campusId,Sort.values()[sort]);
            resp.getWriter().write(GsonTools.success("search completed", professors));
        }else{
            resp.getWriter().write(GsonTools.error("No search result"));
        }
    }
}
