import com.tictactoe.entity.Cells;
import com.tictactoe.entity.MediumPlayer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MediumPlayerTest {

    Cells cells = new Cells();
    MediumPlayer player = new MediumPlayer(cells);

    @Test
    public void canWinNextStep() {

        cells.setValue(1,1, "X");
        cells.setValue(1,2, "X");

        int[] expected = player.canWinNextStep("X");
        int[] actual = new int[]{1,3};

        Assertions.assertEquals(expected[0], actual[0]);
        Assertions.assertEquals(expected[1], actual[1]);
    }

    @Test
    public void getRandomCoordinates() {
        int min = 2;
        int max = 2;

        for(int i = 0;i < 10000; i++) {
            int[] expected = player.getCoordinates(cells);
            if(expected[0] > max) {
                max = expected[0];
            }
            if(expected[0] < min) {
                min = expected[0];
            }
            if(expected[1] > max) {
                max = expected[1];
            }
            if(expected[1] < min) {
                min = expected[1];
            }
        }

        Assertions.assertEquals(min, 1);
        Assertions.assertEquals(max, 3);
    }
}