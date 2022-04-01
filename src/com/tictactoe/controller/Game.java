package com.tictactoe.controller;

import com.tictactoe.entity.*;
import java.util.Scanner;

public class Game {
    private Player playerOne;
    private Player playerTwo;
    private final Cells cells;
    private final Scanner scanner;

    public Game(Cells cells, Scanner scanner) {
        this.cells = cells;
        this.scanner = scanner;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }

    public void proceed() {
        while (true) {
            checkInput();
            while (!playerTwo.checkWin()) {
                getPlayerOne().turn();
                System.out.println(cells);
                if (getPlayerOne().checkWin()) {
                    break;
                }
                getPlayerTwo().turn();
                System.out.println(cells);
            }
        }
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
        return s.equals(Complexity.USER.getValue()) || s.equals(Complexity.EASY.getValue()) ||
                s.equals(Complexity.MEDIUM.getValue()) || s.equals(Complexity.HARD.getValue());
    }

    public Player whoIsPlayer(String s) {
        if(s.equals(Complexity.EASY.getValue())) {
            return new EasyPlayer(cells);
        } else if(s.equals(Complexity.MEDIUM.getValue())) {
            return new MediumPlayer(cells);
        } else if(s.equals(Complexity.HARD.getValue())) {
            return new HardPlayer(cells);
        } else {
            return new HumanPlayer(scanner, cells);
        }
    }
}
