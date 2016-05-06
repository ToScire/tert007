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
    List<Ticket> findTicketsByUserId(int userId) throws DaoException;
    
    boolean addNewTicket(Ticket ticket) throws DaoException;
    boolean removeTicketById(int id) throws DaoException;
    boolean updateTicket(Ticket newTicket) throws DaoException;
}
