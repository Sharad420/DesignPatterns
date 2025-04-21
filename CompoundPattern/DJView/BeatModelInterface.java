public interface BeatModelInterface {
    void initialize();

    void on();

    void off();

    void setBPM(int bpm);

    int getBPM();

    void registerObserver(BeatObserver o);

    void removeObserver(BeatObserver o);

    void registerObserver(BPMObserver o);

    void removeObserver(BPMObserver o);

    void notifyBeatObservers();

    void notifyBPMObservers();
}

// This is the iterface for the model. It is also the observable. It contains the state, application logic and required data.
// It also exposes an interface to the controller so that the controller can manipulate the model.
// Split into two observers, ones who want an update for every beat, and ones who want an update when there is a BPM change.
// The controller uses these methods to direct the model.