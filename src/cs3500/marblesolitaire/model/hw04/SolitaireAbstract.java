package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * the main abstract model for a solitaire game.
 */
public abstract class SolitaireAbstract implements MarbleSolitaireModel {
  protected int armThickness;
  protected SlotState[][] horizontalVertical;

  protected SolitaireAbstract() {
    this.armThickness = 3;
    this.horizontalVertical = new SlotState[7][7];
    this.initiateBoard(3, 3);
  }

  protected abstract void initiateBoard(int row, int col);

  /**
   * moves the marble.
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   * @throws IllegalArgumentException if there is an invalid from or to position,
   *                there is a marble in the from or to position or if one of the values is negative
   */
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    if (fromRow >= 0 && toRow >= 0 && fromCol >= 0 && toCol >= 0
            && fromRow < this.horizontalVertical.length
            && toRow < this.horizontalVertical.length
            && fromCol < this.horizontalVertical.length
            && toCol < this.horizontalVertical.length) {
      if (horizontalVertical[fromRow][fromCol].equals(SlotState.Invalid)) {
        throw new IllegalArgumentException("Invalid From position");
      } else if (horizontalVertical[toRow][toCol].equals(SlotState.Invalid)) {
        throw new IllegalArgumentException("Invalid To position");
      } else if (this.horizontalVertical[fromRow][fromCol].equals(SlotState.Marble)) {
        if (this.horizontalVertical[toRow][toCol].equals(SlotState.Empty)) {
          moveHelper(fromRow, fromCol, toRow, toCol);
        } else {
          throw new IllegalArgumentException("There is a marble in the to position");
        }
      } else {
        throw new IllegalArgumentException("There is a marble in the from position");
      }
    } else {
      throw new IllegalArgumentException("One of the values are negative");
    }
  }

  /**
   * actually moves and changes the board (helps with the move function).
   * @param fromRow the initial row.
   * @param fromCol the initial column.
   * @param toRow the row that the marble will be moved to.
   * @param toCol the column that the marble will be moved to.
   */
  private void moveHelper(int fromRow, int fromCol, int toRow, int toCol) {
    if (fromRow == toRow && Math.abs(toCol - fromCol) == 2
            && this.horizontalVertical[fromRow][fromCol + ((toCol - fromCol) / 2)]
            .equals(SlotState.Marble)) {
      this.horizontalVertical[fromRow][fromCol] = SlotState.Empty;
      this.horizontalVertical[fromRow][fromCol + ((toCol - fromCol) / 2)] = SlotState.Empty;
      this.horizontalVertical[toRow][toCol] = SlotState.Marble;
    } else if (fromCol == toCol && Math.abs(toRow - fromRow) == 2
            && this.horizontalVertical[fromRow + ((toRow - fromRow) / 2)][fromCol]
            .equals(SlotState.Marble)) {
      this.horizontalVertical[fromRow][fromCol] = SlotState.Empty;
      this.horizontalVertical[fromRow + ((toRow - fromRow) / 2)][fromCol] = SlotState.Empty;
      this.horizontalVertical[toRow][toCol] = SlotState.Marble;
    } else {
      throw new IllegalArgumentException("Marbles are too far apart");
    }
  }

  /**
   * gets the score of the MarbleSolitaireGame.
   * @return the score as an int.
   */
  public int getScore() {
    int counter = 0;

    for (int horiz = 0; horiz < horizontalVertical.length; horiz++) {
      for (int vert = 0; vert < horizontalVertical.length; vert++) {
        if (horizontalVertical[horiz][vert].equals(SlotState.Marble)) {
          counter++;
        }
      }
    }
    return counter;
  }

  /**
   * get the slot at the given position.
   * @param row the row of the position sought, starting at 0;
   * @param col the column of the position sought, starting at 0;
   * @return the given slot.
   * @throws IllegalArgumentException is the position is invalid.
   */
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    if (row > this.horizontalVertical.length || col > this.horizontalVertical.length) {
      throw new IllegalArgumentException("Invalid position");
    }

    return horizontalVertical[row][col];
  }

  /**
   * is the game over.
   * @return if the game is over.
   */
  public boolean isGameOver() {
    for (int horiz = 0; horiz < this.horizontalVertical.length; horiz++) {
      for (int vert = 0; vert < this.horizontalVertical.length; vert++) {
        if (horizontalVertical[horiz][vert].equals(SlotState.Marble)) {
          if (vert + 2 < horizontalVertical.length
                  && horizontalVertical[horiz][vert + 1].equals(SlotState.Marble)
                  && horizontalVertical[horiz][vert + 2].equals(SlotState.Empty)) {
            return false; }
          if (vert - 2 >= 0
                  && horizontalVertical[horiz][vert - 1].equals(SlotState.Marble)
                  && horizontalVertical[horiz][vert - 2].equals(SlotState.Empty)) {
            return false; }
          if (horiz + 2 < horizontalVertical.length
                  && horizontalVertical[horiz + 1][vert].equals(SlotState.Marble)
                  && horizontalVertical[horiz + 2][vert].equals(SlotState.Empty)) {
            return false; }
          if (horiz - 2 >= 0
                  && horizontalVertical[horiz - 1][vert].equals(SlotState.Marble)
                  && horizontalVertical[horiz - 2][vert].equals(SlotState.Empty)) {
            return false; }
        }
      }
    }
    return true;
  }

  /**
   * gets the board size.
   * @return the boards size, as an int.
   */
  public int getBoardSize() {
    return this.horizontalVertical.length;
  }
}
