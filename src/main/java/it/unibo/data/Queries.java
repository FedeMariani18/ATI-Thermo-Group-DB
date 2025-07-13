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
}