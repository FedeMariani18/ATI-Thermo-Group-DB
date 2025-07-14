package it.unibo.data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SchedaDiLavorazione {
    public String codice_fiscale;
    public int id_prodotto;
    public int id_seriale;
    public Date data;
    public Time ora_inizio;
    public Time ora_fine;

    public SchedaDiLavorazione(
        String codice_fiscale,
        int id_prodotto,
        int id_seriale,
        Date data,
        Time ora_inizio,
        Time ora_fine
    ) {
        this.codice_fiscale = codice_fiscale;
        this.id_prodotto = id_prodotto;
        this.id_seriale = id_seriale;
        this.data = data;
        this.ora_inizio = ora_inizio;
        this.ora_fine = ora_fine;
    }

    @Override
    public String toString() {
        return Printer.stringify("SchedaDiLavorazione",
            List.of(
                Printer.field("codice_fiscale", codice_fiscale),
                Printer.field("id_prodotto", id_prodotto),
                Printer.field("id_seriale", id_seriale),
                Printer.field("data", data),
                Printer.field("ora_inizio", ora_inizio),
                Printer.field("ora_fine", ora_fine)
            )
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchedaDiLavorazione that = (SchedaDiLavorazione) o;
        return id_prodotto == that.id_prodotto &&
               id_seriale == that.id_seriale &&
               Objects.equals(codice_fiscale, that.codice_fiscale) &&
               Objects.equals(data, that.data) &&
               Objects.equals(ora_inizio, that.ora_inizio) &&
               Objects.equals(ora_fine, that.ora_fine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codice_fiscale, id_prodotto, id_seriale, data, ora_inizio, ora_fine);
    }

    public static final class DAO {
        public static List<SchedaDiLavorazione> findAll(Connection connection) {
            try (var stmt = DAOUtils.prepare(connection, Queries.LOAD_SCHEDE); 
                var rs   = stmt.executeQuery()) {
                var list = new ArrayList<SchedaDiLavorazione>();
                while(rs.next()) {
                    SchedaDiLavorazione p = new SchedaDiLavorazione(
                        rs.getString("codice_fiscale"),
                        rs.getInt("id_prodotto"),
                        rs.getInt("id_seriale"),
                        rs.getDate("data"),
                        rs.getTime("ora_inizio"),
                        rs.getTime("ora_fine")
                    );
                    list.add(p);
                }
                return list;
            } catch (Exception e) {
                throw new DAOException("Errore durante il LOAD dei prodotti" + e.getMessage(), e);
            }
            
        }

        public static String insertScheda(Connection connection, SchedaDiLavorazione a) {
            try (var ps = connection.prepareStatement(Queries.INSERISCI_SCHEDA, java.sql.Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, a.codice_fiscale);
                ps.setInt(2, a.id_prodotto);
                ps.setInt(3, a.id_seriale);
                ps.setTime(4, a.ora_inizio);
                ps.setTime(5, a.ora_fine);
                ps.setDate(6, a.data);
                ps.executeUpdate();
                try (ResultSet keys = ps.getGeneratedKeys()) {
                    if (keys.next()) {
                        String cf = keys.getString(1);
                        a.codice_fiscale = cf;
                        return cf;
                    }
                    return "";
                }
            } catch (Exception e) {
                throw new DAOException("Errore durante il LOAD dei prodotti" + e.getMessage(), e);
            }
        }
    }
}