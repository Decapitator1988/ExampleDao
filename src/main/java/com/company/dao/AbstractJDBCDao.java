package com.company.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractJDBCDao<T, PK extends Serializable> implements GenericDao  {
    private Connection connection;

    public abstract String getSelectQuery();
    protected abstract List<T> parseResultSet(ResultSet rs);

    @Override
    public Object getByPK(int key) throws SQLException {
        List<T> list;
        String sql = getSelectQuery();
        sql+=" WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, key);
            ResultSet rs = preparedStatement.executeQuery();
            list = parseResultSet(rs);
        }catch (Exception e ){
            throw new PersistExcpection
        }

        return null;
    }

    @Override
    public List getAll() throws SQLException {
        return null;
    }
}
