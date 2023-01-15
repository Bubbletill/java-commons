package store.bubbletill.commons;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;

public class OperatorData {

    @Getter private String id;
    @Getter private String name;
    @Getter private String password;
    @Getter private ArrayList<Integer> groups;

    public OperatorData(String id, String name, String password, String groups) {
        this.id = id;
        this.name = name;
        this.password = password;

        Gson gson = new Gson();
        this.groups = gson.fromJson(groups, new TypeToken<ArrayList<Integer>>() {}.getType());
    }

    public boolean canPerformAction(HashMap<Integer, OperatorGroup> allGroups, POSAction action) {
        for (int group : groups) {
            if (allGroups.get(group).getAllowedPosActions().contains(action))
                return true;
        }

        return false;
    }

    public boolean canPerformAction(HashMap<Integer, OperatorGroup> allGroups, BOAction action) {
        for (int group : groups) {
            if (allGroups.get(group).getAllowedBoActions().contains(action))
                return true;
        }

        return false;
    }

}
