import com.tictactoe.entity.Cells;
import com.tictactoe.entity.HardPlayer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


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
        Assertions.assertEquals(coords[0],1);
        Assertions.assertEquals(coords[1],3);


    }

}