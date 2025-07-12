package it.unibo.data;

import java.util.List;
import java.util.Objects;

public class ScontoProdotto {
    public int id_sconto_prodotto;

    public ScontoProdotto(int id_sconto_prodotto) {
        this.id_sconto_prodotto = id_sconto_prodotto;
    }

    @Override
    public String toString() {
        return Printer.stringify("ScontoProdotto",
            List.of(
                Printer.field("id_sconto_prodotto", id_sconto_prodotto)
            )
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScontoProdotto that = (ScontoProdotto) o;
        return id_sconto_prodotto == that.id_sconto_prodotto;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_sconto_prodotto);
    }
}