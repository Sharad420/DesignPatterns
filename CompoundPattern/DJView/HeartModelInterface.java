public interface HeartModelInterface {
    // Method for getting current heart rate.
    int getHeartRate();
    
    void registerObserver(BeatObserver o);

    void removeObserver(BeatObserver o);

    void registerObserver(BPMObserver o);

    void removeObserver(BPMObserver o);

    void notifyBeatObservers();

    void notifyBPMObservers();
}