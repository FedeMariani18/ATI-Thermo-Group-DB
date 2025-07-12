package it.unibo.data;

import java.util.List;
import java.util.Objects;

public class CategoriaStatistica {
    public int id_categoria_statistica;
    public String descrizione;

    public CategoriaStatistica(int id_categoria_statistica, String descrizione) {
        this.id_categoria_statistica = id_categoria_statistica;
        this.descrizione = descrizione;
    }

    @Override
    public String toString() {
        return Printer.stringify("CategoriaStatistica",
            List.of(
                Printer.field("id_categoria_statistica", id_categoria_statistica),
                Printer.field("descrizione", descrizione)
            )
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoriaStatistica that = (CategoriaStatistica) o;
        return id_categoria_statistica == that.id_categoria_statistica &&
                Objects.equals(descrizione, that.descrizione);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_categoria_statistica, descrizione);
    }
}