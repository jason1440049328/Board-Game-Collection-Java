public interface GameAPI {
  private BoardStructure currBoard;
  private List<Players> myPlayers;
  private Player currPlayer;
  GameType myGameType;

  public void gameConstructor(BoardStructure currBoard, List<Players> players, GameType gameType);
  public GameStatus getGameStatus(); //call gameType.getGameStatus(), GameStatus is enumerated type
  public void gotUserInput(int i, int j);
  public void playerCurrentPlayerTurn();
  private void updateToNextPlayersTurn();


  /*
  currentPlayerListIndex = 0 at start;
  In Game Class Constructor hold Player currPlayerTurn = player.get(currentPlayerListIndex);
   */


  /*
  controller.addPlayer()
  set of players in empty
  controller.addHuman("name") -> add new human player
  reflection in controller -> find gameType using string
  */


}
