package it.unibo.data;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ordine {
    public int id_ordine;
    public Date data;
    public String p_iva;

    public Ordine(int id_ordine, Date data, String p_iva) {
        this.id_ordine = id_ordine;
        this.data = data;
        this.p_iva = p_iva;
    }

    @Override
    public String toString() {
        return Printer.stringify("Ordine",
            List.of(
                Printer.field("id_ordine", id_ordine),
                Printer.field("data", data),
                Printer.field("p_iva", p_iva)
            )
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ordine ordine = (Ordine) o;
        return id_ordine == ordine.id_ordine &&
               Objects.equals(data, ordine.data) &&
               Objects.equals(p_iva, ordine.p_iva);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_ordine, data, p_iva);
    }

    public static final class DAO {
        public static List<Ordine> findAll(Connection connection) {
            try (var stmt = DAOUtils.prepare(connection, Queries.LOAD_ORDINI); 
                var rs   = stmt.executeQuery()) {
                var list = new ArrayList<Ordine>();
                while(rs.next()) {
                    Ordine ba = new Ordine(
                        rs.getInt("id_ordine"),
                        rs.getDate("data"),
                        rs.getString("p_iva")
                    );
                    list.add(ba);
                }
                return list;
            } catch (Exception e) {
                throw new DAOException("Errore durante il LOAD dei prodotti" + e.getMessage(), e);
            }
        }

        public static List<Integer> evadereOrdine(Connection connection, int id_ordine) {
            try (var stmt = DAOUtils.prepare(connection, Queries.EVADERE_ORDINE, id_ordine); 
                var rs   = stmt.executeQuery()) {
                var list = new ArrayList<Integer>();
                while(rs.next()) {
                    list.add(rs.getInt("IDProdotto"));
                    list.add(rs.getInt("QuantitàRichiesta"));
                    list.add(rs.getInt("QuantitàDisponibile"));
                }
                return list;
            } catch (Exception e) {
                throw new DAOException("Errore durante il LOAD dei prodotti" + e.getMessage(), e);
            }
        }

        // public static List<BollaAcquisto> findAllJoinedVenditori(Connection connection) {
        //     try (var stmt = DAOUtils.prepare(connection, Queries.LOAD_BOLLE_ACQUISTO_JOINED_VENDITORI); 
        //         var rs   = stmt.executeQuery()) {
        //         var list = new ArrayList<BollaAcquisto>();
        //         while(rs.next()) {
        //             BollaAcquisto ba = new BollaAcquisto(
        //                 rs.getInt("id_bolla_acquisto"),
        //                 rs.getDate("data"),
        //                 rs.getString("p_iva")
        //             );
        //             list.add(ba);
        //         }
        //         return list;
        //     } catch (Exception e) {
        //         throw new DAOException("Errore durante il LOAD dei prodotti" + e.getMessage(), e);
        //     }
        // }
    }
}