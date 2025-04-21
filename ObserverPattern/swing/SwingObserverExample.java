
import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingObserverExample {
    // Instance variables, this is the java swing version of the Observer pattern.
    JFrame frame;
    
    public static void main(String[] args) {
        // Create an instance of the SwingObserverExample class
        SwingObserverExample example = new SwingObserverExample();
        example.go();
    }

    public void go() {
        frame = new JFrame();

        JButton button = new JButton("Should I do it?");
        // Register the listeners with the button.
        // Can also use lambda expressions here.
        // By using a lambda expression rather than an inner class, you can skip the step of creating an ActionListener object. With a lambda
        // expression, we create a function object instead, and the function object is the observer. And, when you pass that function object to addActionListener(), 
        // Java ensures its signature matches actionPerformed(), the one method in the ActionListener interface. Later, when the button is clicked, the button object notifies its observers—including the function
        // objects created by the lambda expressions—that it’s been clicked, and calls each listener’s actionPerformed() method.
        button.addActionListener(event -> System.out.println("Don't do it, you might regret it!"));
        button.addActionListener(event -> System.out.println("Come on, do it!"));

        // Set frame properties here
        frame.getContentPane().add(button);  // Add button to frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);  // Make frame visible
        
    }

    // // Inner classes which implement the ActionListener interface, aka the Observers.
    // class AngelListener implements ActionListener {
    //     // ActionEvent is the state object that is passed to the Observer.
    //     public void actionPerformed(ActionEvent event) {
    //         System.out.println("Don't do it, you might regret it!");
    //     }
    // }

    // class DevilListener implements ActionListener {
    //     public void actionPerformed(ActionEvent event) {
    //         System.out.println("Come on, do it!");
    //     }
    // }
}

// The notifyObservers() method is called when the button is clicked, which in turn calls the update() method on each Observer, which is the actionPerformed() method in this case.