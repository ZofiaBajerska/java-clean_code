package model;

import org.junit.Test;
import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class MessageBuilderTest {

    @Test
    public void test_All(){
        MessageBuilder builder = new MessageBuilder();
        builder.withText("hahaha");
        builder.withAuthor("Zosia");
        builder.withTitle("Hihihi");
        builder.withDate(new Date(2019, Calendar.NOVEMBER, 11, 17, 12, 13));

        Message message = builder.build();
        assertThat(message).isNotEqualTo(null);

        assertThat(message.getAuthor()).isEqualTo("Zosia");
        assertThat(message.getText()).isEqualTo("hahaha");
        assertThat(message.getTitle()).isEqualTo("Hihihi");
    }
}
