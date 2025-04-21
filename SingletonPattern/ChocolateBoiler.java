public enum  ChocolateBoiler {
    UNIQUEBOILER;
    private boolean empty;
    private boolean boiled;
    // private volatile static ChocolateBoiler uniqueBoiler;
    // other useful data.

    private ChocolateBoiler() {
        // private constructor.
        empty = true;
        boiled = true;
    }


    // public static ChocolateBoiler getInstance() {
    //     if (uniqueBoiler == null) {
    //         synchronized (ChocolateBoiler.class) {
    //             if (uniqueBoiler == null) {
    //                 uniqueBoiler = new ChocolateBoiler();
    //             }
    //         }
    //     }
    //     return uniqueBoiler;
    // }

    public void fill() {
        if (isEmpty()) {
            empty = false;
            boiled = false;
            // fill the boiler with a milk/chocolate mixture
        }
    }

    public void drain() {
        if (!isEmpty() && isBoiled()) {
        // drain the boiled milk and chocolate
            empty = true;
        }
    }

    public void boil() {
        if (!isEmpty() && !isBoiled()) {
            boiled = true;
        }
    }
    
    public boolean isEmpty() {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
    }
}