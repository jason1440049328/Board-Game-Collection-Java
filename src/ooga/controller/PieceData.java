package ooga.controller;

public class PieceData {

  private final String pieceId;
  private final int playerNumber;
  private final int i;
  private final int j;

  public PieceData(String pieceId, int playerNumber, int i, int j) {
    this.pieceId = pieceId; //pieceId == empty if not wanted to be highlighted
    this.playerNumber = playerNumber;
    this.i = i;
    this.j = j;
  }

  public String getPieceId() {
    return pieceId;
  }

  public int getPlayerNumber() {
    return playerNumber;
  }

  public int getI() {
    return i;
  }

  public int getJ() {
    return j;
  }
}
