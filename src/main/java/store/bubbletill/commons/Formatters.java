package store.bubbletill.commons;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;

public class Formatters {

    public static final DecimalFormat decimalFormatter = new DecimalFormat("0.00");

    public static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");
    public static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yy");
    public static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

}
