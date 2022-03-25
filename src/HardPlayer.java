public class HardPlayer implements Player {
    private String mySymbol;
    private String opponentSymbol;
    private final Cells cells;
    private final String showLevel = "Making move level \"hard\"";
    public static int maxSum;
    public static int minSum;

    public HardPlayer(Cells cells) {
        this.cells = cells;
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
    public void turn() {
        System.out.println(showLevel);
        int[] getTurn = getCoordinates(cells);
        setSymbol(getTurn);
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
                    //System.out.println(i + " " + j + " - " + maxSum + " min - " + minSum + " return - " + max);
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

//    public int[] canWinNextStep(String symbol) {
//        int count;
//        boolean isEmpty;
//        for (int[][] arrays : cells.allVariants) {
//            count = 0;
//            isEmpty = false;
//            int a = 0;
//            int b = 0;
//            for (int[] ints : arrays) {
//                if (cells.getCells()[ints[0]][ints[1]].equals(symbol)) {
//                    count++;
//                }
//                if (cells.getCells()[ints[0]][ints[1]].equals(" ")) {
//                    isEmpty = true;
//                    a = ints[0];
//                    b = ints[1];
//                }
//                if (count == 2 && isEmpty) {
//                    return new int[]{a, b};
//                }
//            }
//        }
//        return null;
//    }

    @Override
    public void setSymbol(int[] coordinates) {
        cells.setValue(coordinates[0], coordinates[1], getMySymbol());
    }

    public int analysisCells(Cells cells) {
        boolean isFull = true;
        for (int[][] ints : cells.allVariants) {
            if (!cells.getCells()[ints[0][0]][ints[0][1]].equals(" ")) {
                if (cells.getCells()[ints[0][0]][ints[0][1]].equals(cells.getCells()[ints[1][0]][ints[1][1]])) {
                    if (cells.getCells()[ints[1][0]][ints[1][1]].equals(cells.getCells()[ints[2][0]][ints[2][1]])) {
                        return cells.getCells()[ints[0][0]][ints[0][1]].equals("X") ? 1 : 2; //strings[0] + " wins"
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
        return isFull ? 3 : 4; //"Draw" : "Game not finished";
    }

    @Override
    public String toString() {
        return showLevel;
    }
}
