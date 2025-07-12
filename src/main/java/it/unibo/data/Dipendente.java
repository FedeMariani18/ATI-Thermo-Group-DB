package it.unibo.data;

import java.util.List;
import java.util.Objects;

public class Dipendente {
    public String codice_fiscale;
    public String nome;
    public String cognome;
    public int anno_di_nascita;
    public String nome_ruolo;

    public Dipendente(String codice_fiscale, String nome, String cognome, int anno_di_nascita, String nome_ruolo) {
        this.codice_fiscale = codice_fiscale;
        this.nome = nome;
        this.cognome = cognome;
        this.anno_di_nascita = anno_di_nascita;
        this.nome_ruolo = nome_ruolo;
    }

    @Override
    public String toString() {
        return Printer.stringify("Dipendente",
            List.of(
                Printer.field("codice_fiscale", codice_fiscale),
                Printer.field("nome", nome),
                Printer.field("cognome", cognome),
                Printer.field("anno_di_nascita", anno_di_nascita),
                Printer.field("nome_ruolo", nome_ruolo)
            )
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dipendente that = (Dipendente) o;
        return anno_di_nascita == that.anno_di_nascita &&
                Objects.equals(codice_fiscale, that.codice_fiscale) &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(cognome, that.cognome) &&
                Objects.equals(nome_ruolo, that.nome_ruolo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codice_fiscale, nome, cognome, anno_di_nascita, nome_ruolo);
    }
}