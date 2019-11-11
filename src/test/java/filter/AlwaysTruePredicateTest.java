package filter;

import model.Message;
import org.junit.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

public class AlwaysTruePredicateTest {

    @Test
    public void test(){
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getAuthor()).thenReturn("Pinokio");

        AlwaysTruePredicate predicate = new AlwaysTruePredicate();

        boolean status = predicate.test(message);

        assertThat(status).isEqualTo(true);
    }


}
