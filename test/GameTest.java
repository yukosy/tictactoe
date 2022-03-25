import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class GameTest {
    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    Cells cells = new Cells();
    Scanner scanner = new Scanner(System.in);
    Game game = new Game(cells, scanner);

    @Test
    public void whoIsPlayer_EASY() {
        Assert.assertEquals(EasyPlayer.class, game.whoIsPlayer("easy").getClass());
    }

    @Test
    public void whoIsPlayer_MEDIUM() {
        Assert.assertEquals(MediumPlayer.class, game.whoIsPlayer("medium").getClass());
    }

    @Test
    public void whoIsPlayer_HARD() {
        Assert.assertEquals(HardPlayer.class, game.whoIsPlayer("hard").getClass());
    }

    @Test
    public void whoIsPlayer_HUMAN() {
        Assert.assertEquals(HumanPlayer.class, game.whoIsPlayer("user").getClass());
    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @Test
    public void checkWin_X() {
        cells.setValue(1,1,"X");
        cells.setValue(3,3,"X");
        cells.setValue(2,2,"X");
        game.checkWin();
        Assert.assertEquals("X wins\n", output.toString());
    }

    @Test
    public void checkWin_O() {
        cells.setValue(1,1,"O");
        cells.setValue(3,3,"O");
        cells.setValue(2,2,"O");
        game.checkWin();
        Assert.assertEquals("O wins\n", output.toString());
    }

    @Test
    public void checkWin_DRAW() {
        cells.setValue(1,1,"X");
        cells.setValue(1,2,"O");
        cells.setValue(1,3,"X");
        cells.setValue(2,1,"O");
        cells.setValue(2,2,"X");
        cells.setValue(2,3,"O");
        cells.setValue(3,1,"O");
        cells.setValue(3,2,"X");
        cells.setValue(3,3,"O");
        game.checkWin();
        Assert.assertEquals("Draw\n", output.toString());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
}