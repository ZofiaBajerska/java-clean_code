package facade;

import model.Message;
import storage.Storage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;

public class StorageFacade {

    private static final StorageFacade INSTANCE = new StorageFacade();

    private Storage storage = Storage.getInstance();
    private Scanner scanner = new Scanner(System.in);
    private Map<Integer, UserAction> actions = new HashMap<>();

    private StorageFacade() {
        actions.put(1, new ActionAdd(storage, scanner));
        actions.put(2, new ActionPrint(storage, scanner));
        CompositeAction composite = new CompositeAction("Print some messages");
        Predicate<Message> predicate;
        composite.addAction(new ActionBuildFilter(storage, scanner, predicate));
        composite.addAction(new ActionPrint(storage, scanner, predicate));
        actions.put(3, composite);
        composite = new CompositeAction("Remove messages");
        composite.addAction(new ActionBuildFilter(storage, scanner, predicate));
        composite.addAction(new ActionPrint(storage, scanner, predicate));
        composite.addAction(new ActionRemove(storage, scanner, predicate));
        actions.put(4, composite);
        actions.put(5, new ActionQuit());
    }

    public static StorageFacade getInstance() {
        return INSTANCE;
    }

    public void printMenu(){
        for (Integer key : actions.keySet()) {
            System.out.println(key + " " + actions.get(key).getInfo());
        }
    }

    public boolean execute(){
        int cmd = scanner.nextInt();
        scanner.skip("\n");

        if (actions.containsKey(cmd)){
            actions.get(cmd).execute();
        }
        return true;
    }
}
