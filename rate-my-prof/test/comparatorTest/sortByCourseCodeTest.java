package comparatorTest;

import com.rateneuprofessor.entity.Course;
import com.rateneuprofessor.entity.comparator.sortByCourseCode;
import com.rateneuprofessor.repository.CourseRepository;
import com.rateneuprofessor.repository.impl.CourseRepositoryImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class sortByCourseCodeTest {
    CourseRepositoryImpl courseRepository = new CourseRepositoryImpl();
    List<Course> courses = new ArrayList<>();

    @Before
    public void setUp() {
        courses.add(new Course(1, "Test one", "789", 1,"Test",1,3.00));
        courses.add(new Course(2, "Test two", "123", 1,"Test",1,3.00));
        courses.add(new Course(3, "Test three", "456", 1,"Test",1,3.00));
    }
    @Test
    public void testSortByCourseCode() {
        courses.sort(new sortByCourseCode());
        String expected = "123";
        assertEquals(expected, courses.get(0).getCourseCode());
        expected = "456";
        assertEquals(expected, courses.get(1).getCourseCode());
        expected = "789";
        assertEquals(expected, courses.get(2).getCourseCode());
    }
}
