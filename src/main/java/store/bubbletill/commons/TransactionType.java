package store.bubbletill.commons;

public enum TransactionType {

    SALE("Sale"),
    EXCHANGE("Exchange"),
    REFUND("Refund");

    private String localName;

    private TransactionType(String localName) {
        this.localName = localName;
    }

    public String getLocalName() {
        return localName;
    }
}
