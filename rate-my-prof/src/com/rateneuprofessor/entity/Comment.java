package com.rateneuprofessor.entity;

import java.time.LocalDateTime;

public class Comment {
  private Integer reviewId;
  private Integer courseId;
  private String courseName;
  private String courseCode;
  private Integer professorId;
  private String professorName;
  private Integer campusId;
  private Integer rating;
  private String comment;
  private LocalDateTime datePosted;

  public Comment(Integer reviewId, Integer courseId, String courseName, String courseCode, Integer professorId, String professorName, Integer campusId, Integer rating, String comment, LocalDateTime datePosted) {
    this.reviewId = reviewId;
    this.courseId = courseId;
    this.courseName = courseName;
    this.courseCode = courseCode;
    this.professorId = professorId;
    this.professorName = professorName;
    this.campusId = campusId;
    this.rating = rating;
    this.comment = comment;
    this.datePosted = datePosted;
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

  public String getProfessorName() {
    return professorName;
  }

  public void setProfessorName(String professorName) {
    this.professorName = professorName;
  }

  public Integer getCampusId() {
    return campusId;
  }

  public void setCampusId(Integer campusId) {
    this.campusId = campusId;
  }


  public Integer getReviewId() {
    return reviewId;
  }

  public Integer getCourseId() {
    return courseId;
  }

  public Integer getProfessorId() {
    return professorId;
  }

  public Integer getRating() {
    return rating;
  }

  public String getComment() {
    return comment;
  }

  public LocalDateTime getDatePosted() {
    return datePosted;
  }

  public void setReviewId(Integer reviewId) {
    this.reviewId = reviewId;
  }

  public void setCourseId(Integer courseId) {
    this.courseId = courseId;
  }

  public void setProfessorId(Integer professorId) {
    this.professorId = professorId;
  }

  public void setRating(Integer rating) {
    this.rating = rating;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public void setDatePosted(LocalDateTime datePosted) {
    this.datePosted = datePosted;
  }

}
