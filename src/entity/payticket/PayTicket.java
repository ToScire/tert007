package entity.payticket;

import entity.ticket.Ticket;
import entity.user.User;

/**
 * Created by Vadim on 04.04.2016.
 */
public class PayTicket {
    private int id;
    private Ticket ticket;
    private User user;
    private PayStatus status;
    private PaySystem system;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PayStatus getStatus() {
        return status;
    }

    public void setStatus(PayStatus status) {
        this.status = status;
    }

    public PaySystem getSystem() {
        return system;
    }

    public void setSystem(PaySystem system) {
        this.system = system;
    }
}
