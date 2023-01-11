package store.bubbletill.commons;

import lombok.Getter;

public enum TransactionType {

    VOID("Void", false),
    POST_VOID("Post Void", false),

    SALE("Sale", true),
    EXCHANGE("Exchange", true),
    REFUND("Refund", true);

    @Getter private String localName;
    private boolean promptReceipt;

    private TransactionType(String localName, boolean promptReceipt) {
        this.localName = localName;
        this.promptReceipt = promptReceipt;
    }

    public boolean promptReceipt() {
        return promptReceipt;
    }
}
