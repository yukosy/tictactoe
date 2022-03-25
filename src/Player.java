public interface Player {

    void turn();
    int[] getCoordinates(Cells cells);
    void setSymbol(int[] coordinates);
    void setOpponentSymbol(String opponentSymbol);
    void setMySymbol(String mySymbol);

}
