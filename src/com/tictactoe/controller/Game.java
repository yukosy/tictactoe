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

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void proceed() {
        while (true) {
            Input input = new Input(scanner);
            input.checkInput();
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
}
