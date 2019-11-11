package facade;

import filter.ByAuthorPredicate;
import model.Message;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import storage.Storage;

import java.io.*;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ActionPrintTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    public void test_Get_Info() {
        Storage storage = Storage.getInstance();
        Scanner scanner = new Scanner(System.in);

        ActionPrint aa = new ActionPrint(storage, scanner);

        assertThat(aa.getInfo()).isNotEqualTo(null);
    }

     @Test
    public void test_Execute_Full() {
        Storage storage = Storage.getInstance();
        String input = "F\n";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        Scanner scanner = new Scanner(System.in);
        CommonDataCarrier common = new CommonDataCarrier();
        common.setPredicate(new ByAuthorPredicate("Zosia"));

        Message message = new Message();
        message.setAuthor("Zosia");
        message.setTitle("Hahaha");
        message.setText("hihihi");
        message.setDate(new Date(19, Calendar.MAY, 11, 17, 12, 12));

        String expected = "Date: 11-05-19 17:12:12\nAuthor: Zosia\nTitle: Hahaha\nText: hihihi\n";
        storage.add(message);

        ActionPrint aa = new ActionPrint(storage, scanner, common);

        assertThat(aa.execute()).isEqualTo(true);
        assertThat(outContent.toString()).endsWith(expected);
    }

    @Test
    public void test_Execute_Simple() {
        Storage storage = Storage.getInstance();
        String input = "S\n";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        Scanner scanner = new Scanner(System.in);
        CommonDataCarrier common = new CommonDataCarrier();
        common.setPredicate(new ByAuthorPredicate("Zosia"));

        Message message = new Message();
        message.setAuthor("Zosia");
        message.setTitle("Hahaha");
        storage.add(message);
        String expected = "Author: Zosia\nTitle: Hahaha\n";

        ActionPrint aa = new ActionPrint(storage, scanner, common);

        assertThat(aa.execute()).isEqualTo(true);
        assertThat(outContent.toString()).endsWith(expected);
    }
}
