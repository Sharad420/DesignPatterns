public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        // Create the factory that is going to pass into the simulator.
        AbstractDuckFactory duckFactory = new CountingDuckFactory();
        simulator.simulate(duckFactory);
    }

    // Takes in the factory to cdelegate duck creation to the factory.
    void simulate(AbstractDuckFactory duckFactory) {

        

        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable gooseDuck = new GooseAdapter(new Goose());

        System.out.println("\nDuck Simulator: With Composite Flocks");

        // Create the composite flock.
        Flock flockOfDucks = new Flock();

        flockOfDucks.add(redheadDuck);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(gooseDuck);

        Flock flockOfMallards = new Flock();

        Quackable mallardOne = duckFactory.createMallardDuck();
        Quackable mallardTwo = duckFactory.createMallardDuck();
        Quackable mallardThree = duckFactory.createMallardDuck();
        Quackable mallardFour = duckFactory.createMallardDuck();

        flockOfMallards.add(mallardOne);
        flockOfMallards.add(mallardTwo);
        flockOfMallards.add(mallardThree);
        flockOfMallards.add(mallardFour);

        flockOfDucks.add(flockOfMallards);

        Quackologist quackologist = new Quackologist();
        flockOfDucks.registerObserver(quackologist);

        System.out.println("\nDuck Simulator: Whole Flock Simulation");
        simulate(flockOfDucks);

        System.out.println("\nDuck Simulator: Mallard Flock Simulation");
        simulate(flockOfMallards);

        // This works as before, since the decorator wraps the quackable ducks.
        System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times");
    }

    // Simulate method is being overloaded.
    void simulate(Quackable duck) {
        duck.quack();
        // Using polumorphism, no matter what kind of quackable is passed in,
        // it performs.
    }
}

// v0: DuckSimulator.java
// v1: GooseAdapter added.
// v2: DuckSimulator with Decorator to count quacks.
// v3: DuckSimulator with AbstractFactory to create families of ducks.
// v4: DuckSimulator with Composite to create a flock of ducks and have uniform behaviour on all.
// v5: DuckSimulator with ObserverPattern to notify Quackologists when an individual duck quacks.
    // The Subject is the Object being observed, i.e the ducks.
    // Each subject implements two/three mwthods to register, notify and/or remove observers.
    // Can delegate these methods to an observable class instead of having to modify each observable with the same code.

// Created an Observable, Composite, Abstractly Created, Decorated and Adapted Duck Simulator.

// Youshould consider the design of the Duck
// Simulator to be forced and artificial. But hey,
// it was fun and gave us a good idea of how
// several patterns can fit into a solution.
