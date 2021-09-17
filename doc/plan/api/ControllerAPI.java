import java.io.File;

public interface ControllerAPI {
  private Game myGame;
  private BoardStructure currBoard;
  private GameType gameType;
  private DataReader dataReader;
  private List<Players> players;

  public void step(); //runs all of our step methods each game tick
  public void findGameType(String gameType); //finds gametype using reflection
  public void addNewPlayerToGame(String playerName, String playerType); //adds new player to list using reflection
  public void createNewGame(); //this is called from the view when game is ready to be loaded -> creates new game instance
  // Calls(dataReader.loadGame(fileName, players). Filename is default based on gameType.
  public void loadInGame(File gameFile); //let the dataAPI read in this file and parse the data
  public void saveCurrentGame(); //save current model structure in csv
  public void createNewGameBoard();
  public GameDataImmutableInterface getGameData(); //Called from dataReader.getGameData()
}


//controller has all methods that grab from model
//In main view -> Controller myController = new Controller();
//If you want data from the model in the view -> controller.getGameType();