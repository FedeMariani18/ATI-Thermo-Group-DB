package it.unibo.data;

import java.util.List;
import java.util.Objects;

public class UtenteMercato {
    public String p_iva;
    public String nome;
    public String nazione;
    public String banca;
    public Integer id_pagamento;
    public String nome_tipologia_utente_mercato;
    public Integer id_sconto_prodotto;
    public Integer id_sconto_complessivo;

    public UtenteMercato(
        String p_iva,
        String nome,
        String nazione,
        String banca,
        Integer id_pagamento,
        String nome_tipologia_utente_mercato,
        Integer id_sconto_prodotto,
        Integer id_sconto_complessivo
    ) {
        this.p_iva = p_iva;
        this.nome = nome;
        this.nazione = nazione;
        this.banca = banca;
        this.id_pagamento = id_pagamento;
        this.nome_tipologia_utente_mercato = nome_tipologia_utente_mercato;
        this.id_sconto_prodotto = id_sconto_prodotto;
        this.id_sconto_complessivo = id_sconto_complessivo;
    }

    @Override
    public String toString() {
        return Printer.stringify("UtenteMercato",
            List.of(
                Printer.field("p_iva", p_iva),
                Printer.field("nome", nome),
                Printer.field("nazione", nazione),
                Printer.field("banca", banca),
                Printer.field("id_pagamento", id_pagamento),
                Printer.field("nome_tipologia_utente_mercato", nome_tipologia_utente_mercato),
                Printer.field("id_sconto_prodotto", id_sconto_prodotto),
                Printer.field("id_sconto_complessivo", id_sconto_complessivo)
            )
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UtenteMercato that = (UtenteMercato) o;
        return Objects.equals(p_iva, that.p_iva) &&
               Objects.equals(nome, that.nome) &&
               Objects.equals(nazione, that.nazione) &&
               Objects.equals(banca, that.banca) &&
               Objects.equals(id_pagamento, that.id_pagamento) &&
               Objects.equals(nome_tipologia_utente_mercato, that.nome_tipologia_utente_mercato) &&
               Objects.equals(id_sconto_prodotto, that.id_sconto_prodotto) &&
               Objects.equals(id_sconto_complessivo, that.id_sconto_complessivo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            p_iva, nome, nazione, banca, id_pagamento,
            nome_tipologia_utente_mercato, id_sconto_prodotto, id_sconto_complessivo
        );
    }
}