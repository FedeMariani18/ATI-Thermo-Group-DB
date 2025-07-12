package it.data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class ScontoComplessivo {
    public int id_sconto_complessivo;
    public BigDecimal percentuale;

    public ScontoComplessivo(int id_sconto_complessivo, BigDecimal percentuale) {
        this.id_sconto_complessivo = id_sconto_complessivo;
        this.percentuale = percentuale;
    }

    @Override
    public String toString() {
        return Printer.stringify("ScontoComplessivo",
            List.of(
                Printer.field("id_sconto_complessivo", id_sconto_complessivo),
                Printer.field("percentuale", percentuale)
            )
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScontoComplessivo that = (ScontoComplessivo) o;
        return id_sconto_complessivo == that.id_sconto_complessivo &&
               Objects.equals(percentuale, that.percentuale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_sconto_complessivo, percentuale);
    }
}