package cs3500.marblesolitaire.model.hw02;

/**
 * mock model for testing controller.
 */
public class MockModel implements MarbleSolitaireModel {
  final StringBuilder log;

  MockModel(StringBuilder log) {
    this.log = log;
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    log.append(fromRow + " " + fromCol + " " + toRow + " " + toCol);
  }

  @Override
  public boolean isGameOver() {
    return false;
  }

  @Override
  public int getBoardSize() {
    return 0;
  }

  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    log.append(row + " " + col);
    return null;
  }

  @Override
  public int getScore() {
    return 0;
  }
}
