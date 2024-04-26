package utilsTest;

import com.rateneuprofessor.entity.Comment;
import com.rateneuprofessor.entity.Course;
import com.rateneuprofessor.utils.GsonTools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GsonToolsTest {

  private Course course1, course2, course3;
  private String professor1, professor2, professor3;
  private Comment comment1;
  private List<Course> listOfCourses;
  private Map<String, Course> mapOfCourses;

  @Before
  public void setUp() {
    course1 = new Course(10, "Object Oriented Design", "CS5004", 5,null,1,5.0);
    course2 = new Course(11, "Algorithm", "CS5800", 12,null,1,4.5);
    course3 = new Course(12, "Web Development", "CS5610", 17,null,1,4.0);

    listOfCourses = new ArrayList<>();
    listOfCourses.add(course1);
    listOfCourses.add(course2);
    listOfCourses.add(course3);

    professor1 = "Mark Miller";
    professor2 = "Lama Hamandi";
    professor3 = "John Alexis Guerra Gómez";
    mapOfCourses = new HashMap<>();
    mapOfCourses.put(professor1, course1);
    mapOfCourses.put(professor2, course2);
    mapOfCourses.put(professor3, course3);

    //comment1 = new Comment(1, 1, 1, 5, "Great!", LocalDateTime.now());
  }

  @Test
  public void testSuccess() {
    String expected1 = "{\"status\":\"success\",\"message\":\"Success message\"}";
    assertEquals(expected1, GsonTools.success("success", "Success message", null));

    String expected2 = "{\"status\":\"success\",\"message\":\"Success message\",\"data\":{\"courseId\":10,\"courseName\":\"Object Oriented Design\",\"courseCode\":\"CS5004\",\"professorId\":5,\"campusId\":1,\"rating\":5.0}}";
    assertEquals(expected2, GsonTools.success("success", "Success message", course1));

    String expected3 = "{\"status\":\"success\",\"message\":\"Success message\",\"data\":[{\"courseId\":10,\"courseName\":\"Object Oriented Design\",\"courseCode\":\"CS5004\",\"professorId\":5,\"campusId\":1,\"rating\":5.0},{\"courseId\":11,\"courseName\":\"Algorithm\",\"courseCode\":\"CS5800\",\"professorId\":12,\"campusId\":1,\"rating\":4.5},{\"courseId\":12,\"courseName\":\"Web Development\",\"courseCode\":\"CS5610\",\"professorId\":17,\"campusId\":1,\"rating\":4.0}]}";
    assertEquals(expected3, GsonTools.success("success", "Success message", listOfCourses));

    String expected4 = "{\"status\":\"success\",\"message\":\"Success message\",\"data\":{\"Mark Miller\":{\"courseId\":10,\"courseName\":\"Object Oriented Design\",\"courseCode\":\"CS5004\",\"professorId\":5,\"campusId\":1,\"rating\":5.0},\"John Alexis Guerra Gómez\":{\"courseId\":12,\"courseName\":\"Web Development\",\"courseCode\":\"CS5610\",\"professorId\":17,\"campusId\":1,\"rating\":4.0},\"Lama Hamandi\":{\"courseId\":11,\"courseName\":\"Algorithm\",\"courseCode\":\"CS5800\",\"professorId\":12,\"campusId\":1,\"rating\":4.5}}}";
    assertEquals(expected4, GsonTools.success("success", "Success message", mapOfCourses));

    // NOTE: Custom objects can be used as key in gson ONLY IF the hashcode() method is override!
  }

  @Test
  public void testSuccessMsgData() {
    String expected1 = "{\"status\":\"success\",\"message\":\"Success message\",\"data\":{\"courseId\":10,\"courseName\":\"Object Oriented Design\",\"courseCode\":\"CS5004\",\"professorId\":5,\"campusId\":1,\"rating\":5.0}}";
    assertEquals(expected1, GsonTools.success("Success message", course1));
  }

  @Test
  public void testSuccessMsg() {
    String expected1 = "{\"status\":\"success\",\"message\":\"Success message\"}";
    assertEquals(expected1, GsonTools.success("Success message"));
  }

  @Test
  public void testError() {
    String expected1 = "{\"status\":\"error\",\"message\":\"There is an error!\"}";
    assertEquals(expected1, GsonTools.error("error", "There is an error!"));
    assertEquals(expected1, GsonTools.error("There is an error!"));
  }

}
