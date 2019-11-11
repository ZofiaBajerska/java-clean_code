package facade;

import input.DateTimeValidator;
import storage.Storage;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

public class StorageFacade {

    private static final StorageFacade INSTANCE = new StorageFacade();

    private Storage storage = Storage.getInstance();
    private Scanner scanner = new Scanner(System.in);
    private final Logger log = Logger.getLogger(DateTimeValidator.class.getName());
    private Map<Integer, UserAction> actions = new HashMap<>();

    private StorageFacade() {
        actions.put(1, new ActionAdd(storage, scanner));
        actions.put(2, new ActionPrint(storage, scanner));
        CompositeAction composite = new CompositeAction("Print some messages");
        CommonDataCarrier common = new CommonDataCarrier();
        composite.addAction(new ActionBuildFilter(storage, scanner, common));
        composite.addAction(new ActionPrint(storage, scanner, common));
        actions.put(3, composite);
        composite = new CompositeAction("Remove messages");
        composite.addAction(new ActionBuildFilter(storage, scanner, common));
        composite.addAction(new ActionPrint(storage, scanner, common));
        composite.addAction(new ActionRemove(storage, scanner, common));
        actions.put(4, composite);
        actions.put(5, new ActionQuit(scanner));
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
        int cmd;

        try {
            cmd = scanner.nextInt();
            scanner.skip("\n");
        } catch (InputMismatchException e){
            log.warning("Wrong operation");
            log.warning(e.getMessage());
            return true;
        }

        if (actions.containsKey(cmd)){
            if (!actions.get(cmd).execute()) {
                return false;
            }
        }
        return true;
    }
}
