package it.data;

import java.util.List;
import java.util.Objects;

public class Quadrante {
    public int id_magazzino;
    public int numero_scansia;
    public int colonna;
    public int piano;
    public Integer capacita;

    public Quadrante(int id_magazzino, int numero_scansia, int colonna, int piano, Integer capacita) {
        this.id_magazzino = id_magazzino;
        this.numero_scansia = numero_scansia;
        this.colonna = colonna;
        this.piano = piano;
        this.capacita = capacita;
    }

    @Override
    public String toString() {
        return Printer.stringify("Quadrante",
            List.of(
                Printer.field("id_magazzino", id_magazzino),
                Printer.field("numero_scansia", numero_scansia),
                Printer.field("colonna", colonna),
                Printer.field("piano", piano),
                Printer.field("capacita", capacita)
            )
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quadrante that = (Quadrante) o;
        return id_magazzino == that.id_magazzino &&
               numero_scansia == that.numero_scansia &&
               colonna == that.colonna &&
               piano == that.piano &&
               Objects.equals(capacita, that.capacita);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_magazzino, numero_scansia, colonna, piano, capacita);
    }
}