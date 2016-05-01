package dao;

import entity.hall.Hall;
import entity.user.UserType;

import java.util.List;

/**
 * Created by Alexander on 01.05.2016.
 */
public interface HallDao {
    Hall findHallById(int id) throws DaoException;
    List<Hall> getHallsCollection() throws DaoException;

    //int findIdByHallValue(UserType userType) throws DaoException;

}
