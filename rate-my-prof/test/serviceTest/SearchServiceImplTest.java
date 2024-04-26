package serviceTest;

import com.rateneuprofessor.entity.Course;
import com.rateneuprofessor.entity.Professor;
import com.rateneuprofessor.entity.Sort;
import com.rateneuprofessor.service.SearchService;
import com.rateneuprofessor.service.impl.SearchServiceImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SearchServiceImplTest {
    SearchService searchService = new SearchServiceImpl();

    @Test
    public void testSearchCourses() {
        List<Course> courses = searchService.searchCourses("Machine Learning",null, Sort.Default);
        assertEquals(1, courses.size());
        List<Course> courses2 = searchService.searchCourses("Privacy Security and Usability",null, Sort.Default);
        assertEquals(1, courses2.size());
    }

    @Test
    public void testSearchProfessors() {
        List<Professor> professors = searchService.searchProfessors("Mark Miller",null, Sort.Default);
        assertEquals(1, professors.size());
        List<Professor> professors2 = searchService.searchProfessors("Prof Not Found",null, Sort.Default);
        assertEquals(0, professors2.size());
    }
}
