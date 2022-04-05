package com.tictactoe.entity;

public abstract class Player {
    private final String X_SYMBOL = "X";
    private final String O_SYMBOL = "O";
    private String mySymbol;
    private String opponentSymbol;
    private String showLevel;
    Cells cells;

    public void turn() {
        System.out.println(showLevel);
        int[] getTurn = getCoordinates(cells);
        setSymbol(getTurn);
    }
    public abstract int[] getCoordinates(Cells cells);

    public void setShowLevel(String showLevel) {
        this.showLevel = showLevel;
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

        public int analysisCells(Cells cells) {
        boolean isFull = true;
        for (int[][] ints : cells.allVariants) {
            if (!cells.getCells()[ints[0][0]][ints[0][1]].equals(" ")) {
                if (cells.getCells()[ints[0][0]][ints[0][1]].equals(cells.getCells()[ints[1][0]][ints[1][1]])) {
                    if (cells.getCells()[ints[1][0]][ints[1][1]].equals(cells.getCells()[ints[2][0]][ints[2][1]])) {
                        return cells.getCells()[ints[0][0]][ints[0][1]].equals(X_SYMBOL) ? 1 : 2; //strings[0] + " wins"
                    }
                }
            }
            if (isFull) {
                if (!cells.getCells()[ints[0][0]][ints[0][1]].equals(" ")) {
                    if (!cells.getCells()[ints[1][0]][ints[1][1]].equals(" ")) {
                        if (cells.getCells()[ints[2][0]][ints[2][1]].equals(" ")) {
                            isFull = false;
                        }
                    } else {
                        isFull = false;
                    }
                } else {
                    isFull = false;
                }
            }
        }
        return isFull ? 3 : 4; //"Draw" : "com.tictactoe.controller.Game not finished";
    }

    public boolean checkWin() {
        switch (analysisCells(cells)) {
            case 4:
                return false;
            case 1:
                System.out.println(X_SYMBOL + " wins");
                return true;
            case 2:
                System.out.println(O_SYMBOL + " wins");
                return true;
            case 3:
                System.out.println("Draw");
                return true;
        }
        return true;
    }

    public void setSymbol(int[] coordinates) {
        cells.setValue(coordinates[0], coordinates[1], getMySymbol());
    }

    public String toString() {
        return this.showLevel;
    }
}
