package it.unibo.data;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Prodotto {
    public int id_prodotto;
    public BigDecimal prezzo_listino;
    public String descrizione;
    public BigDecimal peso;
    public BigDecimal superficie;
    public BigDecimal prezzo_inventario;
    public String codice_a_barre;
    public String nome_stato;
    public Integer id_gruppo;

    public Prodotto(
        int id_prodotto,
        BigDecimal prezzo_listino,
        String descrizione,
        BigDecimal peso,
        BigDecimal superficie,
        BigDecimal prezzo_inventario,
        String codice_a_barre,
        String nome_stato,
        Integer id_gruppo
    ) {
        this.id_prodotto = id_prodotto;
        this.prezzo_listino = prezzo_listino;
        this.descrizione = descrizione;
        this.peso = peso;
        this.superficie = superficie;
        this.prezzo_inventario = prezzo_inventario;
        this.codice_a_barre = codice_a_barre;
        this.nome_stato = nome_stato;
        this.id_gruppo = id_gruppo;
    }

    @Override
    public String toString() {
        return Printer.stringify("Prodotto",
            List.of(
                Printer.field("id_prodotto", id_prodotto),
                Printer.field("prezzo_listino", prezzo_listino),
                Printer.field("descrizione", descrizione),
                Printer.field("peso", peso),
                Printer.field("superficie", superficie),
                Printer.field("prezzo_inventario", prezzo_inventario),
                Printer.field("codice_a_barre", codice_a_barre),
                Printer.field("nome_stato", nome_stato),
                Printer.field("id_gruppo", id_gruppo)
            )
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prodotto prodotto = (Prodotto) o;
        return id_prodotto == prodotto.id_prodotto &&
               Objects.equals(prezzo_listino, prodotto.prezzo_listino) &&
               Objects.equals(descrizione, prodotto.descrizione) &&
               Objects.equals(peso, prodotto.peso) &&
               Objects.equals(superficie, prodotto.superficie) &&
               Objects.equals(prezzo_inventario, prodotto.prezzo_inventario) &&
               Objects.equals(codice_a_barre, prodotto.codice_a_barre) &&
               Objects.equals(nome_stato, prodotto.nome_stato) &&
               Objects.equals(id_gruppo, prodotto.id_gruppo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id_prodotto, prezzo_listino, descrizione, peso, superficie,
            prezzo_inventario, codice_a_barre, nome_stato, id_gruppo
        );
    }

    public static final class DAO {
        public static Optional<Prodotto> find(Connection connection, int id_prodotto) {
            try (var stmt = DAOUtils.prepare(connection, Queries.FIND_PRODOTTO, id_prodotto); 
                var rs   = stmt.executeQuery()) {
                if (rs.next()) {
                    Prodotto p = new Prodotto(
                        rs.getInt("id_prodotto"),
                        rs.getBigDecimal("prezzo_listino"),
                        rs.getString("descrizione"),
                        rs.getBigDecimal("peso"),
                        rs.getBigDecimal("superficie"),
                        rs.getBigDecimal("prezzo_inventario"),
                        rs.getString("codice_a_barre"),
                        rs.getString("nome_stato"),
                        rs.getInt("id_gruppo")
                    );
                    return Optional.of(p);
                }
                return Optional.empty();
            } catch (Exception e) {
                throw new DAOException("Errore durante il LOAD dei prodotti", e);
            }
        }

        public static List<Prodotto> findAll(Connection connection) {
            try (var stmt = DAOUtils.prepare(connection, Queries.LOAD_PRODOTTI); 
                var rs   = stmt.executeQuery()) {
                var list = new ArrayList<Prodotto>();
                while(rs.next()) {
                    Prodotto p = new Prodotto(
                        rs.getInt("id_prodotto"),
                        rs.getBigDecimal("prezzo_listino"),
                        rs.getString("descrizione"),
                        rs.getBigDecimal("peso"),
                        rs.getBigDecimal("superficie"),
                        rs.getBigDecimal("prezzo_inventario"),
                        rs.getString("codice_a_barre"),
                        rs.getString("nome_stato"),
                        rs.getInt("id_gruppo")
                    );
                    list.add(p);
                }
                return list;
            } catch (Exception e) {
                throw new DAOException("Errore durante il LOAD dei prodotti" + e.getMessage(), e);
            }
            
        } 
    } 
}