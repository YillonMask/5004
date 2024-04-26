package com.rateneuprofessor.service;

import com.rateneuprofessor.entity.Course;
import com.rateneuprofessor.entity.Professor;
import com.rateneuprofessor.entity.Sort;

import java.util.List;

/**
 * Service interface for Search service.
 */
public interface SearchService {
    /**
     * Search courses by keyword.
     * @param keyword the keyword to search for
     * @param campusId the id of the campus to search in
     * @param sort the sort order
     * @return List of courses
     */
    List<Course> searchCourses(String keyword, Integer campusId, Sort sort);

    /**
     * Search professors by keyword.
     * @param keyword the keyword to search for
     * @param campusId the id of the campus to search in
     * @param sort the sort order
     * @return List of professors
     */
    List<Professor> searchProfessors(String keyword,Integer campusId, Sort sort);

}
