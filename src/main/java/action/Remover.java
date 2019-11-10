package action;

import filter.ByAnyPredicate;
import storage.Storage;

public class Remover {
    private ByAnyPredicate predicate;
    public Remover(ByAnyPredicate predicate){
        this.predicate = predicate;
    }

    public boolean execute(Storage storage){
        return storage.getMessages().removeIf(predicate);
    }

    public boolean execute(){
        return Storage.getInstance().getMessages().removeIf(predicate);
    }
}
