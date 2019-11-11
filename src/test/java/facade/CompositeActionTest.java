package facade;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CompositeActionTest {
    @Test
    public void test_Get_Info() {
        String string = "Coś";

        CompositeAction aa = new CompositeAction(string);

        assertThat(aa.getInfo()).isNotEqualTo(null);
        assertThat(aa.getInfo()).isEqualTo(string);
    }
}
