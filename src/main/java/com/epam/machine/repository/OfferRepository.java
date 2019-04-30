package com.epam.machine.repository;

import com.epam.machine.entity.Offer;

import java.sql.SQLException;
import java.util.List;

public interface OfferRepository {
    List<Offer> get(int id) throws ClassNotFoundException, SQLException;

    void create(Offer offer);

    void delete(int id);

    void update(int id);
}
