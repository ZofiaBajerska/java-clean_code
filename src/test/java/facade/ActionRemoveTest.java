package facade;

import org.junit.Test;
import storage.Storage;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class ActionRemoveTest {

    @Test
    public void test_Get_Info() {
        Storage storage = Storage.getInstance();
        Scanner scanner = new Scanner(System.in);
        CommonDataCarrier common = new CommonDataCarrier();

        ActionRemove aa = new ActionRemove(storage, scanner, common);

        assertThat(aa.getInfo()).isNotEqualTo(null);
    }
}
