
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoffeeHook extends CaffeineBeverageWithHook {
    protected void brew() {
        System.out.println("Dripping Coffee through filter");
    }

    protected void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }

    @Override
    protected boolean customerWantsCondiments() {
        String answer = getUserInput();

        if (answer.toLowerCase().startsWith("y")) {
            return true;
        } else {
            return false;
        }
    }

    private String getUserInput() {
        String answer = null;

        System.out.print("Would you like milk and sugar with your coffee (y/n)? ");

        // Notice that this uses the decorater pattern.
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            answer = in.readLine();
        } catch(IOException ioe) {
            System.err.println("IO error trying to read your answer");
        }

        if (answer == null) {
            return "no";
        }

        return answer;
    }
}