package input;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DateTimeValidatorTest {

    @Test
    public void test_True(){
        DateTimeValidator validator = new DateTimeValidator();

        assertThat(validator.test("11-11-19 19:20:20")).isEqualTo(true);
        assertThat(validator.get()).isNotEqualTo(null);
    }

    @Test
    public void test_False(){

        DateTimeValidator validator = new DateTimeValidator();

        assertThat(validator.test("1112-11-2019 19-20:20")).isEqualTo(false);

    }
}
