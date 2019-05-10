package com.epam.machine.service;

import com.epam.machine.entity.Offer;
import com.epam.machine.repository.ClientRepositoryImpl;
import com.epam.machine.repository.OfferRepositroryImpl;

import java.sql.SQLException;
import java.util.List;

public class OfferServiceImpl implements OfferService{

    private ClientRepositoryImpl clientRepository = new ClientRepositoryImpl();
    private OfferRepositroryImpl offerRepositrory = new OfferRepositroryImpl();

    @Override
    public List<Offer> get(String login) throws SQLException, ClassNotFoundException {
        int id = clientRepository.getIdByLogin(login);
        return offerRepositrory.get(id);
    }

    @Override
    public void create(Offer offer) {
        try {
            offerRepositrory.create(offer);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {}

    @Override
    public void update(int id) {}
}
