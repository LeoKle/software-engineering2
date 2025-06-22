package hsdinflab.swe;

import hsdinflab.swe.State;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class StateMock {
    
    @beforeEach
    public void setup() {
        State state = new State();
    }
    
    @Test
    public void testStart() {
        song.play();
        assertEquals(State.Status.PLAYING, song.getStatus());
    }

    @Test
    public void testPause() {
        song.play();      // bereit → spielt
        song.pause();     // spielt → pausiert
        song.play();      // pausiert → spielt
        song.stop();      // spielt → bereit
        assertEquals(State.Status.BEREIT, song.getStatus());
    }

    @Test
    public void testFoward(){
        song.forward(); 
        assertEquals(State.Status.BEREIT, song.getStatus());
    }
}
