package store.bubbletill.commons;

import lombok.Getter;

public class OperatorData {

    @Getter private String id;
    @Getter private String name;
    @Getter private String password;
    private int manager;
    private String posperms;
    private String boperms;

    public OperatorData(String id, String name, String password, int manager) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.manager = manager;
    }

    public boolean isManager() {
        return manager == 1;
    }

}
