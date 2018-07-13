package com.company.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface DaoFactory {
    public Connection getConnction() throws SQLException;
    public GroupDao getGroupDao(Connection connection);
    public StudentDao getStudentDao(Connection connection);
}
