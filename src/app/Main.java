package app;

import app.model.impl.PrinterImpl;

public class Main {
    public static void main(String[] args) {
        PrinterImpl printer = new PrinterImpl();

        PrinterImpl.Message anonymousMessage = new PrinterImpl.Message("Hello, World!", "");
        printer.print(anonymousMessage);

        PrinterImpl.Message userMessage = new PrinterImpl.Message("Hello, Java!", "John Doe");
        printer.print(userMessage);

        PrinterImpl.Message emptyMessage = new PrinterImpl.Message("", "");
        printer.print(emptyMessage);
    }
}
