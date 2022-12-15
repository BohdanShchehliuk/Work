# AIRPORT

This is my pet project with microservices on JAVA with Spring.
This project contains next services
## Services
- Admin
- Client
- Personal
- EurekaServerManager

Each service has it own responsibilities. Let`s start.
- Admin: there all demonstrate controllers that are in the project: FlightСontroller, TicketСontroller, 
  PersonalСontroller and PassengerСontroller. All tests we need are here.
  FlightСontroller returns flights by selected period or all available flights/
  Passenger controller (each user can have multiple passengers) have endpoints to access all passengers and their tickets.
  ТicketСontroller  have endpoints to get all free tickets by flight, and buy ticket on flight.
  PersonalСontroller returns information about personal from database;
- Client: FlightСontroller, TicketСontroller - clients could select flight, by ticket e.t.c.
- Personal: PersonalСontroller - for work in the database by employees of the personnel department,
  accounting and so on.
- EurekaServerManager Netflix Eureka

Also docker-compose file to get all containers dockerized.