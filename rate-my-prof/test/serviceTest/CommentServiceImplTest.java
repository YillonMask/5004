package serviceTest;

import com.rateneuprofessor.entity.Comment;
import com.rateneuprofessor.service.CommentService;
import com.rateneuprofessor.service.impl.CommentServiceImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CommentServiceImplTest {
    CommentService commentService = new CommentServiceImpl();

    @Test
    public void testAddComment() {
        commentService.addComment(1, 5, "Great professor!");
        commentService.addComment(2, 4, "Good professor!");
        commentService.addComment(1, 3, "Average professor!");
        List<Comment> comment1 = commentService.getCommentsByCourseId(1);
        List<Comment> comment2 = commentService.getCommentsByCourseId(2);
        assertEquals(2, comment1.size());
        assertEquals(1, comment2.size());
        commentService.deleteComment(comment1.get(0).getReviewId());
        commentService.deleteComment(comment1.get(1).getReviewId());
        commentService.deleteComment(comment2.get(0).getReviewId());
    }
    @Test
    public void testGetCommentsByProfessorId() {
        assertEquals(1, commentService.getCommentsByProfessorId(50).size());
        String expected = "running  wolf";
        assertEquals(expected, commentService.getCommentsByProfessorId(66).get(0).getComment());
    }

    @Test
    public void testGetCommentsByCourseId() {
        assertEquals(4, commentService.getCommentsByCourseId(3).size());
        String expected = "running  wolf";
        assertEquals(expected, commentService.getCommentsByCourseId(51).get(0).getComment());
    }

    @Test
    public void testDeleteComment() {
        commentService.addComment(1, 5, "Great professor!");
        List<Comment> comments = commentService.getCommentsByCourseId(1);
        assertEquals(1, comments.size());
        commentService.deleteComment(comments.get(0).getReviewId());
        List<Comment> commentsAfterDelete = commentService.getCommentsByCourseId(1);
        assertEquals(0, commentsAfterDelete.size());
    }

}
