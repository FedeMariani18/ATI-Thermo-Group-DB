package it.data;

import java.util.List;
import java.util.Objects;

public class DistintaBase {
    public int id_prodotto1;
    public int id_prodotto;
    public Integer quantita; // può essere null

    public DistintaBase(int id_prodotto1, int id_prodotto, Integer quantita) {
        this.id_prodotto1 = id_prodotto1;
        this.id_prodotto = id_prodotto;
        this.quantita = quantita;
    }

    @Override
    public String toString() {
        return Printer.stringify("DistintaBase",
            List.of(
                Printer.field("id", id_prodotto1),
                Printer.field("id_prodotto", id_prodotto),
                Printer.field("quantita", quantita)
            )
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DistintaBase that = (DistintaBase) o;
        return D_P_id_prodotto == that.id_prodotto1 &&
                id_prodotto == that.id_prodotto &&
                Objects.equals(quantita, that.quantita);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_prodotto1, id_prodotto, quantita);
    }
}