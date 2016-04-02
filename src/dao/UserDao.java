package dao;

import entity.user.User;

import java.util.List;

/**
 * Created by Alexander on 23.02.2016.
 */
public interface UserDao {
    User findUserById(int id) throws DaoException;
    List<User> getUsersCollection() throws DaoException;
}
