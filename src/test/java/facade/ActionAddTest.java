package facade;

import org.junit.After;
import org.junit.Test;
import storage.Storage;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class ActionAddTest {

    private final InputStream originalIn = System.in;

    @After
    public void restoreStreams() {
        System.setIn(originalIn);
    }

    @Test
    public void test_Get_Info() {
        Storage storage = Storage.getInstance();
        Scanner scanner = new Scanner(System.in);

        ActionAdd aa = new ActionAdd(storage, scanner);

        assertThat(aa.getInfo()).isNotEqualTo(null);
    }

    @Test
    public void test_execute() {
        Storage storage = Storage.getInstance();
        String input = "Zosia\nHihihi\nHahaha\n";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        Scanner scanner = new Scanner(System.in);

        ActionAdd aa = new ActionAdd(storage, scanner);
        assertThat(aa.execute()).isEqualTo(true);
        assertThat(storage.getMessages().size()).isEqualTo(1);
    }
}
