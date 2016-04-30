package dao.databaseimpl;

import dao.DaoException;
import dao.TicketDao;
import entity.seance.Seance;
import entity.ticket.Ticket;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Vadim on 04.04.2016.
 */
public class TicketDatabaseDao extends Connector implements TicketDao {

    private static final String tableName = "ticket";

    private static final String columnId = "id";
    private static final String columnSeanceId = "id_seance";
    private static final String columnPlace = "place";

    private static final String[] columnsName = {
            columnId,
            columnSeanceId,
            columnPlace
    };

    private TicketDatabaseDao(){
        super();
    }

    private static final TicketDatabaseDao instance = new TicketDatabaseDao();


    public static TicketDatabaseDao getInstance() {
        return instance;
    }

    @Override
    public Ticket findTicketById(int id) throws DaoException {
        ResultSet resultSet = null;
        try {
            resultSet = databaseController.select(tableName, columnsName, null);

            return createTicketFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }

    @Override
    public List<Ticket> findTicketsBySeanceId(int seanceId) throws DaoException {
        return null;
    }

    @Override
    public boolean addNewTicket(Seance seance) throws DaoException {
        return false;
    }

    @Override
    public boolean removeTicketById(int id) throws DaoException {
        return false;
    }

    @Override
    public boolean updateTicket(int id, Ticket newTicket) throws DaoException {
        return false;
    }

    private List<Ticket> createTicketsCollectionFromResultSet(ResultSet resultSet) throws DaoException{
        return null;
    }

    private Ticket createTicketFromResultSet(ResultSet resultSet) throws  DaoException {
        Ticket ticket = new Ticket();
        try {
            ticket.setId(resultSet.getInt(columnId));
            ticket.setPlace(resultSet.getInt(columnPlace));

            //
            return ticket;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }


}
