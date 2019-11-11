package input;

import model.Message;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class InputReaderTest {
    private final InputStream originalIn = System.in;

    @After
    public void restoreStreams() {
        System.setIn(originalIn);
    }

    @Test
    public void test_() {
        String input = "aabcd\nhjk\n";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        Scanner scanner = new Scanner(System.in);

        InputReader<String> reader = new InputReader(new StringValidator());
        String out = reader.getValue("", scanner);

        assertThat(out).isEqualTo("aabcd");
    }
}
