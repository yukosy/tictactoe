package com.tictactoe.controller;

import com.tictactoe.entity.*;

import java.util.Scanner;

public class Input {
    private final Scanner scanner;
    private Player playerOne;
    private Player playerTwo;
    Cells cells;

    public Input(Scanner scanner) {
        this.scanner = scanner;
    }

    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }

    public void checkInput() {
        while(true) {
            System.out.print("Input command: > ");
            String[] input = scanner.nextLine().split("\\s");
            String badParameters = "Bad parameters!";
            if (!checkInputCommand(input)) {
                System.out.println(badParameters);
                continue;
            }
            if (input[0].equals(Commands.EXIT.getValue())) {
                System.exit(0);
            }
            else if (checkInputPLayers(input[1])) {
                this.setPlayerOne(whoIsPlayer(input[1]));
                String x_SYMBOL = "X";
                playerOne.setMySymbol(x_SYMBOL);
                String o_SYMBOL = "O";
                playerOne.setOpponentSymbol(o_SYMBOL);
                if (checkInputPLayers(input[2])) {
                    this.setPlayerTwo(whoIsPlayer(input[2]));
                    playerTwo.setMySymbol(o_SYMBOL);
                    playerTwo.setOpponentSymbol(x_SYMBOL);
                    break;
                } else {
                    System.out.println(badParameters);
                }
            } else {
                System.out.println(badParameters);
            }
        }
    }

    public boolean checkInputCommand(String[] input) {
        return (input[0].equals(Commands.EXIT.getValue()) || (input[0].equals(Commands.START.getValue())) && (input.length == 3));
    }

    public boolean checkInputPLayers(String s) {
        return Complexity.getComplexity(s) != null;
    }

    public Player whoIsPlayer(String s) {
        Complexity complexity = Complexity.valueOf(s);
        switch (complexity) {
            case EASY -> new EasyPlayer(cells);
            case MEDIUM -> new MediumPlayer(cells);
            case HARD -> new HardPlayer(cells);
            case USER -> new HumanPlayer(scanner, cells);
        }
        return null;
    }
}
