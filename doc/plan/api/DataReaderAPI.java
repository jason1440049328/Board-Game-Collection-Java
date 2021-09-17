public interface DataReaderAPI {

  private GameData data; // holds everything (ex: images, etc). implements immutable interface

  public Game loadGame(File fileName);
  public Game loadGame(File fileName, List<Player>players);
  public GameDataImmutableInterface getData();

  private void loadInGameData(); //sets all data instance variable
  private List<String[]> readInCSV();
  private BoardStructure createBoardStructure(List<String[]>); //Called my loadGame fxn
  private List<Player> createPlayerList()

  //Exceptions: size doesn't match size of inputted csv
  //            any vital info missing from the properties file
}
