package airport.enam;

public enum TicketStatus {
    TICKET_STATUS_NOT_SOLD(0),
    TICKET_STATUS_SOLD(1);

    private final int status;

    TicketStatus(final int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}

