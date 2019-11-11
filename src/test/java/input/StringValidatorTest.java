package input;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringValidatorTest {

    @Test
    public void test_True(){
        StringValidator validator = new StringValidator();

        assertThat(validator.test("A")).isEqualTo(true);
        assertThat(validator.get()).isNotEqualTo(null);
    }

    @Test
    public void test_False(){

        StringValidator validator = new StringValidator();

        assertThat(validator.test("")).isEqualTo(false);

    }
}
