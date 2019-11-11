package facade;

import filter.ByAuthorPredicate;
import filter.ComplexPredicate;
import model.Message;
import org.junit.After;
import org.junit.Test;
import org.mockito.Mockito;
import storage.Storage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class ActionPrintTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;

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
    public void test_Execute_Simple() {
        Storage storage = Storage.getInstance();
        String input = "S\n";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        Scanner scanner = new Scanner(System.in);
        CommonDataCarrier common = new CommonDataCarrier();
        common.setPredicate(new ByAuthorPredicate("Zosia"));

        Message message = new Message();
        Mockito.when(message.getAuthor()).thenReturn("Zosia");
        Mockito.when(message.getTitle()).thenReturn("Hahaha");
        storage.add(message);
        String expected = new String("Author: Zosia\nTitle: Hahaha\n");

        ActionPrint aa = new ActionPrint(storage, scanner, common);

        assertThat(aa.execute()).isEqualTo(true);
        assertThat(outContent.toString()).isEqualTo(expected);
    }


}
