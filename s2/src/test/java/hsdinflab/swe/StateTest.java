package hsdinflab.swe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StateTest {
    State state;

    @BeforeEach
    public void setUp() {
        this.state = new State();
    }

    @Test
    public void testGetAndSetState() {
        // Test initial state
        Assertions.assertEquals(State.SongState.READY, state.getSongState());
    }

    @Test
    public void testStart() {
        state.play();
        State.SongState resultState = state.getSongState();
        assertEquals(State.SongState.PLAYING, resultState);
    }

    @Test
    public void testPause() {
        state.play();      // bereit → spielt
        State.SongState resultState = state.getSongState();
        assertEquals(State.SongState.PLAYING, resultState);
        state.pause();     // spielt → pausiert
        State.SongState resultState1 = state.getSongState();
        assertEquals(State.SongState.PAUSED, resultState1);
        state.play();      // pausiert → spielt
        State.SongState resultState2 = state.getSongState();
        assertEquals(State.SongState.PLAYING, resultState2);
        state.stop();      // spielt → bereit
        State.SongState resultState3 = state.getSongState();
        assertEquals(State.SongState.READY, resultState3);
    }

    @Test
    public void testFoward(){
        state.forward_backward(); 
        State.SongState resultState = state.getSongState();
        assertEquals(State.SongState.READY, resultState);
    }
}
