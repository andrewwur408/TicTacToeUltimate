package persistence;

import model.BigGrid;
import model.Grid;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest {
    @Test
    void testWriterInvalidFile(){
        Grid emptyGrid = new Grid(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", "."));
        List<Grid> emptyGridList = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            emptyGridList.add(emptyGrid);
        }
        BigGrid bigGrid = new BigGrid(emptyGrid, emptyGridList);

        try {
            new JsonWriter("./data/my\0illegal:fileName.json", bigGrid, true);
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }

        try {
            new JsonWriter("./data/my\0illegal:fileName.json", emptyGrid, true);
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterValidFile() {
        Grid emptyGrid = new Grid(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", "."));
        List<Grid> emptyGridList = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            emptyGridList.add(emptyGrid);
        }
        BigGrid bigGrid = new BigGrid(emptyGrid, emptyGridList);

        try {
            new JsonWriter("./data/gameSave.json", bigGrid, true);
            // pass
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }

        try {
            new JsonWriter("./data/gameSave.json", emptyGrid, true);
            // pass
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
