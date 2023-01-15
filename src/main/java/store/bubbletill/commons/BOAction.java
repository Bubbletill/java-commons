package store.bubbletill.commons;

import lombok.Getter;

public enum BOAction {

    // General BO features
    ACCESS("BO Access", false);


    @Getter
    private String displayName;
    @Getter private boolean loginIfNoPermission;

    private BOAction(String displayName, boolean loginIfNoPermission) {
        this.displayName = displayName;
        this.loginIfNoPermission = loginIfNoPermission;
    }
}
