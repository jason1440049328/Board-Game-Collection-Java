package ooga.controller;

import java.util.ArrayList;
import java.util.List;
import ooga.model.PossibleMove;

public class PossibleMoveList {

  List<PossibleMove> possibleMoves = new ArrayList<>();

  public void addPossibleMoves(List<PossibleMove> possibleMoves) {
    this.possibleMoves.addAll(possibleMoves);
  }

  public int getNumOfPossibleMoves() {
    return possibleMoves.size();
  }

  public List<PossibleMove> getPossibleMoves() {
    return possibleMoves;
  }
}
