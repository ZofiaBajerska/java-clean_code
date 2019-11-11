package facade;

import filter.ComplexPredicate;
import org.junit.After;
import org.junit.Test;
import storage.Storage;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class ActionBuilderFilterTest {

    private final InputStream originalIn = System.in;

    @After
    public void restoreStreams() {
        System.setIn(originalIn);
    }

    @Test
    public void test_Get_Info() {
        Storage storage = Storage.getInstance();
        Scanner scanner = new Scanner(System.in);
        CommonDataCarrier common = new CommonDataCarrier();

        ActionBuildFilter aa = new ActionBuildFilter(storage, scanner, common);

        assertThat(aa.getInfo()).isNotEqualTo(null);
    }

    @Test
    public void test_execute() {
        Storage storage = Storage.getInstance();
        String input = "AtED\nZosia\nHihihi\nHahaha\n11-12-19 17:09:09\n";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        Scanner scanner = new Scanner(System.in);
        CommonDataCarrier common = new CommonDataCarrier();

        ActionBuildFilter aa = new ActionBuildFilter(storage, scanner, common);

        assertThat(aa.execute()).isEqualTo(true);
        assertThat(common.getPredicate()).isNotEqualTo(null);
        assertThat(common.getPredicate()).isInstanceOf(ComplexPredicate.class);
    }
}
