package hsdinflab.swe;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class StateMock {
    State state;
    
    @BeforeEach
    public void setup() {
        state = new State();
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
        state.pause();     // spielt → pausiert
        state.play();      // pausiert → spielt
        state.stop();      // spielt → bereit
        State.SongState resultState = state.getSongState();
        assertEquals(State.SongState.READY, resultState);
    }

    @Test
    public void testFoward(){
        state.forward_backward(); 
        State.SongState resultState = state.getSongState();
        assertEquals(State.SongState.READY, resultState);
    }

}
