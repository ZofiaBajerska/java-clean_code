package decorator;

import model.Message;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class FullPrinterTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void test(){
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getDate()).thenReturn(new Date(2019, Calendar.MAY, 11, 17, 12, 12));
        Mockito.when(message.getAuthor()).thenReturn("Zosia");
        Mockito.when(message.getTitle()).thenReturn("Hahaha");
        Mockito.when(message.getText()).thenReturn("hihihi");
        String expected = new String("Date: 11-05-19 17:12:12\nAuthor: Zosia\nTitle: Hahaha\nText: hihihi\n");

        FullPrinter printer = new FullPrinter();
        printer.accept(message);

        assertThat(outContent.toString()).isEqualTo(expected);
    }

}
