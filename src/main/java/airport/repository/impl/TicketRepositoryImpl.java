package airport.repository.impl;

import airport.dao.impl.TicketDaoImpl;
import airport.entity.Ticket;
import airport.repository.TicketRepository;

import java.util.List;
import java.util.Optional;

public class TicketRepositoryImpl implements TicketRepository {

    @Override
    public Optional<List<Ticket>> getAll() {
        return Optional.ofNullable(new TicketDaoImpl().getAll());
    }
}

