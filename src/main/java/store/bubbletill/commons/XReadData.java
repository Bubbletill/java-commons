package store.bubbletill.commons;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashMap;

public class XReadData {

    @Getter private int store;
    @Getter private int register;
    @Getter private String operator;
    @Getter private String requestDateTime;

    @Getter @Setter private int transactionCount;
    @Getter private double grandTotal;
    @Getter private int unitsSold;

    @Getter private HashMap<Integer, Double> totalPerCategory;
    @Getter private HashMap<PaymentType, Double> totalPerPaymentType;
    @Getter private HashMap<TransactionType, Double> totalPerTransactionType;

    @Getter @Setter private int transVoidTotal;
    @Getter @Setter private int itemVoidTotal;

    @Getter @Setter private String regOpened;
    @Getter @Setter private String regClosed;

    public XReadData(int store, int register, String operator) {
        this.store = store;
        this.register = register;
        this.operator = operator;
        this.requestDateTime = Formatters.dateTimeFormatter.format(LocalDateTime.now());

        totalPerCategory = new HashMap<>();
        totalPerPaymentType = new HashMap<>();
        totalPerTransactionType = new HashMap<>();

        transVoidTotal = 0;
        itemVoidTotal = 0;
    }

    public void incrementGrandTotal(double amount) {
        grandTotal += amount;
    }

    public void incrementUnitsSold(int units) {
        unitsSold += units;
    }

    public void incrementTransVoidTotal() {
        transVoidTotal++;
    }

    public void incrementItemVoidTotal() {
        itemVoidTotal++;
    }

}
