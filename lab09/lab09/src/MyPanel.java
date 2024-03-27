import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MyPanel extends JPanel implements ActionListener, KeyListener {

  public MyPanel() {
    // make the panel focusable so that it can react to keyboard inputs
    this.setFocusable(true);

    // Load the image from the internet
    try {
      apple_image = ImageIO.read(new URL(
          "https://cdn-uploads.piazza.com/paste/k53ka6172ie4ll/10addac51ca9ba16a3cc46fcb64ca250e5fb15c58c78530c2096bf2e4b503b7b/apple.png"));
      snake_head_image = ImageIO.read(new URL(
          "https://cdn-uploads.piazza.com/paste/k53ka6172ie4ll/32956f1c46253cf2ebb9a9c6519df3116fe8c4ca7167444c1312168fbb96873c/head.png"));
      snake_body_image = ImageIO.read(new URL(
          "https://cdn-uploads.piazza.com/paste/k53ka6172ie4ll/08b035cfbd798f6bb0e0f7eb680979285a2df1d51f9066d53707a4a0f79f88ac/dot.png"));
    } catch (Exception e) {
      System.out.println("url doesn't work");
    }

    rnd = new Random();
    // Init the location of the apple
    apple_loc = new Coordinate(200, 200);
    // Init the location of the snake.
    // It starts with head only
    // The list head is the snake head.
    // Assume the radius of each dot is 10.
    snake_loc = new ArrayList<>();
    snake_loc.add(new Coordinate(50, 50));
    snake_loc.add(new Coordinate(50 + dot_size, 50));
    snake_loc.add(new Coordinate(50 + 2 * dot_size, 50));

    // 1 - up
    // 2 - down
    // 3 - left
    // 4 - right
    direction = 1;

    // set up the alarm, which fires periodically (16 ms == 60fps).
    // Every time it fires, we update the apple's location and repaint it.
    new Timer(200, this).start();

    // register ourself as the keyboard event listner.
    this.addKeyListener(this);
  }

  @Override
  protected void paintComponent(Graphics g) {
    System.out.println("repainting");

    super.paintComponent(g);

    // paint the apple
    g.drawImage(apple_image, apple_loc.x, apple_loc.y, this);
    // paint the snake head
    g.drawImage(snake_head_image, snake_loc.get(0).x, snake_loc.get(0).y, this);
    // paint the snake body
    for (int i = 1; i < snake_loc.size(); i++) {
      g.drawImage(snake_body_image, snake_loc.get(i).x, snake_loc.get(i).y, this);
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    System.out.println("alarm fired");
    // We reach here every time the alarm fires.

    // We update the snake's location.
    // Make it look like the snake is moving forward
    // Trick: move the tail to become the new head,
    // and keep other nodes the same
    // 1. chop off the tail
    Coordinate old_tail = snake_loc.remove(snake_loc.size()-1);
    // TODO: what if size is 1
    // 2. get the loc of the old head
    int old_head_x = snake_loc.get(0).x;
    int old_head_y = snake_loc.get(0).y;
    // 3. add a new head. The loc of the new head
    // depends on the direction of movement
    int new_head_x = old_head_x;
    int new_head_y = old_head_y;
    if (direction == 1) {
      // up
      new_head_y -= dot_size;
    } else if (direction == 2) {
      // down
      new_head_y += dot_size;
    } else if (direction == 3) {
      // left
      new_head_x -= dot_size;
    } else if (direction == 4) {
      // right
      new_head_x += dot_size;
    }
    snake_loc.add(0, new Coordinate(new_head_x, new_head_y));

    // check whether the head overlaps with the apple
    if (snake_loc.get(0).equals(apple_loc)) {
      // eating the apple.
      // Increase size by 1.
      // Added the removed tail back.
      snake_loc.add(old_tail);

      // also need to regenerate the apple's location
      regenApple();
    }

    // Call repaint, which further invokes `paintComponent`.
    repaint();
  }

  private void regenApple() {
    // Random location within the panel.
    int new_x = rnd.nextInt(400);
    int new_y = rnd.nextInt(400);
    // Round the location to dot_size.
    apple_loc = new Coordinate((new_x / dot_size) * dot_size, (new_y / dot_size) * dot_size);
  }

  @Override
  public void keyTyped(KeyEvent e) {
    // do nothing
  }

  @Override
  public void keyPressed(KeyEvent e) {
    int keyCode = e.getKeyCode();
    if (keyCode == KeyEvent.VK_UP) {
      // up key is pressed
      direction = 1;
    } else if (keyCode == KeyEvent.VK_DOWN) {
      // down
      direction = 2;
    } else if (keyCode == KeyEvent.VK_LEFT) {
      // left
      direction = 3;
    } else if (keyCode == KeyEvent.VK_RIGHT) {
      // right
      direction = 4;
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {
    // do nothing
  }

  private Coordinate apple_loc;
  private Image apple_image;
  private Image snake_head_image;
  private Image snake_body_image;
  private int dot_size = 10;
  private int direction;
  private Random rnd;
  List<Coordinate> snake_loc;
}
