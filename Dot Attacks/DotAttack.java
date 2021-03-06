import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class DotAttack extends JPanel implements ActionListener, MouseMotionListener, KeyListener
{
  
  // Sets the boolean if any key is pressed to false
  private boolean pressed = false;
  
  // Integer variables for the x and y position of the ball
  private static int xPos = 150;
  private static int yPos = 150;
  
  Ball ball = new Ball(xPos, yPos);
  
  
  // The width and height of the entire Panel
  private final int WIDTH = 300;
  private final int HEIGHT = 300;
  
  // Booleans for the keys
  private boolean up = false;
  private boolean down = false;
  private boolean left = false;
  private boolean right = false;
  
  // Just for testing the timer object
  int count = 0;
  
  
  public DotAttack()
  {
    setFocusable(true);
    setSize(WIDTH, HEIGHT);
    setDoubleBuffered(true);
    addMouseMotionListener(this);
    addKeyListener(this);
    Timer time = new Timer(15, this);
    time.start();
  }
  
  public void paint(Graphics g)
  {
    // Sets the canvas of the entire panel
    g.setColor(Color.white);
    g.fillRect(0, 0, WIDTH, HEIGHT);
    g.setColor(Color.black);
    g.drawOval(ball.getX(), ball.getY(), 20, 20);
  }
  
  
  public void mouseDragged(MouseEvent e)
  {
    // Nothing done here
  }
  
  public void mouseMoved(MouseEvent e)
  {
    ball.setPos(e.getX(), e.getY());
  }
  
  
  public void keyPressed(KeyEvent e)
  {
    pressed = true;
    moveBall(e.getKeyCode(), pressed);
  }
  
  public void keyReleased(KeyEvent e)
  {
    pressed = false;
    moveBall(e.getKeyCode(), pressed);
  }
  
  public void keyTyped(KeyEvent e)
  {
    // Left blank intentionally
  }
  
  
  public void actionPerformed(ActionEvent e)
  {
    repaint();
  }
  
  // Returns the width of the panel
  public int getWidth()
  {
    return WIDTH;
  }
  
  // Returns the height of the panel
  public int getHeight()
  {
    return HEIGHT;
  }
  
  // Moves the ball acording to the key pressed
  public void moveBall(int keyCode, boolean isPressed)
  {
    if (keyCode == KeyEvent.VK_LEFT)
    {
      ball.setPos(ball.getX() - 5, ball.getY());
    }
    
    if (keyCode == KeyEvent.VK_RIGHT)
    {
      ball.setPos(ball.getX() + 5, ball.getY());
    }
    
    if (keyCode == KeyEvent.VK_UP)
    {
      ball.setPos(ball.getX(), ball.getY() - 5);
    }
    
    if (keyCode == KeyEvent.VK_DOWN)
    {
      ball.setPos(ball.getX(), ball.getY() + 5);
    }
    /*
    if ((keyCode == KeyEvent.VK_LEFT) && (keyCode == KeyEvent.VK_UP))
    {
      ball.setPos(ball.getX() - 5, ball.getY() - 5);
    }
    
    if ((keyCode == KeyEvent.VK_LEFT) && (keyCode == KeyEvent.VK_DOWN))
    {
      ball.setPos(ball.getX() - 5, ball.getY() + 5);
    }
    
    if ((keyCode == KeyEvent.VK_RIGHT) && (keyCode == KeyEvent.VK_UP))
    {
      ball.setPos(ball.getX() + 5, ball.getY() - 5);
    }
    
    if ((keyCode == KeyEvent.VK_RIGHT) && (keyCode == KeyEvent.VK_DOWN))
    {
      ball.setPos(ball.getX() + 5, ball.getY() + 5);
    }
    */
  }
  
  
}