package model;

// player data, also help with receiving player input
public class Player {
    private final String playerName;
    private final String playerSymbol;

    public Player(String playerName, String playerSymbol) {
        this.playerName = playerName;
        this.playerSymbol = playerSymbol;
        EventLog.getInstance().logEvent(new Event(playerName + " with symbol: " + playerSymbol + " created"));
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPlayerSymbol() {
        return playerSymbol;
    }

}
