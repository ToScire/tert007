package dao.databaseimpl;

import dao.DaoException;
import entity.user.User;
import dao.UserDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander on 23.02.2016.
 */
public class UserDatabaseDao extends Connector implements UserDao {
    public static final String tableName = "user";
    public static final String columnId = "id";
    public static final String columnType = "user_type_id";
    public static final String columnLogin = "login";
    public static final String columnPassword = "password";
    public static final String columnEmail = "email";
    public static final String columnBonus = "bonus_count";

    public static String[] getColumnNames(){
        String[] result = new String[6];
        result[0] = UserDatabaseDao.columnId;
        result[1] = UserDatabaseDao.columnType;
        result[2] = UserDatabaseDao.columnLogin;
        result[3] = UserDatabaseDao.columnPassword;
        result[4] = UserDatabaseDao.columnEmail;
        result[5] = UserDatabaseDao.columnBonus;
        return  result;
    }

    private static UserDatabaseDao instance = new UserDatabaseDao();

    private UserDatabaseDao() {
        super();
    }

    public static UserDatabaseDao getInstance(){
        return instance;
    }


    @Override
    public User findUserById(int id) throws DaoException {
        ResultSet resultSet = null;
        try {

            resultSet = databaseController.select(UserDatabaseDao.tableName, UserDatabaseDao.getColumnNames(), UserDatabaseDao.columnId + "=" + id);
            if(resultSet.next()) {
                return setToUser(resultSet);
            }
            else return null;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<User> getUsersCollection() throws DaoException {
        ResultSet resultSet = null;
        try {
            resultSet = databaseController.select(UserDatabaseDao.tableName,UserDatabaseDao.getColumnNames(),null);
            return usersToCollection(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean addUser(User user) throws DaoException {
        try {
            return databaseController.insert(UserDatabaseDao.tableName,UserDatabaseDao.getColumnNames(),user.getValues());
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean updateUser(int id, User newUser) throws DaoException {
        try {
            return databaseController.update(UserDatabaseDao.tableName,UserDatabaseDao.getColumnNames(),newUser.getValues(),UserDatabaseDao.columnId +
            "=" + id);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }


    @Override
    public boolean removeUser(int id) throws DaoException {
        try {
            return databaseController.remove(UserDatabaseDao.tableName,UserDatabaseDao.columnId + "=" + id);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }


    private List<User> usersToCollection(ResultSet userSet) throws  DaoException{
        List<User> result = new ArrayList<User>();
        try {
            while (userSet.next()) {
                result.add(this.setToUser(userSet));
            }
            return result;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private User setToUser(ResultSet user) throws  DaoException{
        User result = new User();
        try {
            result.setId(user.getInt(UserDatabaseDao.columnId));
            result.setUserType(user.getInt(UserDatabaseDao.columnType));
            result.setLogin(user.getString(UserDatabaseDao.columnLogin));
            result.setPassword(user.getString(UserDatabaseDao.columnPassword));
            result.setEmail(user.getString(UserDatabaseDao.columnEmail));
            result.setBonusCount(user.getInt(UserDatabaseDao.columnBonus));
            return result;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
