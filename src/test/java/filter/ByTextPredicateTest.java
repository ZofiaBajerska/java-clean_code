package filter;

import model.Message;
import org.junit.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

public class ByTextPredicateTest {

    @Test
    public void test_True(){
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getText()).thenReturn("hahaha");

        ByTextPredicate predicate = new ByTextPredicate("hahaha");

        boolean status = predicate.test(message);

        assertThat(status).isEqualTo(true);
    }

    @Test
    public void test_False(){
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getText()).thenReturn("Hahaha");

        ByTextPredicate predicate = new ByTextPredicate("hahaha");

        boolean status = predicate.test(message);

        assertThat(status).isEqualTo(false);
    }
}
