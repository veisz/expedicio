package hu.radio.Controller;

import hu.radio.domain.model.RadioMessage;

import java.util.List;

public class MessageService {

    private final List<RadioMessage> messages;

    public MessageService(List<RadioMessage> messages) {
        this.messages = messages;
    }
}
