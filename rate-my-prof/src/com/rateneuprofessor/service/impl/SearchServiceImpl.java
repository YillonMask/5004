package com.rateneuprofessor.service.impl;

import com.rateneuprofessor.entity.Course;
import com.rateneuprofessor.entity.Professor;
import com.rateneuprofessor.entity.Sort;
import com.rateneuprofessor.entity.comparator.sortByCourseCode;
import com.rateneuprofessor.entity.comparator.sortByProfessorName;
import com.rateneuprofessor.repository.CourseRepository;
import com.rateneuprofessor.repository.ProfessorRepository;
import com.rateneuprofessor.repository.impl.CourseRepositoryImpl;
import com.rateneuprofessor.repository.impl.ProfessorRepositoryImpl;
import com.rateneuprofessor.service.SearchService;

import java.util.*;
import java.util.stream.Collectors;

public class SearchServiceImpl implements SearchService {
    private CourseRepository courseRepository = new CourseRepositoryImpl();
    private ProfessorRepository professorRepository = new ProfessorRepositoryImpl();

    @Override
    public List<Course> searchCourses(String keyword, Integer campusId, Sort sort) {
        // search courses in database
        Set<Course> courses = new HashSet<Course>();
        courses.addAll(courseRepository.searchCourseByName(keyword));
        courses.addAll(courseRepository.searchCourseByCode(keyword));
        List<Course> courseList = new ArrayList<>(courses);
        switch (sort){
            case CourseCode:
                Collections.sort(courseList, new sortByCourseCode());
                break;
            default:
                break;
        }
        if(campusId == null){
            return courseList;
        }else{
            List<Course> coursesByCampus = courseList.stream()
                    .filter(course -> course.getCampusId().equals(campusId))
                    .collect(Collectors.toList());
            return coursesByCampus;
            }
    }

    @Override
    public List<Professor> searchProfessors(String keyword, Integer campusId, Sort sort) {
        // search professors in database
        Set<Professor> professors = new HashSet<>();
        professors.addAll(professorRepository.searchProfessorByName(keyword));
        List<Professor> professorList = new ArrayList<>(professors);
        switch (sort){
            case ProfessorName:
                Collections.sort(professorList, new sortByProfessorName());
                break;
            default:
                break;
        }
        if(campusId == null){
            return professorList;
        }else{
            List<Professor> professorsByCampus = professorList.stream()
                    .filter(professor -> professor.getCampusId().equals(campusId))
                    .collect(Collectors.toList());
            return professorsByCampus;
        }
    }

}
