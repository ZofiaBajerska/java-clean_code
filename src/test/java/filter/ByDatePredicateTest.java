package filter;

import model.Message;
import org.junit.Test;
import org.mockito.Mockito;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class ByDatePredicateTest {

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yy HH:mm:ss");

    @Test
    public void test_Before(){
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getDate()).thenReturn(new Date(2019, 11, 11, 17, 12, 12));

        ByDatePredicate predicate = new ByDatePredicate(new Date(2019, 11, 11, 17, 12, 13));

        boolean status = predicate.test(message);

        assertThat(status).isEqualTo(true);
    }

    @Test
    public void test_After(){
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getDate()).thenReturn(new Date(2019, 11, 11, 17, 12, 12));

        ByDatePredicate predicate = new ByDatePredicate(new Date(2019, 11, 11, 17, 12, 11));

        boolean status = predicate.test(message);

        assertThat(status).isEqualTo(false);
    }

    @Test
    public void test_Equal(){
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getDate()).thenReturn(new Date(2019, 11, 11, 17, 12, 12));

        ByDatePredicate predicate = new ByDatePredicate(new Date(2019, 11, 11, 17, 12, 12));

        boolean status = predicate.test(message);

        assertThat(status).isEqualTo(false);
    }
}
