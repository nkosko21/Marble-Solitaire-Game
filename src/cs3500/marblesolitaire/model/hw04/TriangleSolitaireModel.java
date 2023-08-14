package cs3500.marblesolitaire.model.hw04;

/**
 * a triangular solitaire game.
 */
public class TriangleSolitaireModel extends SolitaireAbstract {

  /**
   * a triangular solitaire game.
   */
  public TriangleSolitaireModel() {
    armThickness = 5;
    horizontalVertical = new SlotState[5][5];
    this.initiateBoard(0, 0);
  }

  /**
   * a triangular solitaire game.
   * @param armThickness the thickness of the side arm.
   */
  public TriangleSolitaireModel(int armThickness) {
    if (armThickness <= 0) {
      throw new IllegalArgumentException("Arm thickness is less than or equal to zero");
    }

    horizontalVertical = new SlotState[armThickness][armThickness];
    this.armThickness = armThickness;
    this.initiateBoard(0, 0);
  }

  /**
   * a triangular solitaire game.
   * @param row the row of the empty position.
   * @param col the column of the empty position.
   */
  public TriangleSolitaireModel(int row, int col) {
    if (col > row || row > 5 || col > 5 || row < 0 || col < 0) {
      throw new IllegalArgumentException("Invalid position");
    }

    horizontalVertical = new SlotState[5][5];
    this.armThickness = 5;
    this.initiateBoard(row, col);
  }

  /**
   * a triangular solitaire game.
   * @param armThickness the thickness of the side arm.
   * @param row the row of the empty space.
   * @param col the column of the empty space.
   */
  public TriangleSolitaireModel(int armThickness, int row, int col) {
    if (armThickness <= 0) {
      throw new IllegalArgumentException("Arm thickness is less than or equal to zero");
    }
    if (col > row || row > armThickness || col > armThickness || row < 0 || col < 0) {
      throw new IllegalArgumentException("Invalid position");
    }

    horizontalVertical = new SlotState[armThickness][armThickness];
    this.armThickness = armThickness;
    this.initiateBoard(row, col);
  }

  protected void initiateBoard(int row, int col) {
    for (int horizontal = 0; horizontal < this.armThickness; horizontal++) {
      for (int vertical = 0; vertical < this.armThickness; vertical++) {
        if (vertical > horizontal) {
          horizontalVertical[horizontal][vertical] = SlotState.Invalid;
        }
        else if (horizontal == row && vertical == col) {
          horizontalVertical[horizontal][vertical] = SlotState.Empty;
        } else {
          horizontalVertical[horizontal][vertical] = SlotState.Marble;
        }
      }
    }
  }


  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    int isValidValue = isValid(fromRow, fromCol, toRow, toCol);

    if (isValidValue == -1) {
      throw new IllegalArgumentException("Invalid move: Outside of board");
    }
    if (isValidValue == 0) {
      throw new IllegalArgumentException("Invalid move: impossible move");
    } else if (isValidValue == 1) { // |
      int changeRate = (toCol - fromCol) / 2;

      horizontalVertical[fromRow][fromCol] = SlotState.Empty;
      horizontalVertical[fromRow][fromCol + changeRate] = SlotState.Empty;
      horizontalVertical[toRow][toCol] = SlotState.Marble;
    } else if (isValidValue == 2) { // -
      int changeRate = (toRow - fromRow) / 2;

      horizontalVertical[fromRow][fromCol] = SlotState.Empty;
      horizontalVertical[fromRow + changeRate][fromCol] = SlotState.Empty;
      horizontalVertical[toRow][toCol] = SlotState.Marble;
    } else if (isValidValue == 3) { // \
      int changeRate = (toRow - fromRow) / 2; // this might be wrong

      horizontalVertical[fromRow][fromCol] = SlotState.Empty;
      horizontalVertical[fromRow + changeRate][fromCol + changeRate] = SlotState.Empty;
      horizontalVertical[toRow][toCol] = SlotState.Marble;
    }
  }

  @Override
  public boolean isGameOver() {
    for (int horizontal = 0; horizontal < horizontalVertical.length; horizontal++) {
      for (int vertical = 0; vertical < horizontalVertical.length; vertical++) {
        if (isValid(horizontal, vertical, horizontal + 2, vertical) > 0 // |
                || isValid(horizontal, vertical, horizontal - 2, vertical) > 0 // |
                || isValid(horizontal, vertical, horizontal, vertical + 2) > 0 // -
                || isValid(horizontal, vertical, horizontal, vertical - 2) > 0  // \
                || isValid(horizontal, vertical, horizontal + 2, vertical + 2) > 0
                || isValid(horizontal, vertical, horizontal - 2, vertical - 2) > 0) {
          return false;
        }
      }
    }

    return true;
  }

  /**
   * returns if the move is valid.
   * @param fromRow the starting row.
   * @param fromCol the starting column.
   * @param toRow the ending row.
   * @param toCol the ending column
   * @return 0 if invalid, 1 if 90 ( | ) move is possible, 2 if 180 ( - ) move is
   *         possible, and 3 if 135 ( \ ) move is possible.
   */
  private int isValid(int fromRow, int fromCol, int toRow, int toCol) {
    TriangleMoveHelper helper = new TriangleMoveHelper();

    if (fromCol > fromRow || fromRow > armThickness || fromCol > armThickness
            || fromRow < 0 || fromCol < 0 || toCol > toRow || toRow > armThickness
            || toCol > armThickness || toRow < 0 || toCol < 0) {
      return -1;
    }

    if (fromRow == toRow && Math.abs(fromCol - toCol) == 2                   //   |
            && helper.oneEightyMove(fromRow, fromCol, toRow, toCol, this.horizontalVertical)) {
      return 1;
    } else if (fromCol == toCol && Math.abs(fromRow - toRow) == 2                  //   -
            && helper.ninetyMove(fromRow, fromCol, toRow, toCol, this.horizontalVertical)) {
      return 2;
    } else if (Math.abs(fromRow - toRow) == 2 && Math.abs(fromCol - toCol) == 2     //    \
            && helper.oneThirtyFiveMove(fromRow, fromCol, toRow, toCol, this.horizontalVertical)) {
      return 3;
    }

    return 0;
  }
}
