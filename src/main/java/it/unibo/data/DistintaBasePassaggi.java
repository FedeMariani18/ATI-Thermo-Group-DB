package it.unibo.data;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DistintaBasePassaggi {
    public String nome_passaggio;
    public int id_prodotto;
    public Integer stima_durata; // può essere null

    public DistintaBasePassaggi(String nome_passaggio, int id_prodotto, Integer stima_durata) {
        this.nome_passaggio = nome_passaggio;
        this.id_prodotto = id_prodotto;
        this.stima_durata = stima_durata;
    }

    @Override
    public String toString() {
        return Printer.stringify("DistintaBasePassaggi",
            List.of(
                Printer.field("nome_passaggio", nome_passaggio),
                Printer.field("id_prodotto", id_prodotto),
                Printer.field("stima_durata", stima_durata)
            )
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DistintaBasePassaggi that = (DistintaBasePassaggi) o;
        return id_prodotto == that.id_prodotto &&
                Objects.equals(nome_passaggio, that.nome_passaggio) &&
                Objects.equals(stima_durata, that.stima_durata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome_passaggio, id_prodotto, stima_durata);
    }
    public static final class DAO {
        public static List<DistintaBasePassaggi> findAll(Connection connection) {
            try (var stmt = DAOUtils.prepare(connection, Queries.LOAD_DISTINTA_PASSAGGI); 
                var rs   = stmt.executeQuery()) {
                var list = new ArrayList<DistintaBasePassaggi>();
                while(rs.next()) {
                    DistintaBasePassaggi p = new DistintaBasePassaggi(
                        rs.getString("nome_passaggio"),
                        rs.getInt("id_prodotto"),
                        rs.getInt("stima_durata")
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