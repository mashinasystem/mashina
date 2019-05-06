package com.epam.machine.repository;

import com.epam.machine.entity.Admin;

import java.sql.SQLException;

public interface AdminRepository {

    Admin get(int id);

    void create(Admin admin);

    void delete(int id) throws ClassNotFoundException;

    void update(int id, Admin admin) throws ClassNotFoundException, SQLException;

    int getByLogin(String login) throws ClassNotFoundException, SQLException;
}
