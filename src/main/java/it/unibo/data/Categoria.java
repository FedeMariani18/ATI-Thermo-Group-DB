package it.unibo.data;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Categoria {
    public int id_categoria_statistica;
    public int id_categoria;
    public String descrizione;

    public Categoria(int id_categoria_statistica, int id_categoria, String descrizione) {
        this.id_categoria_statistica = id_categoria_statistica;
        this.id_categoria = id_categoria;
        this.descrizione = descrizione;
    }

    @Override
    public String toString() {
        return Printer.stringify("Categoria",
            List.of(
                Printer.field("id_categoria_statistica", id_categoria_statistica),
                Printer.field("id_categoria", id_categoria),
                Printer.field("descrizione", descrizione)
            )
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return id_categoria_statistica == categoria.id_categoria_statistica &&
                id_categoria == categoria.id_categoria &&
                Objects.equals(descrizione, categoria.descrizione);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_categoria_statistica, id_categoria, descrizione);
    }

    public static final class DAO {
        public static List<Categoria> categoriaVenduta(Connection connection) {
            try (var stmt = DAOUtils.prepare(connection, Queries.LOAD_CATEGORIA_VENDUTA); 
                var rs   = stmt.executeQuery()) {
                var list = new ArrayList<Categoria>();
                while(rs.next()) {
                    Categoria ba = new Categoria(
                        rs.getInt("NumeroProdottiVenduti"),
                        rs.getInt("id_categoria"),
                        rs.getString("descrizione")
                    );
                    list.add(ba);
                }
                return list;
            } catch (Exception e) {
                throw new DAOException("Errore durante il LOAD dei prodotti" + e.getMessage(), e);
            }
        }
    }
}