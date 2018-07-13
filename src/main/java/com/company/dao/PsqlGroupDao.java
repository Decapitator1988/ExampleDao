package com.company.dao;

import com.company.Group;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PsqlGroupDao implements GroupDao {

    public PsqlGroupDao(Connection connection) {
        this.connection = connection;
    }

    private final Connection connection;

    public Group create() {
        return null;
    }

    public Group read(int key) throws SQLException {

        String sql = "SELECT * FROM groups WHERE ID =?;";

        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setInt(1, key);

        ResultSet resultSet = pstm.executeQuery();
        resultSet.next();
        Group g = new Group();
        g.setId(resultSet.getInt("id"));
        g.setNumber(resultSet.getInt("number"));
        g.setDepartment(resultSet.getString("departmnent"));
        return  g;
    }

    public void update(Group group) {

    }

    public void delete(Group group) {

    }

    public List<Group> getAll() throws SQLException {
        String sql = "SELECT * FROM groups;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();

        List <Group> list = new ArrayList<Group>();
        while (rs.next()){
            Group g = new Group();
            g.setId(rs.getInt("id"));
            g.setNumber(rs.getInt("number"));
            g.setDepartment(rs.getString("departmnent"));
            list.add(g);
        }

        return list;

    }
}
