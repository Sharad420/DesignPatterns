import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Line;

public class BeatModel implements BeatModelInterface, Runnable {
    List<BeatObserver> beatObservers = new ArrayList<BeatObserver>();
    List<BPMObserver> bpmObservers = new ArrayList<BPMObserver>();
    int bpm = 90;
    // Use these to start and stop the beat thread.
    Thread thread;
    boolean stop = false;
    Clip clip;

    // Sets up the beat track.
    public void initialize() {
        try {
            File resource = new File("clap.wav");
            clip = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
            clip.open(AudioSystem.getAudioInputStream(resource));
        } catch (Exception e) {
            System.out.println("Error: Can't load clip");
            System.out.println(e);
        }
    }

    public void on() {
        // System.out.println("beatModel.on() called");
        bpm = 90;
        notifyBPMObservers();
        // BeatModel implements Runnable, and we have implemented run(), so this works.
        thread = new Thread(this);
        stop = false;
        thread.start();
    }


    // Stops the thread and the beat.
    public void off() {
        stopBeat();
        stop = true;
    }

    // Runs the beat thread, and notifies the beat observers that a beat has been played.
    public void run() {
        while (!stop) {
            playBeat();
            notifyBeatObservers();
            // Sleeps the thread for the duration of the non-beat. Then plays again.
            try {
                Thread.sleep(60000/getBPM());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // ALlows the controller to manipulate the beat. Sets the BPM and notifies all the BPM observers.
    public void setBPM(int bpm) {
        this.bpm = bpm;
        notifyBPMObservers();
    }

    // Returns the current BPM.
    public int getBPM() {
        return bpm;
    }

    public void registerObserver(BeatObserver o) {
        beatObservers.add(o);
    }

    public void notifyBeatObservers() {
        // System.out.println("Notifying beat observers");
        for (int i = 0; i < beatObservers.size(); i++) {
            BeatObserver observer = (BeatObserver) beatObservers.get(i);
            observer.updateBeat();
        }
    }

    public void registerObserver(BPMObserver o) {
        bpmObservers.add(o);
    }

    public void notifyBPMObservers() {
        for (int i = 0; i < bpmObservers.size(); i++) {
            BPMObserver observer = (BPMObserver) bpmObservers.get(i);
            observer.updateBPM();
        }
    }

    public void removeObserver(BeatObserver o) {
        int i = beatObservers.indexOf(o);
        if (i >= 0) {
            beatObservers.remove(i);
        }
    }       

    public void removeObserver(BPMObserver o) {
        int i = bpmObservers.indexOf(o);
        if (i >= 0) {
            bpmObservers.remove(i);
        }
    }

    // Plays the beat sound.
    // Sets the pointer to start and plays.
    public void playBeat() {
        clip.setFramePosition(0);
        clip.start();
    }

    public void stopBeat() {
        clip.setFramePosition(0);
        clip.stop();
    }

}