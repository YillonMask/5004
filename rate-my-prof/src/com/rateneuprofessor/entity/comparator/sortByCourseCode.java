package com.rateneuprofessor.entity.comparator;

import com.rateneuprofessor.entity.Course;

import java.util.Comparator;

/**
 * Comparator class to sort courses by course code.
 */
public class sortByCourseCode implements Comparator<Course> {

    @Override
    public int compare(Course o1, Course o2) {
        return o1.getCourseCode().compareTo(o2.getCourseCode());
    }
}
