package com.rateneuprofessor.repository;

import com.rateneuprofessor.entity.Course;

import java.util.List;
/**
 * Repository interface for Course repository.
 */
public interface CourseRepository {
    /**
     * add a course to the database
     *
     * @param courseName
     * @param professorId
     * @param courseCode
     * @param campusId
     *
     */
    void addCourse(String courseName, Integer professorId, String courseCode, Integer campusId);

    /**
     * Search course by course name
     * @param name
     * @return List of courses
     */
    List<Course> searchCourseByName(String name);

    /**
     * Search course by course code
     * @param code
     * @return List of courses
     */
    List<Course> searchCourseByCode(String code);

    /**
     * Get all courses
     * @return List of all courses
     */
    void updateRating(Integer courseId);

    /**
     * delete a course by courseId
     * @param courseId
     */
    void deleteCourse(Integer courseId);
}
