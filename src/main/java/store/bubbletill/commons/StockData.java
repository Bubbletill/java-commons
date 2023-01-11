package store.bubbletill.commons;

import lombok.Getter;
import lombok.Setter;

public class StockData {

    @Getter private int category;
    @Getter private int itemCode;
    @Getter private String description;
    @Getter private double price;
    @Getter @Setter private double priceReduction;
    @Getter @Setter private boolean refund;

    public StockData(int category, int itemCode, String description, double price) {
        this.category = category;
        this.itemCode = itemCode;
        this.description = description;
        this.price = price;
        this.priceReduction = 0;
        this.refund = false;
    }

    public double getPriceWithReduction() { return price - priceReduction; }

}
