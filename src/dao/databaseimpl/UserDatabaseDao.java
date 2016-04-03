package dao.databaseimpl;

import dao.DaoException;
import entity.user.User;
import dao.UserDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander on 23.02.2016.
 */
public class UserDatabaseDao extends Connector implements UserDao {

    private static UserDatabaseDao instance = new UserDatabaseDao();

    private UserDatabaseDao() {
        super();
    }

    public static UserDatabaseDao getInstance(){
        return instance;
    }

    @Override
    public User findUserById(int id) throws DaoException {
        return null;
    }

    @Override
    public List<User> getUsersCollection() throws DaoException {

        if (connection == null || statement == null) {
            throw new DaoException("Database connection error");
        }

        List<User> users = new ArrayList<User>();

        ResultSet resultSet = null;

        try {
            resultSet = statement.executeQuery("SELECT * FROM 'user'");

            while (resultSet.next()) {
                users.add(new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5)));
            }

            return users;
        }
        catch (SQLException e){
            throw new DaoException(e);
        }
        finally {
            try {
                closeResultSet(resultSet);
            } catch (SQLException e){
                throw new DaoException(e);
            }
        }

    }
}
