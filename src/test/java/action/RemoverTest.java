package action;

import model.Message;
import org.junit.Test;
import org.mockito.Mockito;
import storage.Storage;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;


public class RemoverTest {

    @Test
    public void execute_False(){
        Message message = new Message();
        message.setTitle("hahaha");
        List<Message> list = new ArrayList<>();
        list.add(message);
        Storage storage = Mockito.mock(Storage.class);
        Mockito.when(storage.getMessages()).thenReturn(list);

        Remover remover = new Remover(new Predicate<Message>() {
            @Override
            public boolean test(Message message) {
                return false;
            }
        });

        boolean status = remover.execute(storage);
        assertThat(status).isEqualTo(false);
        assertThat(storage.getMessages()).isNotEmpty();
    }

    @Test
    public void execute_True(){
        Message message = new Message();
        message.setTitle("hahaha");
        List<Message> list = new ArrayList<>();
        list.add(message);
        Storage storage = Mockito.mock(Storage.class);
        Mockito.when(storage.getMessages()).thenReturn(list);

        Remover remover = new Remover(new Predicate<Message>() {
            @Override
            public boolean test(Message message) {
                return true;
            }
        });

        boolean status = remover.execute(storage);
        assertThat(status).isEqualTo(true);
        assertThat(storage.getMessages()).isEmpty();
    }
}
