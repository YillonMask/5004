package com.rateneuprofessor.service;

import com.rateneuprofessor.entity.Professor;

import java.util.List;


/**
 * Service interface for Professor service.
 */
public interface ProfessorService {
    /**
     * Add a new professor to the database.
     * @param name the name of the professor
     * @param campusId the id of the campus where the professor works
     */
    void addProfessor(String name, Integer campusId);

    /**
     * Search for a professor by name.
     * @param name the name of the professor to search for
     */
    List<Professor> searchProfessorByName(String name);

    /**
     * Delete a professor by professorId.
     * @param professorId
     */
    void deleteProfessor(Integer professorId);
}
