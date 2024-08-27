package app.model.impl;

import app.model.Printer;

public class PrinterImpl implements Printer {
    public static class Message {
        private String text;
        private String sender;

        public Message(String text, String sender) {
            this.text = text;
            this.sender = sender;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getSender() {
            return sender;
        }

        public void setSender(String sender) {
            this.sender = sender;
        }
    }

    @Override
    public void print(Message message) {
        if (isAnonymousMessage(message)) {
            handleAnonymousMessage(message);
            return;
        }

        handleUserMessage(message);
    }

    private boolean isAnonymousMessage (Message message) {
        return message.getSender() == null || message.getSender().isEmpty();
    }

    private void handleAnonymousMessage (Message message) {
        if (message.getText().isEmpty() || message.getText() == null) {
            handleEmptyMessage(message);
            return;
        }

        System.out.println("Анонімний користувач відправив повідомлення: " + message.getText());
    }

    private void handleEmptyMessage (Message message) {
        Printer emptyMessageHandler = new Printer() {
            @Override
            public void print(Message message) {
                System.out.println("Опрацьовується пусте повідомлення від анонімного користувача...");
            }
        };
        emptyMessageHandler.print(null);
    }

    private void handleUserMessage (Message message) {
        System.out.println("Користувач " + message.getSender()
                + " відправив повідомлення: " + message.getText());
    }
}
