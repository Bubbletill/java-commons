package store.bubbletill.commons;

import lombok.Getter;

public class SuspendedListData {

    @Getter private String date;
    @Getter private String oper;
    @Getter private Integer reg;
    @Getter private Integer usid;
    @Getter private double total;

    public SuspendedListData() { }

    public String getStringTotal() {
        return "£" + Formatters.decimalFormatter.format(getTotal());
    }
}
