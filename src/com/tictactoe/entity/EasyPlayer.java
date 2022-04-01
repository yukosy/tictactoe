package com.tictactoe.entity;

import java.util.Random;

public class EasyPlayer extends Player {
    private String mySymbol;
    private String opponentSymbol;

    public EasyPlayer(Cells cells) {
        this.cells = cells;
        String showLevel = "Making move level to " + Complexity.EASY.getValue();
        setShowLevel(showLevel);
    }

    public String getMySymbol() {
        return mySymbol;
    }

    @Override
    public void setMySymbol(String mySymbol) {
        this.mySymbol = mySymbol;
    }

    public String getOpponentSymbol() {
        return opponentSymbol;
    }

    public void setOpponentSymbol(String opponentSymbol) {
        this.opponentSymbol = opponentSymbol;
    }

    @Override
    public int[] getCoordinates(Cells cells) {
        return getRandomCoordinates();
    }

    public int[] getRandomCoordinates() {
        Random rnd = new Random();
        int a = rnd.nextInt(3) + 1;
        int b = rnd.nextInt(3) + 1;
        return cells.getCells()[a][b].equals(" ") ? new int[]{a, b} : getCoordinates(cells);
    }
}
