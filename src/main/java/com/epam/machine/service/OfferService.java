package com.epam.machine.service;

import com.epam.machine.entity.Offer;

import java.sql.SQLException;
import java.util.List;

public interface OfferService {
    List<Offer> get(String login) throws ClassNotFoundException, SQLException;

    void create(Offer offer);

    void delete(int id);

    void update(int id, String status) throws SQLException, ClassNotFoundException;

    List<Offer> getAll() throws SQLException, ClassNotFoundException;

    List<Offer> get(int id) throws SQLException, ClassNotFoundException;

    Offer getOffer(int id) throws SQLException, ClassNotFoundException;

    List<Offer> getAllPast() throws SQLException, ClassNotFoundException;

    List<Offer> getAllPresent() throws SQLException, ClassNotFoundException;
}
