package dao.databaseimpl;


import com.mysql.fabric.jdbc.FabricMySQLDriver;
import dao.DaoException;

import java.sql.*;

/**
 * Created by Alexander on 20.02.2016.
 */
public class Connector {
    private static final String className = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/cinema";
    private static final String login = "root";
    private static final String password = "root";
    protected static Connection connection = null;
    protected static Statement statement = null;
    protected DataBaseController dbController;

    public static Connection getConnection() throws DaoException {
        try {
            Class.forName(className);
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            return  DriverManager.getConnection(url, login, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new DaoException(e);
        }
    }

    protected Connector() {
        try {
            if (connection == null){
                Class.forName("com.mysql.jdbc.Driver");

                Driver driver = new FabricMySQLDriver();
                DriverManager.registerDriver(driver);

                connection = DriverManager.getConnection(url, login, password);
                statement = connection.createStatement();
                dbController = new DataBaseController(statement);
            }
        }
        catch (ClassNotFoundException | SQLException e) {
            connection = null;
            statement = null;
        }
    }

    protected void closeConnection() throws SQLException {
         if (connection != null) {
            connection.close();
            connection = null;
        }
    }

    protected void closeStatement(Statement statement) throws SQLException {
            if (statement != null) {
                statement.close();
            }
    }

    protected void closeResultSet(ResultSet resultSet) throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
    }


}
