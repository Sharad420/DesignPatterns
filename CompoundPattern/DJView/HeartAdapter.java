// Adapt the heart model to a beat model. Otherwise, it won't be able to work with the view.
public class HeartAdapter implements BeatModelInterface {
    // Store a reference of the adaptee.
    HeartModelInterface heart;

    public HeartAdapter(HeartModelInterface heart) {
        this.heart = heart;
    }

    public void initialize() {
        // No initialization needed for the heart model.
    }

    public void on() {
        // No action needed for the heart model.
    }

    public void off() {
        // No action needed for the heart model.
    }

    public int getBPM() {
        // Translate getHeartRate to getBPM.
        return heart.getHeartRate();
    }

    public void setBPM(int bpm) {
        // No action needed for the heart model.
    }
    

    // Observer methods are just delegated to the heart model.
    public void registerObserver(BeatObserver o) {
        heart.registerObserver(o);
    }

    public void removeObserver(BeatObserver o) {
        heart.removeObserver(o);
    }

    public void registerObserver(BPMObserver o) {
        heart.registerObserver(o);
    }

    public void removeObserver(BPMObserver o) {
        heart.removeObserver(o);
    }

    public void notifyBeatObservers() {
        heart.notifyBeatObservers();
    }

    public void notifyBPMObservers() {
        heart.notifyBPMObservers();
    }
}