package it.unibo.data;

import java.util.List;
import java.util.Objects;

public class TipologiaUtenteMercato {
    public String nome_tipologia_utente_mercato;
    public String descrizione;

    public TipologiaUtenteMercato(String nome_tipologia_utente_mercato, String descrizione) {
        this.nome_tipologia_utente_mercato = nome_tipologia_utente_mercato;
        this.descrizione = descrizione;
    }

    @Override
    public String toString() {
        return Printer.stringify("TipologiaUtenteMercato",
            List.of(
                Printer.field("nome_tipologia_utente_mercato", nome_tipologia_utente_mercato),
                Printer.field("descrizione", descrizione)
            )
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipologiaUtenteMercato that = (TipologiaUtenteMercato) o;
        return Objects.equals(nome_tipologia_utente_mercato, that.nome_tipologia_utente_mercato) &&
               Objects.equals(descrizione, that.descrizione);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome_tipologia_utente_mercato, descrizione);
    }
}