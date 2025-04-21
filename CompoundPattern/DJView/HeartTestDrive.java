public class HeartTestDrive {
    public static void main(String[] args) {
        HeartModel heartModel = new HeartModel();
        // The controller adapts the heartModel to a beatModel.
        ControllerInterface controller = new HeartController(heartModel);
    }
}