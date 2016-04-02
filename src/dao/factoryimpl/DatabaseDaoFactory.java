package dao.factoryimpl;

import dao.*;
import dao.databaseimpl.FilmDatabaseDao;
import dao.databaseimpl.UserDatabaseDao;

/**
 * Created by Alexander on 16.02.2016.
 */
public class DatabaseDaoFactory extends DaoFactory {
    private final static DatabaseDaoFactory instance = new DatabaseDaoFactory();

    private DatabaseDaoFactory() {
    }

    public final static DatabaseDaoFactory getInstance() {
        return instance;
    }

    @Override
    public UserDao getUserDao() {
        return UserDatabaseDao.getInstance();
    }

    @Override
    public FilmDao getFilmDao() {
        return FilmDatabaseDao.getInstance();
    }

}
