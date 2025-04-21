
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputTest {
    public static void main(String[] args) throws IOException {
        int c;

        try {
            // Set up the input stream and wrap it with the LowerCaseInputStream.
            // The LowerCaseInputStream is a decorator for the BufferedInputStream, which is a decorator for the FileInputStream.
            // Much like the decorators in the Starbuzz Coffee example, we can mix and match decorators to create new combinations.
            InputStream in = 
            new LowerCaseInputStream(
                new BufferedInputStream(
                new FileInputStream("test.txt")
            ));

            while ((c = in.read()) >= 0) {
                System.out.print((char) c);
            }

            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
