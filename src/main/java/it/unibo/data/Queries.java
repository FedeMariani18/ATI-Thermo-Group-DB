package it.unibo.data;

public final class Queries {
    public static final String LOAD_PRODOTTI = """
        SELECT *
        FROM prodotti
        """;
    
    public static final String FIND_PRODOTTO = """
        SELECT *
        FROM prodotti
        WHERE id_prodotto = ?
        """;
    
    public static final String LOAD_ARTICOLI = """
        SELECT *
        FROM articoli
        """;
    
    public static final String FIND_ARTICOLO = """
        SELECT *
        FROM articoli
        WHERE id_seriale = ?
        """;

	public static final String FIND_ARTICOLO_BY_PRODUCT = """
        SELECT *
        FROM articoli
        WHERE id_prodotto = ?
        """;
    
    public static final String LOAD_SCHEDE = """
        SELECT *
        FROM schede_di_lavorazione
        """;

    public static final String LOAD_BOLLE_ACQUISTO = """
        SELECT *
        FROM bolle_acquisto
        """;

    public static final String LOAD_BOLLE_ACQUISTO_JOINED_VENDITORI = """
        SELECT *
        FROM bolle_acquisto, utenti_mercato
        WHERE bolle_acquisto.p_iva == utenti_mercato.p_iva
        """;

    public static final String LOAD_UTENTI_MERCATO = """
        SELECT *
        FROM utenti_mercato
        """;

    public static final String LOAD_ORDINI = """
        SELECT *
        FROM ordini
        """;

    public static final String LOAD_BOLLE_VENDITA = """
        SELECT *
        FROM bolle_vendita
        """;

    public static final String LOAD_DISTINTA = """
        SELECT *
        FROM distinte_base
        """;

    public static final String LOAD_DISTINTA_PASSAGGI = """
        SELECT *
        FROM distinte_base_passaggi
        """;

    public static final String LOAD_DIPENDENTI = """
        SELECT *
        FROM dipendenti
        """;

    public static final String LOAD_MAGAZZINI = """
        SELECT *
        FROM magazzini
        """;

    public static final String LOAD_NOMI_DI_LAVROAZIONE = """
        SELECT nome_stato
        FROM stati_di_lavorazione
        """;

    public static final String LOAD_GRUPPI = """
        SELECT *
        FROM gruppi
        """;
    
    public static final String INSERT_BOLLA_ACQUISTO = """
        INSERT INTO BOLLE_ACQUISTO (id_bolla_acquisto, data, p_iva)
        VALUES (?, ?, ?)
        """;

    public static final String ADD_PRODOTTO = """
        INSERT INTO PRODOTTO (id_prodotto, prezzo_listino, descrizione, peso, superficie,
        prezzo_inventario, codice_a_barre, nome_stato, id_gruppo, id_categoria,
        id_categoria_statistica)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """;
;

    public static final String TEMPO_LAVORAZIONE = """
    SELECT 
        (
            SELECT SUM(TIMESTAMPDIFF(MINUTE, ora_inizio, ora_fine))
            FROM SCHEDA_DI_LAVORAZIONE
            WHERE id_seriale = ?
        ) AS TempoEffettivo,

        (
            SELECT SUM(stima_durata)
            FROM DISTINTA_BASE_PASSAGGI
            WHERE id_prodotto = (
                SELECT id_prodotto
                FROM ARTICOLO
                WHERE id_seriale = ?
            )
        ) AS TempoStimato;
    """;

    public static final String LOAD_CATEGORIA_VENDUTA = """
        SELECT C.id_categoria, C.descrizione, COUNT(*) AS NumeroProdottiVenduti
        FROM BOLLE_VENDITA B
        JOIN ARTICOLI A ON B.id_bolla_vendita = A.id_bolla_vendita
        JOIN PRODOTTI P ON A.id_prodotto = P.id_prodotto
        JOIN GRUPPI G ON P.id_gruppo = G.id_gruppo
        JOIN CATEGORIE C ON G.id_categoria = C.id_categoria
        WHERE B.data >= DATE_SUB(CURDATE(), INTERVAL 10 YEAR)
        GROUP BY C.id_categoria, C.descrizione
        ORDER BY NumeroProdottiVenduti DESC
        LIMIT 1;

    """;
}