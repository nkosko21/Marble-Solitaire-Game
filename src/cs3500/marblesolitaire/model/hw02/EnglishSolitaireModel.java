package cs3500.marblesolitaire.model.hw02;

import cs3500.marblesolitaire.model.hw04.SolitaireAbstract;

/**
 * a represtation English Solitaire Model.
 */
public class EnglishSolitaireModel extends SolitaireAbstract {

  /**
   * Creates an englishSolitaireModel with arm thickness 3 and an empty space at 3, 3.
   *
   */
  public EnglishSolitaireModel() { // Constructor 1
    super();
  }


  /**
   * Creates an englishSolitaireModel with arm thickness 3 and an empty space at sRow, sCol.
   */
  public EnglishSolitaireModel(int sRow, int sCol) { // Constructor 2
    this.armThickness = 3;
    this.horizontalVertical = new SlotState[7][7];

    if (isInvalid(this.armThickness, sRow, sCol)) {
      throw new IllegalArgumentException("Invalid empty cell position (" + sRow + "," + sCol + ")");
    }

    initiateBoard(sRow, sCol);

    if (this.isGameOver()) {
      throw new IllegalArgumentException("No Possible Moves"); }
  }


  /**
   * Creates an englishSolitaireModel with an inputted arm thickness and empty space in the center.
   */
  public EnglishSolitaireModel(int armThickness) { // Constructor 3
    super();
    if (armThickness % 2 == 0 || armThickness <= 0) {
      throw new IllegalArgumentException("Arm Thickness is negative or Even"); }

    this.armThickness = armThickness;
    this.horizontalVertical =
            new SlotState[(this.armThickness * 3) - 2][(this.armThickness * 3) - 2];

    initiateBoard(horizontalVertical.length / 2, horizontalVertical.length / 2);
  }


  /**
   * Creates an englishSolitaireModel with an inputted arm thickness.
   * and empty space at sRow, sCol.
   */
  public EnglishSolitaireModel(int armThickness, int sRow, int sCol) { // Constructor 4
    if (armThickness % 2 == 0 || armThickness <= 0) {
      throw new IllegalArgumentException("Arm Thickness is negative or odd"); }
    this.armThickness = armThickness;
    this.horizontalVertical =
            new SlotState[(this.armThickness * 3) - 2][(this.armThickness * 3) - 2];

    if (isInvalid(this.armThickness, sRow, sCol)) {
      throw new IllegalArgumentException("Invalid empty cell position (" + sRow + "," + sCol + ")");
    }

    initiateBoard(sRow, sCol);

    if (this.isGameOver()) {
      throw new IllegalArgumentException("No Possible Moves"); }
  }

  /**
   * initializes the board with Invalids, emptys and Marbles.
   * @param sRow the row of the empty space.
   * @param sCol the column of the empty space.
   */
  protected void initiateBoard(int sRow, int sCol) {
    for (int horCount = 0; horCount < this.horizontalVertical.length; horCount++) {
      for (int vertCount = 0; vertCount < this.horizontalVertical.length; vertCount++) {
        if (horCount == sRow && vertCount == sCol) {
          horizontalVertical[horCount][vertCount] = SlotState.Empty; }
        else if (isInvalid(this.armThickness, horCount, vertCount)) {
          horizontalVertical[horCount][vertCount] = SlotState.Invalid; }
        else {
          horizontalVertical[horCount][vertCount] = SlotState.Marble; }
      }
    }
  }

  /**
   * returns if the given sRow and sCol are in a valid space.
   * @param armThickness the given arm thickness.
   * @param row the given row.
   * @param col the given column.
   * @return true or false based on if the space is valid.
   */
  public boolean isInvalid(int armThickness, int row, int col) { //3, 0, 3
    return ((col < armThickness - 1
            && row < armThickness - 1) // top left
            || (col < armThickness - 1
            && row >= this.horizontalVertical.length - (armThickness - 1)) // top right
            || (col >= this.horizontalVertical.length - (armThickness - 1)
            && row >= this.horizontalVertical.length - (armThickness - 1)) // bottom right
            || (col >= this.horizontalVertical.length - (armThickness - 1)
            && row < armThickness - 1));  // bottom left
  }
}