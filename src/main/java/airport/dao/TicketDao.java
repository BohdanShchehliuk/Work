package airport.dao;

import airport.entity.Ticket;

import java.util.LinkedList;
import java.util.List;

public interface TicketDao extends GeneralDao<Ticket> {
    void addAll(List <Ticket> list);
}
