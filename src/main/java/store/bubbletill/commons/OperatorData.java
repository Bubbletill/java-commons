package store.bubbletill.commons;

public class OperatorData {

    private String id;
    private String name;
    private String password;
    private int manager;
    private String posperms;
    private String boperms;

    public String getOperatorId() {
        return id;
    }

    public String getName() { return name; }

    public boolean isManager() {
        return manager == 1;
    }

    public String getPassword() {
        return password;
    }
}
