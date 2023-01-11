package store.bubbletill.commons;

import lombok.Getter;

public enum PaymentType {

    CASH("Cash", true),
    CARD("Debit/Credit", false),
    VOID("Void", false);

    @Getter private String localName;
    private boolean requiresCashDraw;

    private PaymentType(String localName, boolean requiresCashDraw) {
        this.localName = localName;
        this.requiresCashDraw = requiresCashDraw;
    }

    public boolean requiresCashDraw() { return requiresCashDraw; }
}
