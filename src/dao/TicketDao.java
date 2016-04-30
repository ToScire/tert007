package dao;

import entity.seance.Seance;
import entity.ticket.Ticket;

import java.sql.Date;
import java.util.List;

/**
 * Created by Vadim on 04.04.2016.
 */
public interface TicketDao {
    Ticket findTicketById(int id) throws DaoException;
    List<Ticket> findTicketsBySeanceId(int seanceId) throws DaoException;


    boolean addNewTicket(Seance seance) throws DaoException;
    boolean removeTicketById(int id) throws DaoException;
    boolean updateTicket(int id, Ticket newTicket) throws DaoException;
}
