package com.rateneuprofessor.entity.comparator;

import com.rateneuprofessor.entity.Professor;

import java.util.Comparator;

/**
 * Comparator class to sort professors by name.
 */
public class sortByProfessorName implements Comparator<Professor> {

    @Override
    public int compare(Professor o1, Professor o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
