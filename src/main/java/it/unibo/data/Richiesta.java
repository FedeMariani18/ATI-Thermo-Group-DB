package it.unibo.data;

import java.util.List;
import java.util.Objects;

public class Richiesta {
    public int id_ordine;
    public int id_prodotto;
    public Integer quantita;

    public Richiesta(int id_ordine, int id_prodotto, Integer quantita) {
        this.id_ordine = id_ordine;
        this.id_prodotto = id_prodotto;
        this.quantita = quantita;
    }

    @Override
    public String toString() {
        return Printer.stringify("Richiesta",
            List.of(
                Printer.field("id_ordine", id_ordine),
                Printer.field("id_prodotto", id_prodotto),
                Printer.field("quantita", quantita)
            )
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Richiesta that = (Richiesta) o;
        return id_ordine == that.id_ordine &&
               id_prodotto == that.id_prodotto &&
               Objects.equals(quantita, that.quantita);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_ordine, id_prodotto, quantita);
    }
}