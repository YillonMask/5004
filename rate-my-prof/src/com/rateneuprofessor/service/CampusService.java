package com.rateneuprofessor.service;

import com.rateneuprofessor.entity.Campus;
import java.util.List;
/**
 * Service interface for Campus service.
 */
public interface CampusService {
    /**
     * Get all campuses.
     *
     * @return List of all campuses.
     */
  List<Campus> getAllCampus();
}
