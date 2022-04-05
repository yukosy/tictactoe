import com.tictactoe.entity.Cells;
import com.tictactoe.entity.HumanPlayer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class HumanPlayerTest {

    Cells cells = new Cells();
    Scanner scanner = new Scanner(System.in);
    HumanPlayer player = new HumanPlayer(scanner, cells);

    @Test
    public void checkCoordinates() {
        String input = "1 1";

        int[] expected = player.checkCoordinates(input);
        int[] actual = new int[]{1,1};

        Assertions.assertEquals(expected[0], actual[0]);
        Assertions.assertEquals(expected[1], actual[1]);
    }

}