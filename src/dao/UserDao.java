package dao;

import entity.user.User;

import java.util.List;

/**
 * Created by Alexander on 23.02.2016.
 */
public interface UserDao{
    User findUserById(int id) throws DaoException;
    User findUser(String login) throws DaoException;
    List<User> getUsersCollection() throws DaoException;

    boolean addUser(User user) throws DaoException;
    boolean removeUser(int id) throws DaoException;
    boolean updateUser(User newUser) throws DaoException;
}
