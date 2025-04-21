import java.awt.Graphics;
import javax.swing.JFrame;

// Extending JFrame that contains a method update() that controls an algo which updates teh screen. We hook paint() into this.
public class MyFrame extends JFrame{
    // Just some basic setup for a JFrame.
    public MyFrame(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(300, 300);
        this.setVisible(true);
    }

    // JFrame's update algorithm calls paint(). By default, paint() does nothing. It is a hook. We override it with our own implementation.
    public void paint(Graphics graphics) {
        super.paint(graphics);
        String msg = "I rule!!";
        graphics.drawString(msg, 100, 100);
    }

    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame("Head First Design Patterns");
    }
}
