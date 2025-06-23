package hsdinflab.swe;

public class State {
    public enum SongState {
        READY, PLAYING, PAUSED, STOPPED
    };

    private SongState songState;

    public State() {
        this.songState = SongState.READY;
    }

    public SongState getSongState() {
        return songState;
    }

    public void play() {
        if (songState != SongState.PAUSED && songState != SongState.READY) {
            throw new IllegalStateException("Cannot play when not paused or ready");
        }

        songState = SongState.PLAYING;
    }

    public void pause() {
        if (songState != SongState.PLAYING) {
            throw new IllegalStateException("Cannot pause when not playing");
        }

        songState = SongState.PAUSED;
    }

    public void stop() {
        if (songState != SongState.PLAYING) {
            throw new IllegalStateException("Cannot stop when already stopped");
        }

        songState = SongState.READY;
    }

    public void onSongEnd() {
        if (songState != SongState.PLAYING) {
            throw new IllegalStateException("Cannot end when not playing ");
        }

        songState = SongState.STOPPED;
    }

    public void forward_backward() {
        if (songState == SongState.STOPPED) {
            throw new IllegalStateException("Cannot forward or backward when stopped");
        }

        // DONT CHANGE STATE, just simulate the action
    }
}
