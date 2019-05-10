package com.epam.machine.repository;

import com.epam.machine.entity.Admin;

import java.sql.SQLException;

public interface AdminRepository {

    Admin get(int id) throws ClassNotFoundException, SQLException;

    void create(Admin admin) throws SQLException, ClassNotFoundException;

    void delete(int id) throws ClassNotFoundException, SQLException;

    void update(int id, Admin admin) throws ClassNotFoundException, SQLException;

    int getByLogin(String login) throws ClassNotFoundException, SQLException;

    boolean checkLogin(String login,String password) throws ClassNotFoundException, SQLException;
}
