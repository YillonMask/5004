package com.rateneuprofessor.repository;

import com.rateneuprofessor.entity.Campus;
import java.util.List;

/**
 * Repository interface for Campus repository.
 */
public interface CampusRepository {
    /**
     * Get all campuses.
     *
     * @return List of all campuses.
     */
  public List<Campus> getAllCampus();
}
