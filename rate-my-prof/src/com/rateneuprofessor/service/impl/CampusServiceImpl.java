package com.rateneuprofessor.service.impl;

import com.rateneuprofessor.entity.Campus;
import com.rateneuprofessor.repository.CampusRepository;
import com.rateneuprofessor.repository.impl.CampusRepositoryImpl;
import com.rateneuprofessor.service.CampusService;
import java.util.List;

public class CampusServiceImpl implements CampusService {

  private CampusRepository campusRepository = new CampusRepositoryImpl();

  @Override
  public List<Campus> getAllCampus() {
    return campusRepository.getAllCampus();
  }
}
