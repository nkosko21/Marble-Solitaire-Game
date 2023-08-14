package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * helper functions for TriangleSolitaireModel.
 */
public class TriangleMoveHelper {
  TriangleMoveHelper() {
    // VOID
  }

  /**
   * returns true if the 90 ( | ) degree move is possible.
   * @param fromRow the initial row.
   * @param fromCol the initial column.
   * @param toRow the end row.
   * @param toCol the end column.
   * @return if the move is possible.
   */
  boolean ninetyMove(int fromRow, int fromCol, int toRow, int toCol,
                     MarbleSolitaireModelState.SlotState[][] horizontalVertical) {
    int changeRate = (toRow - fromRow) / 2;

    return horizontalVertical[fromRow][fromCol]
            .equals(MarbleSolitaireModelState.SlotState.Marble)
            && horizontalVertical[toRow][toCol]
            .equals(MarbleSolitaireModelState.SlotState.Empty)
            && horizontalVertical[fromRow + changeRate][fromCol]
            .equals(MarbleSolitaireModelState.SlotState.Marble);
  }

  /**
   * returns true if the 180 ( - ) degree move is possible.
   * @param fromRow the initial row.
   * @param fromCol the initial column.
   * @param toRow the end row.
   * @param toCol the end column.
   * @return if the move is possible.
   */
  boolean oneEightyMove(int fromRow, int fromCol, int toRow, int toCol,
                        MarbleSolitaireModelState.SlotState[][] horizontalVertical) {
    int changeRate = (toCol - fromCol) / 2;

    return horizontalVertical[fromRow][fromCol]
            .equals(MarbleSolitaireModelState.SlotState.Marble)
            && horizontalVertical[toRow][toCol]
            .equals(MarbleSolitaireModelState.SlotState.Empty)
            && horizontalVertical[fromRow][fromCol + changeRate]
            .equals(MarbleSolitaireModelState.SlotState.Marble);
  }

  /**
   * returns true if the 135 ( \ ) degree move is possible.
   * @param fromRow the initial row.
   * @param fromCol the initial column.
   * @param toRow the end row.
   * @param toCol the end column.
   * @return if the move is possible.
   */
  boolean oneThirtyFiveMove(int fromRow, int fromCol, int toRow, int toCol,
                            MarbleSolitaireModelState.SlotState[][] horizontalVertical) {
    int changeRate = (toRow - fromRow) / 2; // this might be wrong

    return horizontalVertical[fromRow][fromCol]
            .equals(MarbleSolitaireModelState.SlotState.Marble)
            && horizontalVertical[toRow][toCol]
            .equals(MarbleSolitaireModelState.SlotState.Empty)
            && horizontalVertical[fromRow + changeRate][fromCol + changeRate]
            .equals(MarbleSolitaireModelState.SlotState.Marble);
  }
}
