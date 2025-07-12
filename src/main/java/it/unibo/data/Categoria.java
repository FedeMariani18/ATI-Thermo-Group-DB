package it.unibo.data;

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
}