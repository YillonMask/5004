package com.rateneuprofessor.entity;

import java.util.Objects;

public class Course {
    private Integer courseId;
    private String courseName;
    private String courseCode;
    private Integer professorId;
    private String professorName;
    private Integer campusId;
    private Double rating;

    public Course(Integer courseId, String courseName, String courseCode, Integer professorId,
                  String professorName, Integer campusId, Double rating) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.professorId = professorId;
        this.professorName = professorName;
        this.campusId = campusId;
        this.rating = rating;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getCampusId() {
        return campusId;
    }

    public void setCampusId(Integer campusId) {
        this.campusId = campusId;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public Integer getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Integer professorId) {
        this.professorId = professorId;
    }

    /**
     * Override hashCode method to generate hash code based on courseName, courseCode and professorId
     * @return hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(courseName, courseCode, professorId);
    }

    /**
     * Override equals method to compare two Course objects based on courseName, courseCode and professorId
     * @param obj object to compare
     * @return true if objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Course course = (Course) obj;
        return Objects.equals(courseName, course.courseName)
                && Objects.equals(courseCode, course.courseCode) && Objects.equals(professorId, course.professorId);
    }

}
