package cs3500.marblesolitaire.model.hw02;

import org.junit.Assert;
import org.junit.Test;

import cs3500.marblesolitaire.view.MarbleSolitaireTextView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/**
 * tests for EnglishSolitaireModel.
 */
public class EnligshSolitaireModelTest {

  @Test
  public void testConstructor1() {
    // test constructor 1
    EnglishSolitaireModel constructor1 = new EnglishSolitaireModel();

    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Empty, constructor1.getSlotAt(3, 3));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Marble, constructor1.getSlotAt(3, 2));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Invalid, constructor1.getSlotAt(0, 0));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Invalid, constructor1.getSlotAt(0, 1));
  }

  @Test
  public void testConstructor2() {
    EnglishSolitaireModel constructor2 = new EnglishSolitaireModel(2, 3);

    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Empty, constructor2.getSlotAt(2, 3));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Marble, constructor2.getSlotAt(3, 3));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Invalid, constructor2.getSlotAt(0, 0));
  }

  @Test
  public void testConstructor3() {
    EnglishSolitaireModel constructor3 = new EnglishSolitaireModel(5);

    assertEquals(MarbleSolitaireModelState.SlotState.Empty, constructor3.getSlotAt(6, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, constructor3.getSlotAt(4, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, constructor3.getSlotAt(0, 0));
  }

  @Test
  public void testConstructor4() {
    // test constructor 4
    EnglishSolitaireModel constructor4 = new EnglishSolitaireModel(5, 4, 4);

    assertEquals(MarbleSolitaireModelState.SlotState.Empty, constructor4.getSlotAt(4, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, constructor4.getSlotAt(5, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, constructor4.getSlotAt(0, 0));

    EnglishSolitaireModel constructor4v2 = new EnglishSolitaireModel(3, 0, 2);
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Empty, constructor4v2.getSlotAt(0, 2));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Marble, constructor4v2.getSlotAt(3, 3));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Invalid,
            constructor4v2.getSlotAt(0, 0));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Invalid,
            constructor4v2.getSlotAt(0, 1));
  }

  // test initiateBoard()

  @Test
  public void testMove() {
    // test move
    EnglishSolitaireModel testMoveNormal = new EnglishSolitaireModel();

    MarbleSolitaireTextView test = new MarbleSolitaireTextView(testMoveNormal);

    // down
    Assert.assertEquals(testMoveNormal.getSlotAt(3, 1), MarbleSolitaireModelState.SlotState.Marble);
    Assert.assertEquals(testMoveNormal.getSlotAt(3, 2), MarbleSolitaireModelState.SlotState.Marble);
    Assert.assertEquals(testMoveNormal.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Empty);
    testMoveNormal.move(3, 1, 3, 3);
    Assert.assertEquals(testMoveNormal.getSlotAt(3, 1), MarbleSolitaireModelState.SlotState.Empty);
    Assert.assertEquals(testMoveNormal.getSlotAt(3, 2), MarbleSolitaireModelState.SlotState.Empty);
    Assert.assertEquals(testMoveNormal.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Marble);

    //up
    Assert.assertEquals(testMoveNormal.getSlotAt(5, 2), MarbleSolitaireModelState.SlotState.Marble);
    Assert.assertEquals(testMoveNormal.getSlotAt(4, 2), MarbleSolitaireModelState.SlotState.Marble);
    Assert.assertEquals(testMoveNormal.getSlotAt(3, 2), MarbleSolitaireModelState.SlotState.Empty);
    testMoveNormal.move(5, 2, 3, 2);
    Assert.assertEquals(testMoveNormal.getSlotAt(5, 2), MarbleSolitaireModelState.SlotState.Empty);
    Assert.assertEquals(testMoveNormal.getSlotAt(4, 2), MarbleSolitaireModelState.SlotState.Empty);
    Assert.assertEquals(testMoveNormal.getSlotAt(3, 2), MarbleSolitaireModelState.SlotState.Marble);

    //left
    Assert.assertEquals(testMoveNormal.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Marble);
    Assert.assertEquals(testMoveNormal.getSlotAt(3, 2), MarbleSolitaireModelState.SlotState.Marble);
    Assert.assertEquals(testMoveNormal.getSlotAt(3, 1), MarbleSolitaireModelState.SlotState.Empty);
    testMoveNormal.move(3, 3, 3, 1);
    Assert.assertEquals(testMoveNormal.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Empty);
    Assert.assertEquals(testMoveNormal.getSlotAt(3, 2), MarbleSolitaireModelState.SlotState.Empty);
    Assert.assertEquals(testMoveNormal.getSlotAt(3, 1), MarbleSolitaireModelState.SlotState.Marble);

    //up
    Assert.assertEquals(testMoveNormal.getSlotAt(5, 3), MarbleSolitaireModelState.SlotState.Marble);
    Assert.assertEquals(testMoveNormal.getSlotAt(4, 3), MarbleSolitaireModelState.SlotState.Marble);
    Assert.assertEquals(testMoveNormal.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Empty);
    testMoveNormal.move(5, 3, 3, 3);
    Assert.assertEquals(testMoveNormal.getSlotAt(5, 3), MarbleSolitaireModelState.SlotState.Empty);
    Assert.assertEquals(testMoveNormal.getSlotAt(4, 3), MarbleSolitaireModelState.SlotState.Empty);
    Assert.assertEquals(testMoveNormal.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Marble);
  }

  /**
   * tests function isGameOver.
   */
  @Test
  public void testIsGameOver() {
    // test isGameOver()

    EnglishSolitaireModel testIsGameOverFalse = new EnglishSolitaireModel();

    Assert.assertEquals(testIsGameOverFalse.isGameOver(), false);

    testIsGameOverFalse.move(3, 5, 3, 3);
    testIsGameOverFalse.move(1, 4, 3, 4);
    testIsGameOverFalse.move(2, 6, 2, 4);
    testIsGameOverFalse.move(4, 6, 2, 6);
    testIsGameOverFalse.move(2, 3, 2, 5);
    testIsGameOverFalse.move(2, 6, 2, 4);
    testIsGameOverFalse.move(2, 1, 2, 3);
    testIsGameOverFalse.move(0, 2, 2, 2);
    testIsGameOverFalse.move(0, 4, 0, 2);
    testIsGameOverFalse.move(3, 2, 1, 2);
    testIsGameOverFalse.move(0, 2, 2, 2);
    testIsGameOverFalse.move(5, 2, 3, 2);
    testIsGameOverFalse.move(4, 0, 4, 2);
    testIsGameOverFalse.move(2, 0, 4, 0);
    testIsGameOverFalse.move(4, 3, 4, 1);
    testIsGameOverFalse.move(4, 0, 4, 2);
    testIsGameOverFalse.move(4, 5, 4, 3);
    testIsGameOverFalse.move(6, 4, 4, 4);
    testIsGameOverFalse.move(6, 2, 6, 4);
    testIsGameOverFalse.move(3, 4, 5, 4);
    testIsGameOverFalse.move(6, 4, 4, 4);
    testIsGameOverFalse.move(3, 2, 1, 2);
    testIsGameOverFalse.move(1, 2, 1, 4);
    testIsGameOverFalse.move(1, 4, 3, 4);
    testIsGameOverFalse.move(3, 4, 5, 4);
    testIsGameOverFalse.move(5, 4, 5, 2);
    testIsGameOverFalse.move(5, 2, 3, 2);
    testIsGameOverFalse.move(3, 3, 1, 3);
    testIsGameOverFalse.move(3, 1, 3, 3);
    testIsGameOverFalse.move(4, 3, 2, 3);
    testIsGameOverFalse.move(1, 3, 3, 3);

    Assert.assertEquals(testIsGameOverFalse.isGameOver(), true);
  }

  @Test
  public void testIllegalArguments() {
    EnglishSolitaireModel testMoveError = new EnglishSolitaireModel();

    assertThrows("Invalid empty cell position (" + 0 + "," + 1 + ")",
            IllegalArgumentException.class, () -> new EnglishSolitaireModel(0, 1));
    assertThrows("Arm Thickness is negative or Even",
            IllegalArgumentException.class, () -> new EnglishSolitaireModel(-1));
    assertThrows("Arm Thickness is negative or Even",
            IllegalArgumentException.class, () -> new EnglishSolitaireModel(2));
    assertThrows("Arm Thickness is negative or Even",
            IllegalArgumentException.class, () -> new EnglishSolitaireModel(-1, 3, 3));
    assertThrows("Arm Thickness is negative or Even",
            IllegalArgumentException.class, () -> new EnglishSolitaireModel(2, 3, 3));
    assertThrows("Invalid empty cell position (" + 0 + "," + 0 + ")",
            IllegalArgumentException.class, () -> new EnglishSolitaireModel(3, 0, 0));
    assertThrows("One of the values are negative",
            IllegalArgumentException.class, () -> new EnglishSolitaireModel(5, 0, 3));
    assertThrows("One of the values are negative",
            IllegalArgumentException.class, () -> testMoveError.move(-1, 2, 2, 8));
    assertThrows("Invalid From position",
            IllegalArgumentException.class, () -> testMoveError.move(0, 0, 3, 3));
    assertThrows("Invalid To position",
            IllegalArgumentException.class, () -> testMoveError.move(3, 3, 0, 0));
    assertThrows("There is no marble there",
            IllegalArgumentException.class, () -> testMoveError.move(3, 3, 5, 3));
    assertThrows("There is a marble in the To position",
            IllegalArgumentException.class, () -> testMoveError.move(3, 5, 3, 7));
    assertThrows("The marbles are too far apart",
            IllegalArgumentException.class, () -> testMoveError.move(4 , 6, 4, 4));
    assertThrows("Invalid From position",
            IllegalArgumentException.class, () -> testMoveError.move(9 , 9, 4, 4));
    assertThrows("Invalid To position",
            IllegalArgumentException.class, () -> testMoveError.move(3 , 3, 9, 9));
  }

  @Test
  public void testIsInvalid() {
    EnglishSolitaireModel constructor1 = new EnglishSolitaireModel();

    Assert.assertEquals(constructor1.isInvalid(3, 0, 0), true);
    Assert.assertEquals(constructor1.isInvalid(3, 0, 2), false);
    Assert.assertEquals(constructor1.isInvalid(3, 0, 3), false);
  }

}

