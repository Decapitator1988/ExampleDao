package com.company.dao;

import com.company.Group;

import java.sql.SQLException;
import java.util.List;

public interface GroupDao {
    public Group create();
    public Group read(int id) throws SQLException;
    public void update(Group group);
    public void delete(Group group);
    public List<Group> getAll() throws SQLException;
}
