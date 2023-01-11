package store.bubbletill.commons;

import lombok.Getter;
import lombok.Setter;

public class ApiRequestData {

    @Getter @Setter private boolean success;
    @Getter @Setter private String message;

    public ApiRequestData(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

}
