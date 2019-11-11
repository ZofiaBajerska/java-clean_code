package decorator;

import model.Message;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class SimplePrinterTest {

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
        Mockito.when(message.getAuthor()).thenReturn("Zosia");
        Mockito.when(message.getTitle()).thenReturn("Hahaha");
        String expected = new String("Author: Zosia\nTitle: Hahaha\n");

        SimplePrinter printer = new SimplePrinter();
        printer.accept(message);

        assertThat(outContent.toString()).isEqualTo(expected);
    }

}
