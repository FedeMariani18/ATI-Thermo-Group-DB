package it.unibo.data;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

public class BollaAcquisto {
    public int id_bolla_acquisto;
    public Date data;
    public String p_iva;

    public BollaAcquisto(int id_bolla_acquisto, Date data, String p_iva) {
        this.id_bolla_acquisto = id_bolla_acquisto;
        this.data = data;
        this.p_iva = p_iva;
    }

    @Override
    public String toString() {
        return Printer.stringify("BollaAcquisto",
            List.of(
                Printer.field("id", id_bolla_acquisto),
                Printer.field("data", data),
                Printer.field("fornitore", p_iva)
            )
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BollaAcquisto that = (BollaAcquisto) o;
        return id_bolla_acquisto == that.id_bolla_acquisto &&
                Objects.equals(data, that.data) &&
                Objects.equals(p_iva, that.p_iva);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_bolla_acquisto, data, p_iva);
    }
}