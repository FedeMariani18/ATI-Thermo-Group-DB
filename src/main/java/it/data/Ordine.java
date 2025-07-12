package it.data;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

public class Ordine {
    public int id_ordine;
    public Date data;
    public String p_iva;

    public Ordine(int id_ordine, Date data, String p_iva) {
        this.id_ordine = id_ordine;
        this.data = data;
        this.p_iva = p_iva;
    }

    @Override
    public String toString() {
        return Printer.stringify("Ordine",
            List.of(
                Printer.field("id_ordine", id_ordine),
                Printer.field("data", data),
                Printer.field("p_iva", p_iva)
            )
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ordine ordine = (Ordine) o;
        return id_ordine == ordine.id_ordine &&
               Objects.equals(data, ordine.data) &&
               Objects.equals(p_iva, ordine.p_iva);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_ordine, data, p_iva);
    }
}