package facade;

import org.junit.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class ActionQuitTest {
    @Test
    public void test_Get_Info() {
        Scanner scanner = new Scanner(System.in);

        ActionQuit aa = new ActionQuit(scanner);

        assertThat(aa.getInfo()).isNotEqualTo(null);
    }
}
