import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class HardPlayerTest {

    @Test
    public void getCoordinates() {
        Cells cells = new Cells();
        HardPlayer player = new HardPlayer(cells);
        player.setMySymbol("O");
        player.setOpponentSymbol("X");

        cells.setValue(1,2,"X");
        cells.setValue(2,3,"X");
        cells.setValue(3,1,"O");
        cells.setValue(3,2,"O");
        cells.setValue(3,3,"X");

        int[] coords = player.getCoordinates(cells);
        Assert.assertEquals(coords[0],1);
        Assert.assertEquals(coords[1],3);


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