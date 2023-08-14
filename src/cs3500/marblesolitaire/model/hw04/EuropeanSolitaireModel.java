package cs3500.marblesolitaire.model.hw04;

public class EuropeanSolitaireModel extends SolitaireAbstract {

  /**
   * an octoganal marble solitaire game.
   */
  public EuropeanSolitaireModel() {
    this.armThickness = 3;
    horizontalVertical = new SlotState[7][7];
    initiateBoard(3, 3);
  }

  /**
   * an octogonal solitaire game.
   * @param armThickness how thick the arm is.
   */
  public EuropeanSolitaireModel(int armThickness) {
    if (armThickness <= 0) {
      throw new IllegalArgumentException("Arm thickness is less than or equal to zero");
    }

    this.armThickness = armThickness;
    horizontalVertical = new SlotState[(this.armThickness * 3) - 2][(this.armThickness * 3) - 2];
    initiateBoard(horizontalVertical.length / 2,
            horizontalVertical.length / 2);
  }

  /**
   * an octogonal solitaire game.
   * @param row the row of the empty space.
   * @param col the column of the empty space.
   */
  public EuropeanSolitaireModel(int row, int col) {
    if (row > horizontalVertical.length || col > horizontalVertical.length || isInvalid(row, col)) {
      throw new IllegalArgumentException("Invalid position");
    }

    this.armThickness = 3;
    horizontalVertical = new SlotState[7][7];
    initiateBoard(row, col);
  }

  /**
   * an octogonal solitaire game.
   * @param armThickness the thickness of the side arm.
   * @param row the row of the empty space.
   * @param col the col of the empty space.
   */
  public EuropeanSolitaireModel(int armThickness, int row, int col) {
    this.armThickness = armThickness;

    if (row > horizontalVertical.length || col > horizontalVertical.length || isInvalid(row, col)) {
      throw new IllegalArgumentException("Invalid position");
    }
    if (armThickness <= 0) {
      throw new IllegalArgumentException("Arm thickness is less than or equal to zero");
    }

    horizontalVertical = new SlotState[(this.armThickness * 3) - 2][(this.armThickness * 3) - 2];
    initiateBoard(row, col);
  }

  protected void initiateBoard(int row, int col) {

    for (int horizontal = 0; horizontal < horizontalVertical.length; horizontal++) {
      for (int vertical = 0; vertical < horizontalVertical.length; vertical++) {
        if (horizontal == row && vertical == col) {
          horizontalVertical[horizontal][vertical] = SlotState.Empty;
        }
        else if (isInvalid(horizontal, vertical)) {
          horizontalVertical[horizontal][vertical] = SlotState.Invalid;
        }
        else {
          horizontalVertical[horizontal][vertical] = SlotState.Marble;
        }
      }
    }
  }


  private boolean isInvalid(int row, int col) {

    if (col < horizontalVertical.length / 2) {
      if (row < horizontalVertical.length / 2) { // top left
        return row < armThickness - 1 - col;
      }
      else {
        return row > horizontalVertical.length - (armThickness - col); //top right
      }
    }
    else {
      if (row < horizontalVertical.length / 2) { // top right
        return col > horizontalVertical.length - 1 - (armThickness - 1 - row);
      }
      else {
        return (horizontalVertical.length - col) + (horizontalVertical.length - row) <= armThickness;
      }
    }
  }
}
