package it.data;

import java.util.List;
import java.util.Objects;

public class TipoPagamento {
    public int id_pagamento;
    public String descrizione;
    public Integer durata; // può essere null

    public TipoPagamento(int id_pagamento, String descrizione, Integer durata) {
        this.id_pagamento = id_pagamento;
        this.descrizione = descrizione;
        this.durata = durata;
    }

    @Override
    public String toString() {
        return Printer.stringify("TipoPagamento",
            List.of(
                Printer.field("id_pagamento", id_pagamento),
                Printer.field("descrizione", descrizione),
                Printer.field("durata", durata)
            )
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoPagamento that = (TipoPagamento) o;
        return id_pagamento == that.id_pagamento &&
               Objects.equals(descrizione, that.descrizione) &&
               Objects.equals(durata, that.durata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_pagamento, descrizione, durata);
    }
}