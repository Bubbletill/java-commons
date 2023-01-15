package store.bubbletill.commons;

import lombok.Getter;

public enum POSAction {

    // General POS features
    ACCESS("POS Access", false),
    RETURN("Return Transaction", false),
    VOID_ITEM("Item Void", true),
    ITEM_DISCOUNT("Item Discount", true),
    TRANSACTION_DISCOUNT("Transaction Discount", true),
    SUSPEND("Suspend Transaction", true),
    RESUME("Resume Transaction", true),

    // Transaction-based Admin actions
    VOID_TRANSACTION("Transaction Void", true),
    POST_VOID("Post Void", true),
    REPRINT_RECEIPT("Reprint Receipt", true),
    NO_SALE("No Sale", true),

    // Other admin actions
    XREAD("X Read", true),
    DB_RESYNC("Database Resync", true),

    // Cash management
    DECLARE_FLOAT("Declare Opening Float", true);



    @Getter private String displayName;
    @Getter private boolean loginIfNoPermission;

    private POSAction(String displayName, boolean loginIfNoPermission) {
        this.displayName = displayName;
        this.loginIfNoPermission = loginIfNoPermission;
    }
}
