package storage;

import model.Message;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StorageTest {

    @Test
    public void test_Add(){
        Message message = new Message();
        message.setTitle("Hahaha");

        Storage storage = Storage.getInstance();

        assertThat(storage).isNotEqualTo(null);
        int count = storage.getMessages().size();

        storage.add(message);
        assertThat(storage.getMessages().size()).isEqualTo(count+1);

        boolean status = false;
        try {
            storage.add(null);
        }
        catch (NullPointerException e){
            status = true;
        }
        assertThat(status).isEqualTo(true);
    }

}
