package com.tictactoe;

import com.tictactoe.controller.Game;
import com.tictactoe.entity.Cells;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cells cell = new Cells();
        Scanner scanner = new Scanner(System.in);

        Game game = new Game(cell, scanner);
        game.proceed();
    }
}
