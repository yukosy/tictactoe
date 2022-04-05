package com.tictactoe.entity;

import java.util.Scanner;
import java.util.regex.Pattern;

public class HumanPlayer extends Player {
    private String mySymbol;
    private String opponentSymbol;
    private final Scanner scanner;

    public HumanPlayer(Scanner scanner, Cells cells) {
        this.scanner = scanner;
        this.cells = cells;
        String showLevel = "Human turn";
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
        int[] coordinates;
        System.out.println("Enter coordinates:");
        coordinates = checkCoordinates(scanner.nextLine());
        return coordinates;
    }

    public int[] checkCoordinates(String inputText) {
        int[] coordinates = new int[2];
        if (Pattern.matches("^\\d\\s\\d", inputText)) {
            Pattern pattern = Pattern.compile("\\s");
            String[] strings = pattern.split(inputText, 2);
            coordinates[0] = Integer.parseInt(strings[0]);
            coordinates[1] = Integer.parseInt(strings[1]);
            if ((coordinates[0] > 3 || coordinates[0] < 1) || (coordinates[1] > 3 || coordinates[1] < 1)) {
                System.out.println("Coordinates should be from 1 to 3! ");
                return getCoordinates(cells);
            }
            if ((cells.getValue(coordinates[0], coordinates[1]).equals("X")) || (cells.getValue(coordinates[0], coordinates[1]).equals("O"))) {
                System.out.println("This cell is occupied! Choose another one!");
                return getCoordinates(cells);
            } else {
                return coordinates;
            }
        } else {
            System.out.println("You should enter numbers!");
            return getCoordinates(cells);
        }
    }
}
