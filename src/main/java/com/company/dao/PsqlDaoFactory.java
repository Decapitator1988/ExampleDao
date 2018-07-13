package com.company.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PsqlDaoFactory implements DaoFactory {
    private String user = "postgres";
    private String password = "1";
    private String url = "jdbc:postgresql://localhost:5432/dao_layer";
    private String driver = "org.postgresql.Driver";

    public PsqlDaoFactory() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnction() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public GroupDao getGroupDao(Connection connection) {
        return new PsqlGroupDao(connection);
    }

    public StudentDao getStudentDao(Connection connection) {
        return null;
    }
}
