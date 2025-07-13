package it.unibo.data;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DistintaBase {
    public int id_prodotto1;
    public int id_prodotto;
    public Integer quantita; // può essere null

    public DistintaBase(int id_prodotto1, int id_prodotto, Integer quantita) {
        this.id_prodotto1 = id_prodotto1;
        this.id_prodotto = id_prodotto;
        this.quantita = quantita;
    }

    @Override
    public String toString() {
        return Printer.stringify("DistintaBase",
            List.of(
                Printer.field("id", id_prodotto1),
                Printer.field("id_prodotto", id_prodotto),
                Printer.field("quantita", quantita)
            )
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DistintaBase that = (DistintaBase) o;
        return id_prodotto1 == that.id_prodotto1 &&
                id_prodotto == that.id_prodotto &&
                Objects.equals(quantita, that.quantita);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_prodotto1, id_prodotto, quantita);
    }

    public static final class DAO {
        public static List<DistintaBase> findAll(Connection connection) {
            try (var stmt = DAOUtils.prepare(connection, Queries.LOAD_DISTINTA); 
                var rs   = stmt.executeQuery()) {
                var list = new ArrayList<DistintaBase>();
                while(rs.next()) {
                    DistintaBase p = new DistintaBase(
                        rs.getInt("id_prodotto_finale"),
                        rs.getInt("id_prodotto"),
                        rs.getInt("quantita")
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