import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;


import org.junit.jupiter.api.BeforeEach;



/**
 * Junit test for shoe class
 */
public class ShoeTest {
    private Shoe NewBalance;
    private Shoe Nike;

    @BeforeEach
    public void setup(){
        this.NewBalance = new Shoe("Running", "Grey", "NewBalance", 8.5);
        this.Nike = new Shoe("Basketball", "Black", "Nike", 9);
    }

    @Test
    public void testType(){
        Assertions.assertEquals("Running", this.NewBalance.getType());
        Assertions.assertEquals("Basketball", this.Nike.getType());
    }

    @Test
    public void testColor(){
        Assertions.assertEquals("Grey", this.NewBalance.getColor());
        Assertions.assertEquals("Black", this.Nike.getColor());
    }

    @Test
    public void testBrand(){
        Assertions.assertEquals("NewBalance", this.NewBalance.getBrand());
        Assertions.assertEquals("Nike", this.Nike.getBrand());
    }


    @Test
    public void testSize(){
        Assertions.assertEquals(8.5, this.NewBalance.getSize());
        Assertions.assertEquals(9, this.Nike.getSize());
    }

    @Test
    public void testPrint(){
        Assertions.assertEquals("The type of the shoe is Running, the color is Grey, the brand is NewBalance and the size is 8.5", NewBalance.toString());
        Assertions.assertEquals("The type of the shoe is Basketball, the color is Black, the brand is Nike and the size is 9.0", Nike.toString());
    }


}
