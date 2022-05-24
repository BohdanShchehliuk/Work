package repository;

import entity.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketRepository {
   Optional <List<Ticket>>  getAll ();
}
