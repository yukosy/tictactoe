import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MediumPlayerTest {

    Cells cells = new Cells();
    MediumPlayer player = new MediumPlayer(cells);

    @Test
    public void canWinNextStep() {

        cells.setValue(1,1, "X");
        cells.setValue(1,2, "X");

        int[] expected = player.canWinNextStep("X");
        int[] actual = new int[]{1,3};

        Assert.assertEquals(expected[0], actual[0]);
        Assert.assertEquals(expected[1], actual[1]);
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

        Assert.assertEquals(min, 1);
        Assert.assertEquals(max, 3);
    }


    @Test
    public void setSymbol() {
        Cells expected = new Cells();
        Cells actual = new Cells();

        Player player = new MediumPlayer(expected);
        player.setMySymbol("X");

        player.setSymbol(new int[]{1,1});

        actual.setValue(1,1,"X");

        assertEquals(expected.getValue(1,1), actual.getValue(1,1));
    }
}