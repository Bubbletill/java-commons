package store.bubbletill.commons;

import lombok.Getter;

public class CategoryData {

    @Getter private int id;
    @Getter private String description;

    public CategoryData(int id, String description) {
        this.id = id;
        this.description = description;
    }

}
