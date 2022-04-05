package com.tictactoe.entity;

public class HardPlayer extends Player {

    public static int maxSum;
    public static int minSum;

    public HardPlayer(Cells cells) {
        this.cells = cells;
        String showLevel = "Making move level \"hard\"";
        setShowLevel(showLevel);
    }

    @Override
    public int[] getCoordinates(Cells cells) {
        int bestResul = Integer.MIN_VALUE;
        int a = 0;
        int b = 0;
        for (int i = 1; i < cells.getCells().length; i++) {
            for (int j = 1; j < cells.getCells()[i].length; j++) {
                if (cells.getValue(i, j).equals(" ")) {
                    cells.setValue(i, j, getMySymbol());
                    maxSum = 0;
                    minSum = 0;
                    int max = minimax(cells, 0, false);
                    cells.setValue(i, j, " ");
                    if (max > bestResul) {
                        bestResul = max;
                        a = i;
                        b = j;
                    }
                }
            }
        }
        return new int[]{a, b};
    }

    public int minimax(Cells cells, int depth, boolean isMax) {
        int result = analysisCells(cells);
        int opponentWin = getMySymbol().equals("O") ? 1 : 2;
        int myWin = getMySymbol().equals("X") ? 1 : 2;
        if (result == myWin) {
            return 10 - depth;
        }
        if (result == opponentWin) {
            return depth - 10;
        }
        if (result == 3) {
            return 0;
        }
        depth++;
        if (isMax) {
            for (int i = 1; i < cells.getCells().length; i++) {
                for (int j = 1; j < cells.getCells()[i].length; j++) {
                    if (cells.getValue(i, j).equals(" ")) {
                        cells.setValue(i, j, getMySymbol());
                        int newBest = minimax(cells, depth, false);
                        maxSum = Math.max(maxSum, newBest);
                        cells.setValue(i, j, " ");
                    }
                }

            }
            return maxSum;
        } else {
            for (int i = 1; i < cells.getCells().length; i++) {
                for (int j = 1; j < cells.getCells()[i].length; j++) {
                    if (cells.getValue(i, j).equals(" ")) {
                        cells.setValue(i, j, getOpponentSymbol());
                        int newBest = minimax(cells, depth, true);
                        minSum = Math.min(minSum, newBest);
                        cells.setValue(i, j, " ");
                    }
                }
            }
            return minSum;
        }
    }
}
