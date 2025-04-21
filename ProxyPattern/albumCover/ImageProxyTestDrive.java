import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ImageProxyTestDrive {
    ImageComponent imageComponent;
    JFrame frame = new JFrame("Album Cover Viewer");
    JMenuBar menuBar;
    JMenu menu;
    Hashtable<String, String> albums = new Hashtable<String, String>();

    public static void main(String[] args) throws Exception {
        ImageProxyTestDrive testDrive = new ImageProxyTestDrive();
    }

    public ImageProxyTestDrive() throws Exception {
        albums.put("Buddha Bar", "https://en.wikipedia.org/wiki/Buddha_Bar_compilation_albums#/media/File:Buddha_Bar_door.jpg");
        albums.put("Ima","https://upload.wikimedia.org/wikipedia/en/6/69/Bt_ima.jpg");
        albums.put("Karma","https://upload.wikimedia.org/wikipedia/en/9/9f/Karma_%28Pharoah_Sanders%29.jpg");
        albums.put("MCMXC a.D.","https://upload.wikimedia.org/wikipedia/en/1/10/MCMXC_aD_Enigma_cover.jpg");
        albums.put("Northern Exposure","https://upload.wikimedia.org/wikipedia/en/0/0e/Ne1.jpg");
        albums.put("Selected Ambient Works, Vol. 2","https://upload.wikimedia.org/wikipedia/en/1/12/Selected_Ambient_Works_Volume_II_cover.jpg");
        // albums.put("Test", "https://upload.wikimedia.org/wikipedia/en/2/29/Selected_Ambient_Works_Volume_II_album_cover.jpg");


        URL initialURL = URI.create(albums.get("Selected Ambient Works, Vol. 2")).toURL();
        menuBar = new JMenuBar();
        menu = new JMenu("Favorite Albums");
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        for (Enumeration e = albums.keys(); e.hasMoreElements();) {
            String name = (String)e.nextElement();
            JMenuItem menuItem = new JMenuItem(name);
            menu.add(menuItem);
            menuItem.addActionListener(event -> {
                imageComponent.setIcon(
                    new ImageProxy(getAlbumUrl(event.getActionCommand())));
                frame.repaint();
            });
        

        // Set up frame and menus
        Icon icon = new ImageProxy(initialURL);
        imageComponent = new ImageComponent(icon);
        frame.getContentPane().add(imageComponent);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }

    URL getAlbumUrl(String name) {
        try {
            return URI.create(albums.get(name)).toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
