package com.epam.machine.repository;

import com.epam.machine.entity.Offer;

import java.sql.SQLException;
import java.util.List;

public interface OfferRepository {
    List<Offer> get(int id) throws ClassNotFoundException, SQLException;

    void create(Offer offer) throws ClassNotFoundException, SQLException;

    void delete(int id);

    void update(int id, String status) throws ClassNotFoundException, SQLException;

    List<Offer> getAll() throws SQLException, ClassNotFoundException;

    List<Offer> getPast(int id) throws SQLException, ClassNotFoundException;

    List<Offer> getPresent(int id) throws ClassNotFoundException, SQLException;

    Offer getOffer(int id) throws ClassNotFoundException, SQLException;

    List<Offer> getAllPast() throws SQLException, ClassNotFoundException;

    List<Offer> getAllPresent() throws ClassNotFoundException, SQLException;
}
