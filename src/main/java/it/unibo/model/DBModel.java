package it.unibo.model;

import java.sql.Connection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import it.unibo.controller.Controller;
import it.unibo.data.Articolo;
import it.unibo.data.BollaAcquisto;
import it.unibo.data.BollaVendita;
import it.unibo.data.Ordine;
import it.unibo.data.Dipendente;
import it.unibo.data.DistintaBase;
import it.unibo.data.DistintaBasePassaggi;
import it.unibo.data.Gruppo;
import it.unibo.data.Magazzino;
import it.unibo.data.Prodotto;
import it.unibo.data.SchedaDiLavorazione;
import it.unibo.data.StatoDiLavorazione;
import it.unibo.data.UtenteMercato;

public class DBModel {
    private final Connection connection;
    private final Controller controller;

    public DBModel(final Connection connection, final Controller controller) {
        Objects.requireNonNull(connection, "Model created with null connection");
        this.connection = connection;
        this.controller = controller;
    }

    //PRODUZIONE
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

    //COMPRA E VENDITA
    public List<BollaAcquisto> loadBolleAcquisti() {
        return BollaAcquisto.DAO.findAll(connection);
    }

    public List<UtenteMercato> loadUtentiMercato() {
        return UtenteMercato.DAO.findAll(connection);
    }

    public List<Ordine> loadOrdini() {
        return Ordine.DAO.findAll(connection);
    }

    public List<BollaVendita> loadBolleVendite() {
        return BollaVendita.DAO.findAll(connection);
    }

    public void insertBollaAcquisto(BollaAcquisto a) {
        BollaAcquisto.DAO.insertBolla(connection, a);
    }

    //DISTINTA BASE

    public List<DistintaBase> loadDistinte() {
        return DistintaBase.DAO.findAll(connection);
    }

    //DISTINTA BASE PASSAGGI

    public List<DistintaBasePassaggi> loadDistintePassaggi() {
        return DistintaBasePassaggi.DAO.findAll(connection);
    }

    //DIPENDENTI

    public List<Dipendente> loadDipendenti() {
        return Dipendente.DAO.findAll(connection);
    }

    //MAGAZZINI

    public List<Magazzino> loadMagazzini() {
        return Magazzino.DAO.findAll(connection);
    }

    public List<String> loadNomiStatiDiLavorazione() {
        return StatoDiLavorazione.DAO.findAllNomeStato(connection);    
    }

    public List<Gruppo> loadGruppi() {
        return Gruppo.DAO.findAll(connection);
    }

    public boolean insertProdotto(Prodotto prodotto) {
        return Prodotto.DAO.insert(connection, prodotto);
    }

    //OPERAZIONI

    public List<Integer> tempoPerArticolo(int id_articolo) {
        return Articolo.DAO.tempoPerArticolo(connection, id_articolo);
    }
}
