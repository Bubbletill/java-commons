package store.bubbletill.commons;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class OperatorGroup {

    @Getter private int id;
    @Getter private String name;
    @Getter private ArrayList<POSAction> allowedPosActions = new ArrayList<>();
    @Getter private ArrayList<BOAction> allowedBoActions = new ArrayList<>();

    public OperatorGroup(int id, String name, String allowedPosActions, String allowedBoActions) {
        this.id = id;
        this.name = name;

        Gson gson = new Gson();

        if (allowedPosActions.equals("*"))
            this.allowedPosActions.addAll(List.of(POSAction.values()));
        else
            this.allowedPosActions = gson.fromJson(allowedPosActions, new TypeToken<ArrayList<POSAction>>() {}.getType());

        if (allowedBoActions.equals("*"))
            this.allowedBoActions.addAll(List.of(BOAction.values()));
        else
            this.allowedBoActions = gson.fromJson(allowedBoActions, new TypeToken<ArrayList<BOAction>>() {}.getType());
    }

}
