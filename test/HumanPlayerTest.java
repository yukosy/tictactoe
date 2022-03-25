import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class HumanPlayerTest {

    Cells cells = new Cells();
    Scanner scanner = new Scanner(System.in);
    HumanPlayer player = new HumanPlayer(scanner, cells);

    @Test
    public void checkCoordinates() {
        String input = "1 1";

        int[] expected = player.checkCoordinates(input);
        int[] actual = new int[]{1,1};

        Assert.assertEquals(expected[0], actual[0]);
        Assert.assertEquals(expected[1], actual[1]);
    }

    @Test
    public void setSymbol() {
        Cells actual = new Cells();

        player.setMySymbol("X");

        player.setSymbol(new int[]{1,1});

        actual.setValue(1,1,"X");

        assertEquals(cells.getValue(1,1), actual.getValue(1,1));
    }
}