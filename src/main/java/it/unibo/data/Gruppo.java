package it.unibo.data;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Gruppo {
    public int id_categoria_statistica;
    public int id_categoria;
    public int id_gruppo;
    public String descrizione;

    public Gruppo(int id_categoria_statistica, int id_categoria, int id_gruppo, String descrizione) {
        this.id_categoria_statistica = id_categoria_statistica;
        this.id_categoria = id_categoria;
        this.id_gruppo = id_gruppo;
        this.descrizione = descrizione;
    }

    @Override
    public String toString() {
        return Printer.stringify("Gruppo",
            List.of(
                Printer.field("id_categoria_statistica", id_categoria_statistica),
                Printer.field("id_categoria", id_categoria),
                Printer.field("id_gruppo", id_gruppo),
                Printer.field("descrizione", descrizione)
            )
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gruppo gruppo = (Gruppo) o;
        return id_categoria_statistica == gruppo.id_categoria_statistica &&
               id_categoria == gruppo.id_categoria &&
               id_gruppo == gruppo.id_gruppo &&
               Objects.equals(descrizione, gruppo.descrizione);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_categoria_statistica, id_categoria, id_gruppo, descrizione);
    }

    public final static class DAO {

        public static List<Gruppo> findAll(Connection connection) {
            try (var stmt = DAOUtils.prepare(connection, Queries.LOAD_GRUPPI); 
                var rs   = stmt.executeQuery()) {
                var list = new ArrayList<Gruppo>();
                while(rs.next()) {
                    Gruppo g = new Gruppo(
                        rs.getInt("id_categoria_statistica"),
                        rs.getInt("id_categoria"),
                        rs.getInt("id_gruppo"),
                        rs.getString("descrizione")
                    );
                    list.add(g);
                }
                return list;
            } catch (Exception e) {
                throw new DAOException("Errore durante il LOAD dei prodotti" + e.getMessage(), e);
            }
        
        }

    }
}