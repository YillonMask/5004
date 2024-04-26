package serviceTest;

import com.rateneuprofessor.entity.Course;
import com.rateneuprofessor.repository.CourseRepository;
import com.rateneuprofessor.repository.impl.CourseRepositoryImpl;
import com.rateneuprofessor.service.CourseService;
import com.rateneuprofessor.service.impl.CourseServiceImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CourseServiceImplTest {
    List<Course> courses = new ArrayList<>();
    CourseService courseService = new CourseServiceImpl();
    CourseRepositoryImpl courseRepository = new CourseRepositoryImpl();

    @Test
    public void testAddCourse() {
        courseService.addCourse("Test Add one", "Mark Miller", "1234", 1);
        courseService.addCourse("Test Add Two", "Mark Miller", "5678", 1);
        List<Course> courseTestOne = courseRepository.searchCourseByName("Test Add one");
        List<Course> courseTestTwo = courseRepository.searchCourseByName("Test Add Two");
        assertEquals("Test Add one", courseTestOne.get(0).getCourseName());
        assertEquals("Test Add Two", courseTestTwo.get(0).getCourseName());
        courseRepository.deleteCourse(courseTestOne.get(0).getCourseId());
        courseRepository.deleteCourse(courseTestTwo.get(0).getCourseId());
    }

    @Test
    public void testSearchCourseByName() {
        courses = courseService.searchCourseByName("Privacy Security and Usability");
        assertEquals(1, courses.size());
        courses = courseService.searchCourseByName("Machine Learning");
        assertEquals(1, courses.size());
    }

    @Test
    public void testSearchCourseByCode() {
        courses = courseService.searchCourseByCode("5008");
        assertEquals(3, courses.size());
        courses = courseService.searchCourseByCode("5004");
        assertEquals(2, courses.size());
    }

    @Test
    public void testDeleteCourse() {
        courseService.addCourse("Test Delete", "Mark Miller", "1234", 1);
        List<Course> courseTest = courseRepository.searchCourseByName("Test Delete");
        assertEquals(1, courseTest.size());
        courseService.deleteCourse(courseTest.get(0).getCourseId());
        List<Course> courseAfterDelete = courseRepository.searchCourseByName("Test Delete");
        assertEquals(0, courseAfterDelete.size());
    }

}
