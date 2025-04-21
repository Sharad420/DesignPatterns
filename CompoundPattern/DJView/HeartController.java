// Create a heart controller, to get the view running with the heart model.
// Basically, changing the strategy of the view, to perform different behaviours when some user action is performed.
public class HeartController implements ControllerInterface {
    HeartModelInterface model;
    DJView view;

    public HeartController(HeartModelInterface model) {
        this.model = model;
        // We pass a heart model wrapped in an adapter .
        view = new DJView(this, new HeartAdapter(model));
        view.createView();
        view.createControls();
        // Both are disabled, since the heart just runs.
        view.disableStopMenuItem();
        view.disableStartMenuItem();
    }

    public void start() {
        // No action needed for the heart model.
    }

    public void stop() {
        // No action needed for the heart model.
    }

    public void increaseBPM() {

    }

    public void decreaseBPM() {

    }

    public void setBPM(int bpm) {

    }

}