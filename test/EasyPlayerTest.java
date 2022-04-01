import com.tictactoe.entity.Cells;
import com.tictactoe.entity.EasyPlayer;
import com.tictactoe.entity.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class EasyPlayerTest {

    @Test
    public void getRandomCoordinates() {
        Cells cells = new Cells();
        Player player = new EasyPlayer(cells);

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