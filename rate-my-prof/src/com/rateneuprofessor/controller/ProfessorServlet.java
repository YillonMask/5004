package com.rateneuprofessor.controller;

import com.rateneuprofessor.service.ProfessorService;
import com.rateneuprofessor.service.impl.ProfessorServiceImpl;
import com.rateneuprofessor.utils.GsonTools;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/professor")
public class ProfessorServlet extends HttpServlet {

  private ProfessorService professorService = new ProfessorServiceImpl();

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    resp.setContentType("application/json; charset=UTF-8");

    // create new professor
    String name = req.getParameter("name");
    Integer campusId = Integer.valueOf(req.getParameter("campus_id"));
    professorService.addProfessor(name, campusId);
    resp.getWriter().write(
         GsonTools.success("Professor added successfully")
    );
  }
}
