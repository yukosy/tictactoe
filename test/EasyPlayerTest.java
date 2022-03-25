import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

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

        Assert.assertEquals(min, 1);
        Assert.assertEquals(max, 3);
    }

    @Test
    public void setSymbol() {
        Cells expected = new Cells();
        Cells actual = new Cells();

        Player player = new EasyPlayer(expected);
        player.setMySymbol("X");

        player.setSymbol(new int[]{1,1});

        actual.setValue(1,1,"X");

        assertEquals(expected.getValue(1,1), actual.getValue(1,1));
    }
}