
import java.util.Random;

public class DuckAdapter implements Turkey {
    Duck duck;
    Random rand;

    public DuckAdapter(Duck duck) {
        this.duck = duck;
        rand = new Random();
    }

    public void gobble() {
        duck.quack();
    }

    // Smart. Once in 5, since they fly an average of 5 times of a turkey.
    public void fly() {
        if (rand.nextInt(5) == 0) {
            duck.fly();
        }
    }
}