package com.tictactoe.controller;

import com.tictactoe.entity.EasyPlayer;
import com.tictactoe.entity.HardPlayer;
import com.tictactoe.entity.HumanPlayer;
import com.tictactoe.entity.MediumPlayer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;


class InputTest {
    Scanner scanner = new Scanner(System.in);
    Input input = new Input(scanner);

    @Test
    public void whoIsPlayer_EASY() {
        Assertions.assertEquals(EasyPlayer.class, input.whoIsPlayer("easy").getClass());
    }

    @Test
    public void whoIsPlayer_MEDIUM() {
        Assertions.assertEquals(MediumPlayer.class, input.whoIsPlayer("medium").getClass());
    }

    @Test
    public void whoIsPlayer_HARD() {
        Assertions.assertEquals(HardPlayer.class, input.whoIsPlayer("hard").getClass());
    }

    @Test
    public void whoIsPlayer_HUMAN() {
        Assertions.assertEquals(HumanPlayer.class, input.whoIsPlayer("user").getClass());
    }

}