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
    public void update(int id, String status) throws SQLException, ClassNotFoundException {
        offerRepositrory.update(id, status);
    }

    @Override
    public List<Offer> getAll() throws SQLException, ClassNotFoundException {
        return offerRepositrory.getAll();
    }

    public List<Offer> getPast(String login) throws SQLException, ClassNotFoundException {
        int id = clientRepository.getIdByLogin(login);
        return offerRepositrory.getPast(id);
    }

    public List<Offer> getPresent(String login) throws SQLException, ClassNotFoundException {
        int id = clientRepository.getIdByLogin(login);
        return offerRepositrory.getPresent(id);
    }

    public List<Offer> get(int id) throws SQLException, ClassNotFoundException {
        return offerRepositrory.get(id);
    }

    public Offer getOffer(int id) throws SQLException, ClassNotFoundException {
        return offerRepositrory.getOffer(id);
    }

    public List<Offer> getAllPast() throws SQLException, ClassNotFoundException {
        return offerRepositrory.getAllPast();
    }

    public List<Offer> getAllPresent() throws SQLException, ClassNotFoundException {
        return offerRepositrory.getAllPresent();
    }
}
