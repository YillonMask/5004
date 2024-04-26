package com.rateneuprofessor.service.impl;

import com.rateneuprofessor.entity.Course;
import com.rateneuprofessor.entity.Professor;
import com.rateneuprofessor.repository.CourseRepository;
import com.rateneuprofessor.repository.ProfessorRepository;
import com.rateneuprofessor.repository.impl.CourseRepositoryImpl;
import com.rateneuprofessor.repository.impl.ProfessorRepositoryImpl;
import com.rateneuprofessor.service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {
  private CourseRepository courseRepository = new CourseRepositoryImpl();
  private ProfessorRepository professorRepository = new ProfessorRepositoryImpl();

    @Override
    public void addCourse(String courseName, String name, String courseCode, Integer campusId) {
        // add course to database
        List<Professor> professors = professorRepository.searchProfessorByName(name);
        Integer professorId = professors.get(0).getProfessorId();
        courseRepository.addCourse(courseName, professorId, courseCode, campusId);
    }

    @Override
    public List<Course> searchCourseByName(String name) {
        // search course by name
        return courseRepository.searchCourseByName(name);
    }

    @Override
    public List<Course> searchCourseByCode(String code) {
        // search course by code
        return courseRepository.searchCourseByCode(code);
    }

    @Override
    public void deleteCourse(Integer courseId) {
        // delete course from database
        courseRepository.deleteCourse(courseId);
    }
}
