package facade;

import java.util.ArrayList;
import java.util.List;

public class CompositeAction implements UserAction {
    private List<UserAction> actions = new ArrayList();
    private String info;

    public CompositeAction(String info){
        this.info = info;
    }

    @Override
    public String  getInfo(){
        return info;
    }

    @Override
    public boolean execute() {
        for (UserAction action : actions) {
            if (!action.execute()) {
                return false;
            }
        }
        return true;
    }

    public void addAction(UserAction action) {
        actions.add(action);
    }
}
