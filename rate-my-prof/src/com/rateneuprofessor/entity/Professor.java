package com.rateneuprofessor.entity;

import java.util.Objects;

public class Professor {
    private Integer professorId;
    private String name;
    private Integer campusId;
    private Double rating;

    public Professor(Integer professorId, String name, Integer campusId, Double rating) {
        this.professorId = professorId;
        this.name = name;
        this.campusId = campusId;
        this.rating = rating;
    }
    public Professor(String name, Integer campusId) {
        this.professorId = null;
        this.name = name;
        this.campusId = campusId;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getProfessorId() {
        return professorId;
    }

    public String getName() {
        return name;
    }

    public Integer getCampusId() {
        return campusId;
    }

    public void setProfessorId(Integer professorId) {
        this.professorId = professorId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCampusId(Integer campusId) {
        this.campusId = campusId;
    }

    /**
     * Override the hashCode method to generate a hash code based on the name and campusId fields.
     * @return hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, campusId);
    }

    /**
     * Override the equals method to compare two Professor objects based on the name and campusId fields.
     * @param obj the object to compare
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Professor professor = (Professor) obj;
        return Objects.equals(name, professor.name) && Objects.equals(campusId, professor.campusId);
    }
}
