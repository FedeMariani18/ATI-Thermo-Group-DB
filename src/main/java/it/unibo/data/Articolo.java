package it.unibo.data;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public final class Articolo {

    public final int id_prodotto;
    public final int id_seriale;
    public final Integer id_magazzino;
    public final Integer numero_scansia;
    public final Integer colonna;
    public final Integer piano;
    public final Integer id_bolla_vendita;
    public final Integer id_bolla_acquisto;

    public Articolo(
        int id_prodotto,
        int id_seriale,
        Integer id_magazzino,
        Integer numero_scansia,
        Integer colonna,
        Integer piano,
        Integer id_bolla_vendita,
        Integer id_bolla_acquisto
    ) {
        this.id_prodotto = id_prodotto;
        this.id_seriale = id_seriale;
        this.id_magazzino = id_magazzino;
        this.numero_scansia = numero_scansia;
        this.colonna = colonna;
        this.piano = piano;
        this.id_bolla_vendita = id_bolla_vendita;
        this.id_bolla_acquisto = id_bolla_acquisto;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Articolo that = (Articolo) other;
        return id_prodotto == that.id_prodotto &&
               id_seriale == that.id_seriale &&
               Objects.equals(id_magazzino, that.id_magazzino) &&
               Objects.equals(numero_scansia, that.numero_scansia) &&
               Objects.equals(colonna, that.colonna) &&
               Objects.equals(piano, that.piano) &&
               Objects.equals(id_bolla_vendita, that.id_bolla_vendita) &&
               Objects.equals(id_bolla_acquisto, that.id_bolla_acquisto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_prodotto, id_seriale, id_magazzino, numero_scansia, colonna, piano, id_bolla_vendita, id_bolla_acquisto);
    }

    @Override
    public String toString() {
        return Printer.stringify("Articolo",
            List.of(
                Printer.field("id", id_prodotto),
                Printer.field("seriale", id_seriale),
                Printer.field("magazzino", id_magazzino),
                Printer.field("scansia", numero_scansia),
                Printer.field("colonna", colonna),
                Printer.field("piano", piano),
                Printer.field("bolla_vendita", id_bolla_vendita),
                Printer.field("bolla_acquisto", id_bolla_acquisto)
            )
        );
    }


    public static final class DAO {
        public static Optional<Articolo> find(Connection connection, int id_articolo) {
            try (var stmt = DAOUtils.prepare(connection, Queries.FIND_ARTICOLO, id_articolo); 
                var rs   = stmt.executeQuery()) {
                if (rs.next()) {
                    Articolo a = new Articolo(
                        rs.getInt("id_prodotto"),
                        rs.getInt("id_seriale"),
                        rs.getInt("id_magazzino"),
                        rs.getInt("numero_scansia"),
                        rs.getInt("colonna"),
                        rs.getInt("piano"),
                        rs.getInt("id_bolla_vendita"),
                        rs.getInt("id_bolla_acquisto")
                    );
                    return Optional.of(a);
                }
                return Optional.empty();
            } catch (Exception e) {
                throw new DAOException("Errore durante il LOAD dei prodotti", e);
            }
        }

        public static List<Articolo> findAll(Connection connection) {
            try (var stmt = DAOUtils.prepare(connection, Queries.LOAD_ARTICOLI); 
                var rs   = stmt.executeQuery()) {
                var list = new ArrayList<Articolo>();
                while(rs.next()) {
                    Articolo a = new Articolo(
                        rs.getInt("id_prodotto"),
                        rs.getInt("id_seriale"),
                        rs.getInt("id_magazzino"),
                        rs.getInt("numero_scansia"),
                        rs.getInt("colonna"),
                        rs.getInt("piano"),
                        rs.getInt("id_bolla_vendita"),
                        rs.getInt("id_bolla_acquisto")
                    );
                    list.add(a);
                }
                return list;
            } catch (Exception e) {
                throw new DAOException("Errore durante il LOAD dei prodotti" + e.getMessage(), e);
            }
        }

        public static List<Articolo> findByProduct(Connection connection, int id_prodotto) {
            try (var stmt = DAOUtils.prepare(connection, Queries.FIND_ARTICOLO_BY_PRODUCT, id_prodotto); 
                var rs   = stmt.executeQuery()) {
                var list = new ArrayList<Articolo>();
                while(rs.next()) {
                    Articolo a = new Articolo(
                        rs.getInt("id_prodotto"),
                        rs.getInt("id_seriale"),
                        rs.getInt("id_magazzino"),
                        rs.getInt("numero_scansia"),
                        rs.getInt("colonna"),
                        rs.getInt("piano"),
                        rs.getInt("id_bolla_vendita"),
                        rs.getInt("id_bolla_acquisto")
                    );
                    list.add(a);
                }
                return list;
            } catch (Exception e) {
                throw new DAOException("Errore durante il LOAD dei prodotti" + e.getMessage(), e);
            }
        }

        public static List<Integer> tempoPerArticolo(Connection connection, int id_articolo) {
            try (var stmt = DAOUtils.prepare(connection, Queries.FIND_ARTICOLO_BY_PRODUCT, id_articolo); 
                var rs   = stmt.executeQuery()) {
                var list = new ArrayList<Integer>();
                while(rs.next()) {
                    list.add(rs.getInt("TempoEffettivo"));
                    list.add(rs.getInt("TempoStimato"));
                }
                return list;
            } catch (Exception e) {
                throw new DAOException("Errore durante il LOAD dei prodotti" + e.getMessage(), e);
            }
        }
    } 
}
