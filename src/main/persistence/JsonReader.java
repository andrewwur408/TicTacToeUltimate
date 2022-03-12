package persistence;

import exceptions.CorruptedSaveException;
import model.*;
import org.json.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// Represents a reader that reads TicTacToeClassic/TicTacToeUltimate games from JSON data stored in file
public class JsonReader {
    private final String saveLocation;

    public JsonReader(String saveLocation) {
        this.saveLocation = saveLocation;
    }

    // MODIFIES: this
    // EFFECTS: reads the json file and run resumes the game of either TicTacToeClassic or TicTacToeUltimate
    // throws CorruptedSaveException if jsonArray.get(0) is not "TicTacToeClassic" or "TicTacToeUltimate"
    public Data read() throws IOException, CorruptedSaveException {
        String jsonData = readFile(saveLocation);
        JSONArray jsonArray = new JSONArray(jsonData);
        if (jsonArray.get(0).equals("TicTacToeClassic")) {
            jsonArray.remove(0);
            return resumeTicTacToeClassic(jsonArray);
        } else if (jsonArray.get(0).equals("TicTacToeUltimate")) {
            jsonArray.remove(0);
            return resumeTicTacToeUltimate(jsonArray);
        } else {
            throw new CorruptedSaveException();
        }
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            //noinspection Convert2MethodRef
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // MODIFIES: this
    // EFFECTS: resumes the TicTacToeClassic game with saved json data
    // throws CorruptedSaveException if jsonArray is not at length of 9
    // or if any elements of jsonArray are not one of: ".", "X", "O"
    @SuppressWarnings({"checkstyle:LineLength", "checkstyle:SuppressWarnings"})
    private Data resumeTicTacToeClassic(JSONArray jsonArray) throws CorruptedSaveException {
        List<String> grid = new ArrayList<>();
        boolean player1Turn = toBoolean(jsonArray.get(0).toString());
        jsonArray.remove(0);
        if (jsonArray.length() != 9) {
            throw new CorruptedSaveException();
        }
        for (int i = 0; i <= 8; i++) {
            if (!Arrays.asList(".", "X", "O").contains(jsonArray.get(i).toString())) {
                throw new CorruptedSaveException();
            }
            grid.add(jsonArray.get(i).toString());
        }
        return (new Data(true, new Grid(grid), player1Turn));
    }

    // MODIFIES: this
    // EFFECTS: resumes the TicTacToeUltimate game with saved json data
    // throws CorruptedSaveException if jsonArray is not at length of 81
    // or if any elements of jsonArray are not one of: ".", "X", "O"
    @SuppressWarnings({"checkstyle:LineLength", "checkstyle:SuppressWarnings", "checkstyle:MethodLength"})
    private Data resumeTicTacToeUltimate(JSONArray jsonArray) throws CorruptedSaveException {
        List<Grid> gridList = new ArrayList<>();
        List<String> grid = new ArrayList<>();
        @SuppressWarnings("rawtypes") List<List> gridListList = new ArrayList<>();
        Grid bigGrid = new Grid(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", "."));
        boolean player1Turn = toBoolean(jsonArray.get(0).toString());
        jsonArray.remove(0);
        if (jsonArray.length() != 81) {
            throw new CorruptedSaveException();
        }
        for (int i = 0; i <= 8; i++) {
            for (int j = i * 9; j <= 8 + i * 9; j++) {
                if (!Arrays.asList(".", "X", "O").contains(jsonArray.get(j).toString())) {
                    throw new CorruptedSaveException();
                }
                grid.add(jsonArray.get(j).toString());
            }
            //noinspection rawtypes,unchecked
            gridListList.add(new ArrayList(grid));
            grid.clear();
        }

        for (int i = 0; i <= 8; i++) {
            //noinspection unchecked
            gridList.add(new Grid(gridListList.get(i)));
        }
        return (new Data(false, new BigGrid(bigGrid, gridList), player1Turn));
    }

    // EFFECTS: returns true if given "true" false if given "false"
    // throws CorruptedSaveException if given anything else
    private boolean toBoolean(String string) throws CorruptedSaveException {
        if (string.equals("true")) {
            return true;
        } else if (string.equals("false")) {
            return false;
        } else {
            throw new CorruptedSaveException();
        }
    }
}
