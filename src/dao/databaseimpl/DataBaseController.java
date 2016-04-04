package dao.databaseimpl;

import dao.DaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Vadim on 04.04.2016.
 */
public class DataBaseController {
    private Statement statement;
    private String tableName;

    public DataBaseController(Statement statement,String tableName){
        this.statement = statement;
        this.tableName = tableName;
    }

    public ResultSet select(String[] columns,String where) throws DaoException{
        String query = "SELECT ";
        for (int i=0; i < columns.length - 1; i++){
            query += columns[i] + ",";
        }
        query += columns[columns.length - 1];
        if(where != null){
            query += " WHERE " + where;
        }
        try {
            return statement.executeQuery(query);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public  boolean insert(String[] columns, String[] values)throws DaoException{
        String query = "INSERT INTO " + tableName + " (";
        for (int i = 0; i < columns.length - 1; i++){
            query += columns[i] + ",";
        }
        query += columns[columns.length - 1] + ") VALUES (";
        for (int i = 0; i < values.length - 1; i++) {
            query += "'" + values[i] + "',";
        }
        query += "'" +  values[values.length - 1] + "'";
        try {
            return statement.execute(query);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }


    public  boolean update(String[] columns, String[] newValues, String where)throws DaoException{
        String query = "UPDATE " + tableName + " SET ";
        for (int i = 0; i < columns.length - 1; i++){
            query += columns[i] + "='" + newValues[i] + "',";
        }
        query += columns[columns.length - 1] + "='" + newValues[columns.length - 1] + "'";
        query += " WHERE " + where;
        try {
            return statement.execute(query);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public  boolean remove(String where)throws DaoException{
        String query = "DELETE FROM " + tableName;
        query += " WHERE " + where;
        try {
            return statement.execute(query);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
