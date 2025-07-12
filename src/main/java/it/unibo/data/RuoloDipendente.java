package it.unibo.data;

import java.util.List;
import java.util.Objects;

public class RuoloDipendente {
    public String nome_ruolo;
    public String descrizione;

    public RuoloDipendente(String nome_ruolo, String descrizione) {
        this.nome_ruolo = nome_ruolo;
        this.descrizione = descrizione;
    }

    @Override
    public String toString() {
        return Printer.stringify("RuoloDipendente",
            List.of(
                Printer.field("nome_ruolo", nome_ruolo),
                Printer.field("descrizione", descrizione)
            )
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RuoloDipendente that = (RuoloDipendente) o;
        return Objects.equals(nome_ruolo, that.nome_ruolo) &&
               Objects.equals(descrizione, that.descrizione);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome_ruolo, descrizione);
    }
}