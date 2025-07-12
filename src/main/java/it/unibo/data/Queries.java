package it.unibo.data;

public final class Queries {
    public static final String LOAD_PRODOTTI = """
        SELECT *
        FROM prodotti
        """;
    
    public static final String LOAD_STATO_LAVORAZIONE = "SELECT * FROM StatoDiLavorazione";
    
    public static final String LOAD_ORDINI = "SELECT * FROM Ordine";
    
    public static final String LOAD_CLIENTI = "SELECT * FROM Cliente";
    
    public static final String FIND_PRODOTTO = """
        SELECT *
        FROM prodotti
        WHERE codice = ?
        """;

}