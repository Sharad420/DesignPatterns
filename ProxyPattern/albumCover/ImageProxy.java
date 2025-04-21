import java.awt.Component;
import java.awt.Graphics;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ImageProxy implements Icon {
    volatile ImageIcon imageIcon; // ImageIcon needs to be read by 2 threads, the UI and the thread which loads the image.
    final URL imageURL;
    Thread retrievalThread; // Thread which loads the image, so the main UI doesn't freeze.
    boolean retrieving = false; // Flag to check if the image is being loaded.

    public ImageProxy(URL url) {
        imageURL = url;
    }

    // Checks if the image is loaded, if not, gets default dimensions.
    public int getIconHeight() {
        if (imageIcon != null) {
            return imageIcon.getIconHeight();
        } else {
            return 800;
        }
    }

    public int getIconWidth() {
        if (imageIcon != null) {
            return imageIcon.getIconWidth();
        } else {
            return 800;
        }
    }
    
    // synchronized setter to protect writes, while voatile protects reads, but doesn't lock it.
    synchronized void setIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    public void paintIcon(final Component c, Graphics g, int x, int y) {
        // If there is an imageIcon, paint it.
        if (imageIcon != null) {
            imageIcon.paintIcon(c, g, x, y);
        } 
        // Else, we display the loading message. 
        else {
            g.drawString("Loading album cover, please wait . . .", x + 300, y + 300);
            // If we aren’t already trying to retrieve the image......then it’s time to start retrieving it 
            // (in case you were wondering, only one thread calls paint, so we should be okay in terms of thread safety.
            if (!retrieving) {
                retrieving = true;


                // Creates a new Thred which is an abstract class, Runnable is an interface with only one method, run().
                // Therefore, each new thread runs only one Runnable method.
                // Thread.start() creates a new thread, thread.run() runs the thread without creating a new one.
                // Since runnable has only one method, we can use this anonymous class or a lambda expression.
                retrievalThread = new Thread(new Runnable() {
                    public void run() {
                        try {
                            // This is a synchronized block to protect the imageIcon from being set while it is being loaded.
                            /*
                                Here’s where we load the REAL icon image. Note that 
                                the image loading with IconImage is synchronous: the ImageIcon constructor doesn’t 
                                return until the image is loaded. That doesn’t give us much of a chance to do
                                screen updates and have our message displayed, so we’re going to do this asynchronously.
                            */
                            setIcon(new ImageIcon(imageURL, "Album Cover"));
                            c.repaint();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                retrievalThread.start();
            }
        }
    }


}