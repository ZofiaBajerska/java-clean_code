package filter;

import model.Message;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class ComplexPredicateBuilderTest {

    @Test
    public void test_All_True(){
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getText()).thenReturn("hahaha");
        Mockito.when(message.getDate()).thenReturn(new Date(2019, Calendar.NOVEMBER, 11, 17, 12, 12));
        Mockito.when(message.getTitle()).thenReturn("Hihihi");
        Mockito.when(message.getAuthor()).thenReturn("Zosia");

        ComplexPredicateBuilder builder = new ComplexPredicateBuilder();
        builder.withText("hahaha");
        builder.withAuthor("Zosia");
        builder.withTitle("Hihihi");
        builder.withDate(new Date(2019, Calendar.NOVEMBER, 11, 17, 12, 13));

        ComplexPredicate filter = builder.build();

        boolean status = filter.test(message);

        assertThat(status).isEqualTo(true);
    }

    @Test
    public void test_Two_False(){
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getText()).thenReturn("Hihihi");
        Mockito.when(message.getAuthor()).thenReturn("Zosia");

        ComplexPredicateBuilder builder = new ComplexPredicateBuilder();
        builder.withText("hahaha");
        builder.withAuthor("Zosia");

        ComplexPredicate filter = builder.build();

        boolean status = filter.test(message);

        assertThat(status).isEqualTo(false);
    }
}
