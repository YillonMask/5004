package com.rateneuprofessor.controller;

import com.rateneuprofessor.entity.Campus;
import com.rateneuprofessor.service.CampusService;
import com.rateneuprofessor.service.impl.CampusServiceImpl;
import com.rateneuprofessor.utils.GsonTools;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/campus")
public class CampusServlet extends HttpServlet {

  private CampusService campusService = new CampusServiceImpl();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    // return all campus
    List<Campus> campus = campusService.getAllCampus();
    if (campus != null) {
      resp.getWriter().write(
          GsonTools.success("Get all campus successfully", campus)
      );
    } else {
      resp.getWriter().write(
          GsonTools.error("Cannot get campus")
      );
    }
  }
}
