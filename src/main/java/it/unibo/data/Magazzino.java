package it.unibo.data;

import java.util.List;
import java.util.Objects;

public class Magazzino {
    public int id_magazzino;
    public String nome;
    public String via;
    public String civico;
    public String nome_citta;

    public Magazzino(int id_magazzino, String nome, String via, String civico, String nome_citta) {
        this.id_magazzino = id_magazzino;
        this.nome = nome;
        this.via = via;
        this.civico = civico;
        this.nome_citta = nome_citta;
    }

    @Override
    public String toString() {
        return Printer.stringify("Magazzino",
            List.of(
                Printer.field("id_magazzino", id_magazzino),
                Printer.field("nome", nome),
                Printer.field("via", via),
                Printer.field("civico", civico),
                Printer.field("nome_citta", nome_citta)
            )
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Magazzino that = (Magazzino) o;
        return id_magazzino == that.id_magazzino &&
               Objects.equals(nome, that.nome) &&
               Objects.equals(via, that.via) &&
               Objects.equals(civico, that.civico) &&
               Objects.equals(nome_citta, that.nome_citta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_magazzino, nome, via, civico, nome_citta);
    }
}