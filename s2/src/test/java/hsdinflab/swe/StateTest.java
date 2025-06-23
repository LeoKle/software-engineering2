package hsdinflab.swe;

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
}
