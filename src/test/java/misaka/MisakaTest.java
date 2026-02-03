package misaka;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MisakaTest {

    @Test
    void todoTask_initialStateCorrect() {
        Task task = new Todo("read book");

        assertEquals("read book", task.description);
        assertFalse(task.isDone);
        assertEquals("[T][ ] read book", task.toString());
    }

    @Test
    void markTask_taskIsMarked() {
        Task task = new Todo("read book");
        task.mark();

        assertTrue(task.isDone);
        assertEquals("[T][X] read book", task.toString());
    }
}
