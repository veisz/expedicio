package hu.radio.Controller;

import hu.radio.domain.model.RadioMessage;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MessageService {

    private final List<RadioMessage> messages;

    public MessageService(List<RadioMessage> messages) {
        this.messages = messages;
    }

    public int getFirstMessageRecieverId() {
        int first = 0;
        return messages.get(first).getRecieverId();
    }
    public int getLastMessageRecieverId() {
        int last = messages.size() - 1;
        return messages.get(last).getRecieverId();
    }

    public String getDayAndReceiverIdByContent(String text) {
        return messages.stream()
                .filter(i -> i.contains(text))
                .map(i -> String.format("%d. nap %d. rádióamatőr", i.getDays(), i.getRecieverId()))
                .collect(Collectors.joining("\r\n"));
    }

    public String getDayStatistic() {
        return IntStream.range(1, 12)
                .mapToObj(i -> String.format("%d. nap: %d rádióamatőr", i, countDailyMessages(i)))
                .collect(Collectors.joining("\r\n"));
    }

    private long countDailyMessages(int days) {
        return messages.stream()
                .filter(i -> i.getDays() == days)
                .count();
    }

    public List<String> getMergedMessages() {
        return IntStream.range(1, 12)
                .mapToObj(i -> getMessagesByDay())
                .map()
    }

    private List<String> getMessagesByDay(int day) {
        return messages.stream()
                .filter(i -> i.getDays() == day)
                .map(i -> i.getMessage())
                .collect(Collectors.toList());
    }
}
