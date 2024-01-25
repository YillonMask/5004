import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PetRockTest {
    PetRock rocky;
    PetRock keyrock;

    @BeforeEach
    public void setup(){
        this.rocky = new PetRock("rocky",89.64);
        this.keyrock = new PetRock("keyrock",89.64);
    }
    @Test
    public void getName() throws Exception{

    assertEquals("rocky",rocky.getName());
    }

    @Test
    public void isHappy() throws Exception{
        assertFalse(rocky.isHappy());
    }

    @Test
    public void happyAfterPlay() throws Exception{
        rocky.happyAfterPlay();
        assertTrue(rocky.isHappy());
    }

  @Test
  public void happyFail() {
        assertThrows(IllegalStateException.class,()->{
          rocky.printHappyMessage();
      });
  }

  @Test
  public void happyNow() {
        rocky.happyAfterPlay();
        assertEquals("I'am happy",rocky.printHappyMessage());
  }

    @Test
    public void getMassInGramsSame() {
        assertEquals(rocky.getMassInGrams(),keyrock.getMassInGrams());
      }

    @Test
    public void getMassInGramsNotSame(){
        assertNotSame(rocky.getMassInGrams(),keyrock.getMassInGrams());
    }

    @Test
    public void testToString() {
        assertEquals("PetRock{happy=false, name='rocky', massInGrams=89.64}"
        ,rocky.toString());
      }
}
