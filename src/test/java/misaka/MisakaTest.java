package misaka;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MisakaTest {

    @Test
    void todoTask_initialStateCorrect() {
        Task task = new Todo("read book");

        assertEquals("read book", task.getDescription());
        assertFalse(task.isDone());
        assertEquals("[T][ ] read book", task.toString());
    }

    @Test
    void markTask_taskIsMarked() {
        Task task = new Todo("read book");
        task.mark();

        assertTrue(task.isDone());
        assertEquals("[T][X] read book", task.toString());
    }
}
