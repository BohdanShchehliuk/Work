package repository;

import entity.Passenger;

import java.util.List;
import java.util.Optional;

public interface PassengerRepository {
    Optional <List <Passenger>> getAll();
}
