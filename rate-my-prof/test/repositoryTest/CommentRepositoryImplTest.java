package repositoryTest;

import com.rateneuprofessor.entity.Comment;
import com.rateneuprofessor.repository.CommentRepository;
import com.rateneuprofessor.repository.impl.CommentRepositoryImpl;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CommentRepositoryImplTest {
    CommentRepository commentRepository = new CommentRepositoryImpl();
    @Test
    public void testAddComment() {
        commentRepository.addComment(1, 1, 5, "Test Comment 1", LocalDateTime.now());
        commentRepository.addComment(2, 3, 3, "Test Comment 2", LocalDateTime.now());
        List<Comment> comment = commentRepository.getCommentsByProfessorId(1);
        assertEquals("Test Comment 1", comment.get(0).getComment());
        List<Comment> comment2 = commentRepository.getCommentsByProfessorId(3);
        assertEquals("Test Comment 2", comment2.get(0).getComment());
        commentRepository.deleteComment(comment.get(0).getReviewId());
        commentRepository.deleteComment(comment2.get(0).getReviewId());
    }

    @Test
    public void testGetCommentsByProfessorId() {
        List<Comment> comments = commentRepository.getCommentsByProfessorId(5);
        assertEquals(3, comments.size());
        List<Comment> comments2 = commentRepository.getCommentsByProfessorId(6);
        assertEquals(1, comments2.size());
    }

    @Test
    public void testGetCommentsByCourseId() {
        List<Comment> comments = commentRepository.getCommentsByCourseId(3);
        assertEquals(4, comments.size());
        List<Comment> comments2 = commentRepository.getCommentsByCourseId(4);
        assertEquals(1, comments2.size());
    }

    @Test
    public void testDeleteComment() {
        commentRepository.addComment(1, 1, 5, "Test Comment 1", LocalDateTime.now());
        List<Comment> comments = commentRepository.getCommentsByProfessorId(1);
        assertEquals(1, comments.size());
        commentRepository.deleteComment(comments.get(0).getReviewId());
        List<Comment> commentsAfterDelete = commentRepository.getCommentsByProfessorId(1);
        assertEquals(0, commentsAfterDelete.size());
    }
}
