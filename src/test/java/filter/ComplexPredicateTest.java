package filter;

import model.Message;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class ComplexPredicateTest {

    @Test
    public void test_Text(){
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getText()).thenReturn("hahaha");

        ComplexPredicate complex = new ComplexPredicate();
        complex.addPredicate(new ByTextPredicate("hahaha"));

        boolean status = complex.test(message);

        assertThat(status).isEqualTo(true);
    }
    @Test
    public void test_Author(){
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getAuthor()).thenReturn("Zosia");

        ComplexPredicate complex = new ComplexPredicate();
        complex.addPredicate(new ByAuthorPredicate("Zosia"));

        boolean status = complex.test(message);

        assertThat(status).isEqualTo(true);
    }
    @Test
    public void test_Title(){
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getTitle()).thenReturn("Hihihi");

        ComplexPredicate complex = new ComplexPredicate();
        complex.addPredicate(new ByTitlePredicate("Hihihi"));

        boolean status = complex.test(message);

        assertThat(status).isEqualTo(true);
    }
    @Test
    public void test_Date(){
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getDate()).thenReturn(new Date(2019, Calendar.MAY, 11, 17, 12, 12));

        ComplexPredicate complex = new ComplexPredicate();
        complex.addPredicate(new ByDatePredicate(new Date(2019, Calendar.MAY, 11, 17, 12, 13)));

        boolean status = complex.test(message);

        assertThat(status).isEqualTo(true);
    }
    @Test
    public void test_All_True(){
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getText()).thenReturn("hahaha");
        Mockito.when(message.getDate()).thenReturn(new Date(2019, Calendar.NOVEMBER, 11, 17, 12, 12));
        Mockito.when(message.getTitle()).thenReturn("Hihihi");
        Mockito.when(message.getAuthor()).thenReturn("Zosia");

        ComplexPredicate complex = new ComplexPredicate();
        complex.addPredicate(new ByTextPredicate("hahaha"));
        complex.addPredicate(new ByDatePredicate(new Date(2019, Calendar.NOVEMBER, 11, 17, 12, 13)));
        complex.addPredicate(new ByTitlePredicate("Hihihi"));
        complex.addPredicate(new ByAuthorPredicate("Zosia"));

        boolean status = complex.test(message);

        assertThat(status).isEqualTo(true);
    }
    @Test
    public void test_All_False(){
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getText()).thenReturn("Hahaha");
        Mockito.when(message.getDate()).thenReturn(new Date(2019, Calendar.NOVEMBER, 11, 17, 12, 12));
        Mockito.when(message.getTitle()).thenReturn("Hihihi");
        Mockito.when(message.getAuthor()).thenReturn("Zosia");

        ComplexPredicate complex = new ComplexPredicate();
        complex.addPredicate(new ByTextPredicate("hahaha"));
        complex.addPredicate(new ByDatePredicate(new Date(2019, Calendar.NOVEMBER, 11, 17, 12, 13)));
        complex.addPredicate(new ByTitlePredicate("Hihihi"));
        complex.addPredicate(new ByAuthorPredicate("Zosia"));

        boolean status = complex.test(message);

        assertThat(status).isEqualTo(false);
    }

}
