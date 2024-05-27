package dev.ikeepcalm.visualizer.source;

public enum City {
    Rome, Milan, Venice, Florence, Naples, Genoa, Bologna, Turin, Verona, Pisa, Siena, Cinque, Capri, Amalfi, Pescara;
    public static City decode(int i) {
        return City.values()[i];
    }
}