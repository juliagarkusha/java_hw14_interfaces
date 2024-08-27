package app.model;

import app.model.impl.PrinterImpl;

public interface Printer {
    void print(PrinterImpl.Message message);
}
