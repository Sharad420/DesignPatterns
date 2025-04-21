public class DJTestDrive {
    public static void main(String[] args) {
        // Create a model
        BeatModelInterface model = new BeatModel();
        // The controller creates a view, so no need to do that.
        ControllerInterface controller = new BeatController(model);

    }
}