package repository.impl;

import dao.impl.TicketDaoImpl;
import entity.Ticket;
import repository.TicketRepository;

import java.util.List;
import java.util.Optional;

public class TicketRepositoryImpl implements TicketRepository {

    @Override
    public Optional<List<Ticket>> getAll() {
        return Optional.ofNullable(new TicketDaoImpl().getAll());
    }
}

