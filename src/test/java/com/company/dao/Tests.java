package com.company.dao;

import com.company.Group;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Tests {

    @Test
    public void testAll() throws Exception
    {
        DaoFactory daoFactory = new PsqlDaoFactory();
        List<Group> list;
        try (Connection conn = daoFactory.getConnction()){
            GroupDao groupDao = daoFactory.getGroupDao(conn);
            list = groupDao.getAll();
        }
        Assert.assertNotNull(list);
        Assert.assertTrue(list.size()>0);
    }

}
