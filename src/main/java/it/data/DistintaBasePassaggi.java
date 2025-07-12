package it.data;

import java.util.Objects;

public class DistintaBasePassaggi {
    public String nome_passaggio;
    public int id_prodotto;
    public Integer stima_durata; // può essere null

    public DistintaBasePassaggi(String nome_passaggio, int id_prodotto, Integer stima_durata) {
        this.nome_passaggio = nome_passaggio;
        this.id_prodotto = id_prodotto;
        this.stima_durata = stima_durata;
    }

    @Override
    public String toString() {
        return "DistintaBasePassaggi{" +
                "nome_passaggio='" + nome_passaggio + '\'' +
                ", id_prodotto=" + id_prodotto +
                ", stima_durata=" + stima_durata +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DistintaBasePassaggi that = (DistintaBasePassaggi) o;
        return id_prodotto == that.id_prodotto &&
                Objects.equals(nome_passaggio, that.nome_passaggio) &&
                Objects.equals(stima_durata, that.stima_durata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome_passaggio, id_prodotto, stima_durata);
    }
}