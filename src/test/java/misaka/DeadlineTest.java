package misaka;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

class DeadlineTest {

    @Test
    void deadlineToString_correctFormat() {
        LocalDate date = LocalDate.of(2019, 10, 15);
        Deadline d = new Deadline("return book", date);

        assertEquals(
                "[D][ ] return book (by: Oct 15 2019)",
                d.toString()
        );
    }
}
