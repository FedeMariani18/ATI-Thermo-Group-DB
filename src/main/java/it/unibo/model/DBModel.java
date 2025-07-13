package it.unibo.model;

import java.sql.Connection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import it.unibo.controller.Controller;
import it.unibo.data.Articolo;
import it.unibo.data.DistintaBase;
import it.unibo.data.DistintaBasePassaggi;
import it.unibo.data.Prodotto;
import it.unibo.data.SchedaDiLavorazione;

public class DBModel {
    private final Connection connection;
    private final Controller controller;

    public DBModel(final Connection connection, final Controller controller) {
        Objects.requireNonNull(connection, "Model created with null connection");
        this.connection = connection;
        this.controller = controller;
    }

    //PRODOTTI
    public List<Prodotto> loadProdotti() {
        return Prodotto.DAO.findAll(connection);
    }

    public Optional<Prodotto> findProdotto(int idProdotto) {
        return Prodotto.DAO.find(connection, idProdotto);
    }

    public List<Articolo> loadArticoli() {
        return Articolo.DAO.findAll(connection);
    }

    public List<Articolo> loadArticoliByProducts(int idProdotto) {
        return Articolo.DAO.findByProduct(connection, idProdotto);
    }

    //SCHEDE DI LAVORAZIONE

    public List<SchedaDiLavorazione> loadSchede() {
        return SchedaDiLavorazione.DAO.findAll(connection);
    }

    //DISTINTA BASE

    public List<DistintaBase> loadDistinte() {
        return DistintaBase.DAO.findAll(connection);
    }

    //DISTINTA BASE PASSAGGI

    public List<DistintaBasePassaggi> loadDistintePassaggi() {
        return DistintaBasePassaggi.DAO.findAll(connection);
    }
}
