package com.tictactoe.entity;

import java.util.Random;

public class MediumPlayer extends Player {
    private String mySymbol;
    private String opponentSymbol;

    public MediumPlayer(Cells cells) {
        this.cells = cells;
        String showLevel = "Making move level to " + Complexity.MEDIUM.getValue();
        setShowLevel(showLevel);
    }

    public String getMySymbol() {
        return mySymbol;
    }

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
            if (canWinNextStep(mySymbol) != null) {
                return canWinNextStep(mySymbol);
            } else if (canWinNextStep(opponentSymbol) != null) {
                return canWinNextStep(opponentSymbol);
            } else {
                return getRandomCoordinates();
            }
    }

    public int[] getRandomCoordinates() {
        Random rnd = new Random();
        int a = rnd.nextInt(3) + 1;
        int b = rnd.nextInt(3) + 1;
        return cells.getCells()[a][b].equals(" ") ? new int[]{a, b} : getCoordinates(cells);
    }

    public int[] canWinNextStep(String s) {
        int count;
        for (int[][] arrays : cells.allVariants) {
            count = 0;
            for (int[] ints : arrays) {
                if (cells.getCells()[ints[0]][ints[1]].equals(s)) {
                    count++;
                }
            }
            if (count == 2) {
                for (int[] ints : arrays) {
                    if (cells.getCells()[ints[0]][ints[1]].equals(" ")) {
                        return ints;
                    }
                }
            }
        }
        return null;
    }
}
