package filter;

import model.Message;
import org.junit.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;


public class ByAuthorPredicateTest {

    @Test
    public void test_True(){
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getAuthor()).thenReturn("Zosia");

        ByAuthorPredicate predicate = new ByAuthorPredicate("Zosia");

        boolean status = predicate.test(message);

        assertThat(status).isEqualTo(true);
    }

    @Test
    public void test_False(){
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getAuthor()).thenReturn("Zosia");

        ByAuthorPredicate predicate = new ByAuthorPredicate("zosia");

        boolean status = predicate.test(message);

        assertThat(status).isEqualTo(false);
    }


}
