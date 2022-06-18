package airport.repository.impl;

import airport.dao.impl.TicketDaoImpl;
import airport.dto.TicketDto;
import airport.entity.Ticket;
import airport.repository.TicketRepository;

import java.util.List;
import java.util.Optional;

public class TicketRepositoryImpl implements TicketRepository {
    @Override
    public List<Ticket> getAll() {
        return new TicketDaoImpl().getAll();
    }

    @Override
    public Ticket add(Ticket ticket) {
        return new TicketDaoImpl().add(ticket);
    }

    @Override
    public Ticket update(Ticket ticket) {
      return new  TicketDaoImpl().update(ticket);
    }

    @Override
    public boolean delete(Ticket ticket) {
        return false;
    }

    @Override
    public Ticket get(int id) {
        return null;
    }
}
