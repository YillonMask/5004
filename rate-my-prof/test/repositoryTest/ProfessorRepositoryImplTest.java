package repositoryTest;

import com.rateneuprofessor.entity.Professor;
import com.rateneuprofessor.repository.ProfessorRepository;
import com.rateneuprofessor.repository.impl.ProfessorRepositoryImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProfessorRepositoryImplTest {
    @Test
    public void testAddProfessor() {
        ProfessorRepository professorRepository = new ProfessorRepositoryImpl();
        professorRepository.addProfessor("Test Add Prof 1", 1);
        professorRepository.addProfessor("Test Add Prof 2", 3);
        List<Professor> profTestOne = professorRepository.searchProfessorByName("Test Add Prof 1");
        assertEquals("Test Add Prof 1", profTestOne.get(0).getName());
        List<Professor> profTestTwo = professorRepository.searchProfessorByName("Test Add Prof 2");
        assertEquals("Test Add Prof 2", profTestTwo.get(0).getName());
        professorRepository.deleteProfessor(profTestOne.get(0).getProfessorId());
        professorRepository.deleteProfessor(profTestTwo.get(0).getProfessorId());
    }

    @Test
    public void testSearchProfessorByName() {
        ProfessorRepository professorRepository = new ProfessorRepositoryImpl();
        List<Professor> profs = professorRepository.searchProfessorByName("Mark Miller");
        assertEquals(1, profs.size());
        List<Professor> profs2 = professorRepository.searchProfessorByName("Prof Not Found");
        assertEquals(0, profs2.size());
    }

    @Test
    public void testSearchProfessorByCourseId(){
        ProfessorRepository professorRepository = new ProfessorRepositoryImpl();
        Integer profIdOne = professorRepository.getProfessorIdByCourseId(3);
        assertEquals(50, (int)profIdOne);
        Integer profIdTwo = professorRepository.getProfessorIdByCourseId(5);
        assertEquals(7,(int)profIdTwo);
    }

    @Test
    public void testUpdateRating(){
        ProfessorRepository professorRepository = new ProfessorRepositoryImpl();
        professorRepository.updateRating(50);
        List<Professor> profs = professorRepository.searchProfessorByName("Mark Miller");
        assertEquals(4.00, (double)profs.get(0).getRating(), 0.01);
        professorRepository.updateRating(49);
        List<Professor> profs2 = professorRepository.searchProfessorByName("Maria Jump");
        assertEquals(1.00, (double)profs2.get(0).getRating(), 0.01);
    }

    @Test
    public void testDeleteProfessor(){
        ProfessorRepository professorRepository = new ProfessorRepositoryImpl();
        professorRepository.addProfessor("Test Delete Prof", 1);
        List<Professor> profs = professorRepository.searchProfessorByName("Test Delete Prof");
        professorRepository.deleteProfessor(profs.get(0).getProfessorId());
        List<Professor> profs2 = professorRepository.searchProfessorByName("Test Delete Prof");
        assertEquals(0, profs2.size());
    }
}
