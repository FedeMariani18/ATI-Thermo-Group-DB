package it.unibo.data;

import java.util.List;
import java.util.Objects;

public class PassaggioDiLavorazione {
    public String nome_passaggio;
    public String descrizione;

    public PassaggioDiLavorazione(String nome_passaggio, String descrizione) {
        this.nome_passaggio = nome_passaggio;
        this.descrizione = descrizione;
    }

    @Override
    public String toString() {
        return Printer.stringify("PassaggioDiLavorazione",
            List.of(
                Printer.field("nome_passaggio", nome_passaggio),
                Printer.field("descrizione", descrizione)
            )
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PassaggioDiLavorazione that = (PassaggioDiLavorazione) o;
        return Objects.equals(nome_passaggio, that.nome_passaggio) &&
               Objects.equals(descrizione, that.descrizione);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome_passaggio, descrizione);
    }
}