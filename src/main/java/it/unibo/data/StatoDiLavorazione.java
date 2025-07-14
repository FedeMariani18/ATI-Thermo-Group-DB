package it.unibo.data;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    public static final class DAO {
        public static List<String> findAllNomeStato(Connection connection) {
            try (var stmt = DAOUtils.prepare(connection, Queries.LOAD_NOMI_DI_LAVROAZIONE); 
                var rs   = stmt.executeQuery()) {
                var list = new ArrayList<String>();
                while(rs.next()) {
                    String nome_stato = rs.getString("nome_stato");
                    list.add(nome_stato);
                }
                return list;
            } catch (Exception e) {
                throw new DAOException("Errore durante il LOAD dei prodotti" + e.getMessage(), e);
            }
            
        } 
    } 
}