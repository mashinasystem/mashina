package com.epam.machine.service;

import com.epam.machine.entity.Admin;
import com.epam.machine.repository.AdminRepository;
import com.epam.machine.repository.AdminRepositoryImpl;
import lombok.NoArgsConstructor;

import java.sql.SQLException;

@NoArgsConstructor
public class AdminServiceImpl implements AdminService {

    private AdminRepository adminRepository = new AdminRepositoryImpl();

    @Override
    public void create(Admin admin) throws SQLException, ClassNotFoundException {
        if (admin != null) {
            adminRepository.create(admin);
        } else {
            throw new NullPointerException();
        }

    }

    @Override
    public void delete(int id) throws ClassNotFoundException, SQLException {
        adminRepository.delete(id);
    }

    @Override
    public void update(Admin admin) throws SQLException, ClassNotFoundException {
        if (admin != null) {
            int id = adminRepository.getByLogin(admin.getLogin());
            adminRepository.update(id, admin);
        } else {
            throw new NullPointerException();
        }

    }

    @Override
    public Admin get(String login) throws SQLException, ClassNotFoundException {
        int id = adminRepository.getByLogin(login);
        return adminRepository.get(id);
    }

    @Override
    public boolean adminLoginCheck(String login, String password) throws SQLException, ClassNotFoundException {
        return adminRepository.checkLogin(login, password);
    }
}
