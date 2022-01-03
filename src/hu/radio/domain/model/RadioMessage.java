package hu.radio.domain.model;

public class RadioMessage {
    private final int days;
    private final int recieverid;
    private final String message;

    public RadioMessage(int days, int recieverId, String message) {
        this.days = days;
        this.recieverid = recieverId;
        this.message = message;
    }

    public int getDays() {
        return days;
    }

    public int getRecieverId() {
        return recieverid;
    }

    public String getMessage() {
        return message;
    }
}
