package store.bubbletill.commons;

import lombok.Getter;

public class LocalData {

    @Getter private int store;
    @Getter private int reg;
    @Getter private String token;
    @Getter private String backend;

    @Getter private String dbUsername;
    @Getter private String dbPassword;

}
