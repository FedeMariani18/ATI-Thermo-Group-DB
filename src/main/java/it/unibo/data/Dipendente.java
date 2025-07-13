package it.unibo.data;

import java.sql.Connection;
import java.util.ArrayList;
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

    public static final class DAO {
        public static List<Dipendente> findAll(Connection connection) {
            try (var stmt = DAOUtils.prepare(connection, Queries.LOAD_DIPENDENTI); 
                var rs   = stmt.executeQuery()) {
                var list = new ArrayList<Dipendente>();
                while(rs.next()) {
                    Dipendente p = new Dipendente(
                        rs.getString("codice_fiscale"),
                        rs.getString("nome"),
                        rs.getString("cognome"),
                        rs.getInt("anno_di_nascita"),
                        rs.getString("nome_ruolo")
                    );
                    list.add(p);
                }
                return list;
            } catch (Exception e) {
                throw new DAOException("Errore durante il LOAD dei prodotti" + e.getMessage(), e);
            }
            
        }
    }
}