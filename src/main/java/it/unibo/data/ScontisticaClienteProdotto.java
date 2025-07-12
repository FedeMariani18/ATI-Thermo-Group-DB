package it.unibo.data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class ScontisticaClienteProdotto {
    public int id_prodotto;
    public int id_sconto_prodotto;
    public BigDecimal percentuale;

    public ScontisticaClienteProdotto(int id_prodotto, int id_sconto_prodotto, BigDecimal percentuale) {
        this.id_prodotto = id_prodotto;
        this.id_sconto_prodotto = id_sconto_prodotto;
        this.percentuale = percentuale;
    }

    @Override
    public String toString() {
        return Printer.stringify("ScontisticaClienteProdotto",
            List.of(
                Printer.field("id_prodotto", id_prodotto),
                Printer.field("id_sconto_prodotto", id_sconto_prodotto),
                Printer.field("percentuale", percentuale)
            )
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScontisticaClienteProdotto that = (ScontisticaClienteProdotto) o;
        return id_prodotto == that.id_prodotto &&
               id_sconto_prodotto == that.id_sconto_prodotto &&
               Objects.equals(percentuale, that.percentuale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_prodotto, id_sconto_prodotto, percentuale);
    }
}