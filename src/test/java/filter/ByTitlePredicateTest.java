package filter;

import model.Message;
import org.junit.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

public class ByTitlePredicateTest {

    @Test
    public void test_True(){
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getTitle()).thenReturn("hahaha");

        ByTitlePredicate predicate = new ByTitlePredicate("hahaha");

        boolean status = predicate.test(message);

        assertThat(status).isEqualTo(true);
    }

    @Test
    public void test_False(){
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getTitle()).thenReturn("Hahaha");

        ByTitlePredicate predicate = new ByTitlePredicate("hahaha");

        boolean status = predicate.test(message);

        assertThat(status).isEqualTo(false);
    }
}
