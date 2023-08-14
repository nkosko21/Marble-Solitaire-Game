package cs3500.marblesolitaire.model.hw02;

import org.junit.Assert;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;

import static org.junit.Assert.assertThrows;

/**
 * tests for a european solitaire model.
 */
public class EuropeanSolitaireModelTest {

  @Test
  public void testConstructor() {
    MarbleSolitaireModel con1 = new EuropeanSolitaireModel();

    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Empty, con1.getSlotAt(3, 3));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Marble, con1.getSlotAt(3, 2));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Invalid, con1.getSlotAt(0, 0));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Invalid, con1.getSlotAt(0, 1));


    MarbleSolitaireModel con2 = new EuropeanSolitaireModel(2, 3);
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Empty, con2.getSlotAt(2, 3));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Marble, con2.getSlotAt(3, 3));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Invalid, con2.getSlotAt(0, 0));

    MarbleSolitaireModel con3 = new EuropeanSolitaireModel(5);
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Marble, con3.getSlotAt(2, 2));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Marble, con3.getSlotAt(2, 10));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Marble, con3.getSlotAt(10, 2));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Marble, con3.getSlotAt(10, 10));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Invalid, con3.getSlotAt(1, 1));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Invalid, con3.getSlotAt(1, 11));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Invalid, con3.getSlotAt(11, 1));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Invalid, con3.getSlotAt(11, 11));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Empty, con3.getSlotAt(6, 6));

    MarbleSolitaireModel con4 = new EuropeanSolitaireModel(5, 2, 2);
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Empty, con4.getSlotAt(2, 2));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Marble, con4.getSlotAt(2, 10));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Marble, con4.getSlotAt(10, 2));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Marble, con4.getSlotAt(10, 10));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Invalid, con4.getSlotAt(1, 1));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Invalid, con4.getSlotAt(1, 11));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Invalid, con4.getSlotAt(11, 1));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Invalid, con4.getSlotAt(11, 11));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Marble, con4.getSlotAt(2, 3));
  }

  @Test
  public void testMoveAndToString() {
    MarbleSolitaireModel con1 = new EuropeanSolitaireModel();

    MarbleSolitaireTextView t = new MarbleSolitaireTextView(con1);
    Assert.assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", t.toString());

    // down
    Assert.assertEquals(con1.getSlotAt(3, 1), MarbleSolitaireModelState.SlotState.Marble);
    Assert.assertEquals(con1.getSlotAt(3, 2), MarbleSolitaireModelState.SlotState.Marble);
    Assert.assertEquals(con1.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Empty);
    con1.move(3, 1, 3, 3);
    Assert.assertEquals(con1.getSlotAt(3, 1), MarbleSolitaireModelState.SlotState.Empty);
    Assert.assertEquals(con1.getSlotAt(3, 2), MarbleSolitaireModelState.SlotState.Empty);
    Assert.assertEquals(con1.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Marble);
    Assert.assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", t.toString());

    //up
    Assert.assertEquals(con1.getSlotAt(5, 2), MarbleSolitaireModelState.SlotState.Marble);
    Assert.assertEquals(con1.getSlotAt(4, 2), MarbleSolitaireModelState.SlotState.Marble);
    Assert.assertEquals(con1.getSlotAt(3, 2), MarbleSolitaireModelState.SlotState.Empty);
    con1.move(5, 2, 3, 2);
    Assert.assertEquals(con1.getSlotAt(5, 2), MarbleSolitaireModelState.SlotState.Empty);
    Assert.assertEquals(con1.getSlotAt(4, 2), MarbleSolitaireModelState.SlotState.Empty);
    Assert.assertEquals(con1.getSlotAt(3, 2), MarbleSolitaireModelState.SlotState.Marble);
    Assert.assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O _ O O O O O\n" +
            "O O _ O O O O\n" +
            "  O _ O O O\n" +
            "    O O O", t.toString());

    //left
    Assert.assertEquals(con1.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Marble);
    Assert.assertEquals(con1.getSlotAt(3, 2), MarbleSolitaireModelState.SlotState.Marble);
    Assert.assertEquals(con1.getSlotAt(3, 1), MarbleSolitaireModelState.SlotState.Empty);
    con1.move(3, 3, 3, 1);
    Assert.assertEquals(con1.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Empty);
    Assert.assertEquals(con1.getSlotAt(3, 2), MarbleSolitaireModelState.SlotState.Empty);
    Assert.assertEquals(con1.getSlotAt(3, 1), MarbleSolitaireModelState.SlotState.Marble);
    Assert.assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O _ _ O O O\n" +
            "O O _ O O O O\n" +
            "  O _ O O O\n" +
            "    O O O", t.toString());

    //up
    Assert.assertEquals(con1.getSlotAt(5, 3), MarbleSolitaireModelState.SlotState.Marble);
    Assert.assertEquals(con1.getSlotAt(4, 3), MarbleSolitaireModelState.SlotState.Marble);
    Assert.assertEquals(con1.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Empty);
    con1.move(5, 3, 3, 3);
    Assert.assertEquals(con1.getSlotAt(5, 3), MarbleSolitaireModelState.SlotState.Empty);
    Assert.assertEquals(con1.getSlotAt(4, 3), MarbleSolitaireModelState.SlotState.Empty);
    Assert.assertEquals(con1.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Marble);
    Assert.assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O _ O O O O\n" +
            "O O _ _ O O O\n" +
            "  O _ _ O O\n" +
            "    O O O", t.toString());

    //right
    Assert.assertEquals(con1.getSlotAt(3, 0), MarbleSolitaireModelState.SlotState.Marble);
    Assert.assertEquals(con1.getSlotAt(3, 1), MarbleSolitaireModelState.SlotState.Marble);
    Assert.assertEquals(con1.getSlotAt(3, 2), MarbleSolitaireModelState.SlotState.Empty);
    con1.move(3, 0, 3, 2);
    Assert.assertEquals(con1.getSlotAt(3, 0), MarbleSolitaireModelState.SlotState.Empty);
    Assert.assertEquals(con1.getSlotAt(3, 1), MarbleSolitaireModelState.SlotState.Empty);
    Assert.assertEquals(con1.getSlotAt(3, 2), MarbleSolitaireModelState.SlotState.Marble);
    Assert.assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "_ _ O O O O O\n" +
            "O O _ _ O O O\n" +
            "  O _ _ O O\n" +
            "    O O O", t.toString());
  }

  @Test
  public void testIsGameOver() {
    MarbleSolitaireModel con = new EuropeanSolitaireModel();
    Assert.assertEquals(con.isGameOver(), false);

    con.move(1, 3, 3, 3);
    Assert.assertEquals(con.isGameOver(), false);

    con.move(2, 1, 2, 3);
    Assert.assertEquals(con.isGameOver(), false);
  }

  @Test
  public void testExceptions() {
    MarbleSolitaireModel con = new EuropeanSolitaireModel();

    assertThrows("Arm thickness is less than or equal to zero",
            IllegalArgumentException.class, () -> new EuropeanSolitaireModel(0));
    assertThrows("Arm thickness is less than or equal to zero",
            IllegalArgumentException.class, () -> new EuropeanSolitaireModel(-9));
    assertThrows("Invalid position",
            IllegalArgumentException.class, () -> new EuropeanSolitaireModel(1, -2));
    assertThrows("Invalid position",
            IllegalArgumentException.class, () -> new EuropeanSolitaireModel(20, 102));
    assertThrows("Invalid position",
            IllegalArgumentException.class, () -> new EuropeanSolitaireModel(4, 20, 102));
    assertThrows("Invalid position",
            IllegalArgumentException.class, () -> new EuropeanSolitaireModel(4, -4, 28));
    assertThrows("Arm thickness is less than or equal to zero",
            IllegalArgumentException.class, () -> new EuropeanSolitaireModel(-4, 3, 3));
    assertThrows("Arm thickness is less than or equal to zero",
            IllegalArgumentException.class, () -> new EuropeanSolitaireModel(0, 3, 3));
    assertThrows("Invalid From position",
            IllegalArgumentException.class, () -> con.move(0, 0, 3, 3));
    assertThrows("Invalid To position",
            IllegalArgumentException.class, () -> con.move(3, 3, 0, 0));
    assertThrows("There is no marble there",
            IllegalArgumentException.class, () -> con.move(3, 3, 5, 3));
    assertThrows("There is a marble in the To position",
            IllegalArgumentException.class, () -> con.move(3, 5, 3, 7));
    assertThrows("The marbles are too far apart",
            IllegalArgumentException.class, () -> con.move(3 , 5, 3, 2));
    assertThrows("Invalid From position",
            IllegalArgumentException.class, () -> con.move(9 , 9, 4, 4));
    assertThrows("Invalid To position",
            IllegalArgumentException.class, () -> con.move(3 , 5, 9, 9));
  }
}
