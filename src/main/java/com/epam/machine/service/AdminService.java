package com.epam.machine.service;

import com.epam.machine.entity.Admin;
import com.epam.machine.entity.Client;

import java.sql.SQLException;

public interface AdminService {

    void create(Admin admin);

    void delete(int id);

    void update(Admin admin) throws SQLException, ClassNotFoundException;

    Admin get(String login) throws SQLException, ClassNotFoundException;
}
