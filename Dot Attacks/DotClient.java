import javax.swing.JFrame;
import java.awt.Dimension;

public class DotClient
{
  
  
  
  public static void main(String[] args)
  {
    JFrame frame = new JFrame("Dot Attack");
    DotAttack panel = new DotAttack();
    
    final int WIDTH = panel.getWidth();
    final int HEIGHT = panel.getHeight();
    
    //frame.setSize(WIDTH, HEIGHT);
    frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(panel);
    frame.setVisible(true);
    
    frame.pack();
    
  }
  
}