package persistence;

import model.*;
import org.json.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

// a writer that writes JSON representation of TicTacToeClassic and TicTacToeUltimate
public class JsonWriter {

    @SuppressWarnings({"FieldCanBeLocal", "checkstyle:SuppressWarnings"})
    private PrintWriter writer;
    private final String saveLocation;

    // JsonWrite built for TicTacToeClassic
    public JsonWriter(String saveLocation, Grid grid, Boolean player1Turn) throws IOException {
        this.saveLocation = saveLocation;
        JSONArray jsonArray = new JSONArray();
        jsonArray.put("TicTacToeClassic");
        jsonArray.put(player1Turn.toString());
        for (String slot : grid.getGrid()) {
            jsonArray.put(slot);
        }
        saveToFile(jsonArray);
    }

    // JsonWrite built for TicTacToeUltimate
    public JsonWriter(String saveLocation, BigGrid bigGrid, Boolean player1Turn) throws IOException {
        this.saveLocation = saveLocation;
        JSONArray jsonArray = new JSONArray();

        jsonArray.put("TicTacToeUltimate");
        jsonArray.put(player1Turn.toString());
        for (Grid grid : bigGrid.getGridList()) {
            for (String slot : grid.getGrid()) {
                jsonArray.put(slot);
            }
        }
        saveToFile(jsonArray);
    }
    // todo add exception to effects

    // MODIFIES: this
    // EFFECTS: opens writer, writes string to file, closes writer;
    // throws FileNotFoundException if destination file cannot be found
    private void saveToFile(JSONArray jsonArray) throws IOException {
        isValidFilePath();
        writer = new PrintWriter(saveLocation);
        writer.print(jsonArray);
        writer.close();
    }

    // EFFECTS: throws IOException if the given destination contains invalid symbols
    private void isValidFilePath() throws IOException {
        File file = new File(saveLocation);
        //noinspection ResultOfMethodCallIgnored
        file.getCanonicalPath();
    }
}
