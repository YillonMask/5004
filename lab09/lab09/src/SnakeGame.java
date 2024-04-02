import java.awt.Dimension;
import java.awt.Image;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SnakeGame {
  private JFrame frame;
  private JPanel panel;
  public SnakeGame(){
    frame = new JFrame();
    panel = new MyPanel();
    panel.setPreferredSize(new Dimension(400, 400));
    frame.add(panel);
    frame.pack();
    // by default, everything is invisible. Make it visible
    frame.setVisible(true);
  }
  public static void main(String[] args) {
      /**
      * Possible future improvement No.1
      * create a SnakeGame method at SnakeGame class
      * In the main function. Just call the SnakeGame method
      */

//    JFrame frame = new JFrame();
//    JPanel panel = new MyPanel();
//    panel.setPreferredSize(new Dimension(400, 400));
//    frame.add(panel);
//    frame.pack();
//    // by default, everything is invisible. Make it visible
//    frame.setVisible(true);
    new SnakeGame();
  }
}
