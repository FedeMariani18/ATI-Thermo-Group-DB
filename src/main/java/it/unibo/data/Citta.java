package it.unibo.data;

import java.util.List;
import java.util.Objects;

public class Citta {
    public String nome_citta;

    public Citta(String nome_citta) {
        this.nome_citta = nome_citta;
    }

    @Override
    public String toString() {
        return Printer.stringify("Citta",
            List.of(
                Printer.field("nome_citta", nome_citta)
            )
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Citta citta = (Citta) o;
        return Objects.equals(nome_citta, citta.nome_citta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome_citta);
    }
}