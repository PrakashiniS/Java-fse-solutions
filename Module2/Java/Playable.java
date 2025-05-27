public interface Playable {
    void play();

    void stop();

    void tune();

    String getInstrumentType();

    boolean isInTune();
}