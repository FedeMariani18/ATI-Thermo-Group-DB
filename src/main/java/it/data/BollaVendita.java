package it.data;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

public class BollaVendita {
    public int id_bolla_vendita;
    public int id_ordine;
    public Date data;
    public String p_iva;

    public BollaVendita(int id_bolla_vendita, int id_ordine, Date data, String p_iva) {
        this.id_bolla_vendita = id_bolla_vendita;
        this.id_ordine = id_ordine;
        this.data = data;
        this.p_iva = p_iva;
    }

    @Override
    public String toString() {
        return Printer.stringify("BollaVendita",
            List.of(
                Printer.field("id", id_bolla_vendita),
                Printer.field("data", data),
                Printer.field("cliente", p_iva)
            )
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BollaVendita that = (BollaVendita) o;
        return id_bolla_vendita == that.id_bolla_vendita &&
                id_ordine == that.id_ordine &&
                Objects.equals(data, that.data) &&
                Objects.equals(p_iva, that.p_iva);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_bolla_vendita, id_ordine, data, p_iva);
    }
}