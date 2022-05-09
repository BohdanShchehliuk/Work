package logic;

import dao.*;
import dao.impl.*;
import entity.*;
import lombok.Data;

@Data
public class Main {
    private static PassengerDao passengerDao = new PassengerDaoImpl();
    private static AircraftDao aircraftDao = new AircraftDaoImpl();
    private static AircraftTypesDao aircraftTypesDao = new AircraftTypesDaoImpl();
    private static AirlineDao airlineDao = new AirlineDaoImpl();
    private static FlightDao flightDao = new FlightDaoImpl();
    private static GateDao gateDao = new GateDaoImpl();
    private static PersonalDao personalDao = new PersonalDaoImpl();
    private static RoutesDao routesDao = new RoutesDaoImp();
    private static SalaryDao salaryDao = new SalaryDaoImpl();
    private static PersonalInfoDao personalInfoDao = new PersonalInfoDaoImpl();
    private static TerminalDao terminalDao = new TerminalDaoImpl();
    private static TicketDao ticketDao = new TicketDaoImpl();

    public static void main(String[] args) {

//              Passenger passenger = Passenger.builder()
//                .passport("AA1222")
//                .surname("Petrenko")
//                .name("Ivan")
//                .ticketId(1)
//                 .build();
//
//        passengerDao.add(passenger);
//        passenger.setBirthdate(new Date());
//        passengerDao.update(passenger);
//        System.out.println(passengerDao.get(1));
//        passengerDao.delete(passenger);
//        System.out.println(passengerDao.getAll());
//        System.out.println(passengerDao.get(5));
//        System.out.println(salaryDao.getAll());

//        Ticket ticket =  Ticket.builder()
//               .seat(333)
//                .build();
//       System.out.println(ticket);
//
//        ticketDao.add(ticket);
//        System.out.println(ticketDao.getAll());
//        ticket.setSeat(999);
//        ticketDao.update(ticket);
//        System.out.println(ticketDao.getAll());
//        ticketDao.delete(ticket);
//        System.out.println(ticketDao.getAll());
//        System.out.println(ticketDao.get(1));
//
//        System.out.println(aircraftDao.get(3).getAirline());

        //System.out.println((aircraftDao.get(3).getAirline()) +"  ;   "+ airlineDao.get(2).getAircrafts());
//        System.out.println(passengerDao.get(1).getSurname() + " has tickets: "+ passengerDao.get(1).getTickets());
//       System.out.println(ticketDao.get(1));
//       System.out.println(aircraftDao.get(1).getAircraftTypes());
        //System.out.println(passengerDao.getAll());
        // passengerDao.get(1);
        //System.out.println(flightDao.get(1).getAircraft().getAircraftTypes().getCapacity());
        // System.out.println(gateDao.get(1));
        //   System.out.println(passengerDao.get(1));
        //   System.out.println(personalDao.get(1).getGate().getTerminal().getName());
//System.out.println(personalInfoDao.get(1).getPersonal().getPersonalInfo().isMarried());
//        System.out.println(salaryDao.get(2));
//        System.out.println(ticketDao.get(3));
        System.out.println(passengerDao.getByIdWithTickets(1));
    }
}




