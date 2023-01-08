package store.bubbletill.commons;

public enum TransactionType {

    VOID("Void", false),
    POST_VOID("Post Void", false),

    SALE("Sale", true),
    EXCHANGE("Exchange", true),
    REFUND("Refund", true);

    private String localName;
    private boolean promptReceipt;

    private TransactionType(String localName, boolean promptReceipt) {
        this.localName = localName;
        this.promptReceipt = promptReceipt;
    }

    public String getLocalName() {
        return localName;
    }

    public boolean promptReceipt() {
        return promptReceipt;
    }
}
