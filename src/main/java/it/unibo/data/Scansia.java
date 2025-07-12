package it.unibo.data;

import java.util.List;
import java.util.Objects;

public class Scansia {
    public int id_magazzino;
    public int numero_scansia;

    public Scansia(int id_magazzino, int numero_scansia) {
        this.id_magazzino = id_magazzino;
        this.numero_scansia = numero_scansia;
    }

    @Override
    public String toString() {
        return Printer.stringify("Scansia",
            List.of(
                Printer.field("id_magazzino", id_magazzino),
                Printer.field("numero_scansia", numero_scansia)
            )
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scansia scansia = (Scansia) o;
        return id_magazzino == scansia.id_magazzino &&
               numero_scansia == scansia.numero_scansia;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_magazzino, numero_scansia);
    }
}