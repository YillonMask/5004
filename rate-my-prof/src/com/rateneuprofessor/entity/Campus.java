package com.rateneuprofessor.entity;

public class Campus {
    private Integer campusId;
    private String campusName;

    public Campus(Integer campusId, String campusName) {
        this.campusId = campusId;
        this.campusName = campusName;
    }

    public Integer getCampusId() {
        return campusId;
    }

    public String getCampusName() {
        return campusName;
    }

    public void setCampusId(Integer campusId) {
        this.campusId = campusId;
    }

    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }
}
