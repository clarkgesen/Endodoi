import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class EndodoiTest {
    @Test
    public void drawBoard1(){
        PrintStream stdout = System.out;
        ByteArrayOutputStream output = new
                ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        String expected = " +====++==++----+----+\n" +
                "1|(  )||  ||(  )|(  )|\n" +
                " | st ||  ||  a |  b |\n" +
                " +====++==++----+----+\n" +
                "2|(  )||  ||(  )|(  )|\n" +
                " | st ||  ||  c |  d |\n" +
                " +====++==++----+----+\n";

        int [][] pits = { {0,0},{0,0}};
        Endodoi.drawBoard(pits, 0, 0, '!', -1);
        String actual = output.toString().replaceAll("\r","");
        System.setOut(stdout);
        assertEquals(expected, actual);
    }
    @Test
    public void drawBoard() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream output = new
                ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        String expected =
                " +====++==++\n" +
                        "1|(  )||  ||\n" +
                        " | st ||  ||\n" +
                        " +====++==++\n" +
                        "2|(  )||  ||\n" +
                        " | st ||  ||\n" +
                        " +====++==++\n";

        int [][] pits = { {},{}};
        Endodoi.drawBoard(pits, 0, 0, '!', -1);
        String actual = output.toString().replaceAll("\r","");
        System.setOut(stdout);
        assertEquals(expected, actual);
    }
    @Test
    public void pit2Coordinates1() {
        int [] expectedCoordinates = new int[] { 0,1};
        int [] actualCoordinates =  Endodoi.pit2Coordinates('b',
                new int[][]{{0,0},{0,0} });
        assertArrayEquals(expectedCoordinates,actualCoordinates);
    }
    @Test
    public void pit2Coordinates() {
        int [] expectedCoordinates = new int[] { 0,2};
        int [] actualCoordinates =  Endodoi.pit2Coordinates('c',
                new int[][]{{0,0,0,0,0,0},{0,0,0,0,0,0} });
        assertArrayEquals(expectedCoordinates,actualCoordinates);
    }
    @Test
    public void getOpposingPit1() {
        char expected = 'd';
        char actual = Endodoi.getOpposingPit('b', new int[][]{{0, 0},
                {0, 0}});
        assertEquals(expected, actual);
    }
    @Test
    public void getOpposingPit() {
        char expected = 'd';
        char actual = Endodoi.getOpposingPit('b', new int[][]{{0, 0},
                {0, 0}});
        assertEquals(expected, actual);
    }
    @Test
    public void isPitInPlayerRow() {
        boolean expected = true;
        boolean actual = Endodoi.isPitInPlayerRow(1,'a', new int[][]{{0, 0}, {0, 0}});
        assertEquals(expected, actual);
    }
    @Test
    public void isPitInPlayerRow1() {
        boolean expected = false;
        boolean actual = Endodoi.isPitInPlayerRow(1,'h', new int[][]{{0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}});
        assertEquals(expected, actual);
    }
    @Test
    public void nextPit() {
        char expected = 'f';
        char actual = Endodoi.nextPit('e', new int[][]{{0, 0, 0}, {0, 0, 0}});
        assertEquals(expected, actual);
    }
    @Test
    public void nextPit1() {
        char expected = 'i';
        char actual = Endodoi.nextPit('a', new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}});
        assertEquals(expected, actual);
    }

    @Test
    public void getPitSeedCount() {
        int expected = 1;
        int actual = Endodoi.getPitSeedCount('a', new int[][]{{1, 0}, {0, 0}});
        assertEquals(expected, actual);
    }

    @Test
    public void checkEndGame() {
        boolean expected = false;
        boolean actual = Endodoi.checkEndGame(new int[][]{{0,0,0}, {1, 1, 1}}, false);
        assertEquals(expected, actual);
    }

    @Test
    public void totalSeedsOnBoard() {
        int expected = 15;
        int actual = Endodoi.totalSeedsOnBoard(new int[][]{{3, 3, 3,}, {3, 3, 0}});
        assertEquals(expected, actual);
    }

}