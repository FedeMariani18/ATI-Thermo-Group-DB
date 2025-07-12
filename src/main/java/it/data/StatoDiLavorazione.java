package it.data;

import java.util.List;
import java.util.Objects;

public class StatoDiLavorazione {
    public String nome_stato;
    public String descrizione;

    public StatoDiLavorazione(String nome_stato, String descrizione) {
        this.nome_stato = nome_stato;
        this.descrizione = descrizione;
    }

    @Override
    public String toString() {
        return Printer.stringify("StatoDiLavorazione",
            List.of(
                Printer.field("nome_stato", nome_stato),
                Printer.field("descrizione", descrizione)
            )
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatoDiLavorazione that = (StatoDiLavorazione) o;
        return Objects.equals(nome_stato, that.nome_stato) &&
               Objects.equals(descrizione, that.descrizione);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome_stato, descrizione);
    }
}