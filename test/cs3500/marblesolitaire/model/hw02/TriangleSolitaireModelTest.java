package cs3500.marblesolitaire.model.hw02;

import org.junit.Assert;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/**
 * tests for a triangle solitaire model.
 */
public class TriangleSolitaireModelTest {

  @Test
  public void testConstructor() {
    MarbleSolitaireModel con1 = new TriangleSolitaireModel();
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Empty, con1.getSlotAt(0, 0));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Invalid, con1.getSlotAt(0, 1));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Invalid, con1.getSlotAt(3, 4));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Marble, con1.getSlotAt(4, 4));

    MarbleSolitaireModel con2 = new TriangleSolitaireModel(1, 0);
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Empty, con2.getSlotAt(1, 0));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Invalid, con2.getSlotAt(0, 1));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Invalid, con2.getSlotAt(3, 4));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Marble, con2.getSlotAt(4, 4));

    MarbleSolitaireModel con3 = new TriangleSolitaireModel(6);
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Empty, con3.getSlotAt(0, 0));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Invalid, con3.getSlotAt(0, 1));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Invalid, con3.getSlotAt(3, 4));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Marble, con3.getSlotAt(4, 4));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Invalid, con3.getSlotAt(4, 5));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Marble, con3.getSlotAt(5, 5));

    MarbleSolitaireModel con4 = new TriangleSolitaireModel(6, 5, 5);
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Marble, con4.getSlotAt(0, 0));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Invalid, con4.getSlotAt(0, 1));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Invalid, con4.getSlotAt(3, 4));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Marble, con4.getSlotAt(4, 4));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Invalid, con4.getSlotAt(4, 5));
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Empty, con4.getSlotAt(5, 5));
  }

  @Test
  public void testMoveAndToString() {
  MarbleSolitaireModel con = new TriangleSolitaireModel(6, 3, 1);
  TriangleSolitaireTextView t = new TriangleSolitaireTextView(con);
    Assert.assertEquals("     O          \n" +
            "    O O        \n" +
            "   O O O      \n" +
            "  O _ O O    \n" +
            " O O O O O  \n" +
            "O O O O O O", t.toString());
    Assert.assertEquals(con.getSlotAt(1, 1), MarbleSolitaireModel.SlotState.Marble);
    Assert.assertEquals(con.getSlotAt(2, 1), MarbleSolitaireModel.SlotState.Marble);
    Assert.assertEquals(con.getSlotAt(3, 1), MarbleSolitaireModel.SlotState.Empty);
    con.move(1, 1, 3, 1); // down
    assertEquals("     O          \n" +
            "    O _        \n" +
            "   O _ O      \n" +
            "  O O O O    \n" +
            " O O O O O  \n" +
            "O O O O O O", t.toString());
    Assert.assertEquals(con.getSlotAt(1, 1), MarbleSolitaireModel.SlotState.Empty);
    Assert.assertEquals(con.getSlotAt(2, 1), MarbleSolitaireModel.SlotState.Empty);
    Assert.assertEquals(con.getSlotAt(3, 1), MarbleSolitaireModel.SlotState.Marble);

    Assert.assertEquals(con.getSlotAt(4,1), MarbleSolitaireModel.SlotState.Marble);
    Assert.assertEquals(con.getSlotAt(3,1), MarbleSolitaireModel.SlotState.Marble);
    Assert.assertEquals(con.getSlotAt(2,1), MarbleSolitaireModel.SlotState.Empty);
    con.move(4, 1, 2, 1); // up
    assertEquals("     O          \n" +
            "    O _        \n" +
            "   O O O      \n" +
            "  O _ O O    \n" +
            " O _ O O O  \n" +
            "O O O O O O", t.toString());
    Assert.assertEquals(con.getSlotAt(4,1), MarbleSolitaireModel.SlotState.Empty);
    Assert.assertEquals(con.getSlotAt(3,1), MarbleSolitaireModel.SlotState.Empty);
    Assert.assertEquals(con.getSlotAt(2,1), MarbleSolitaireModel.SlotState.Marble);

    Assert.assertEquals(con.getSlotAt(4, 3), MarbleSolitaireModel.SlotState.Marble);
    Assert.assertEquals(con.getSlotAt(4, 2), MarbleSolitaireModel.SlotState.Marble);
    Assert.assertEquals(con.getSlotAt(4, 1), MarbleSolitaireModel.SlotState.Empty);
    con.move(4, 3, 4, 1); // left
    Assert.assertEquals("     O          \n" +
            "    O _        \n" +
            "   O O O      \n" +
            "  O _ O O    \n" +
            " O O _ _ O  \n" +
            "O O O O O O", t.toString());
    Assert.assertEquals(con.getSlotAt(4, 3), MarbleSolitaireModel.SlotState.Empty);
    Assert.assertEquals(con.getSlotAt(4, 2), MarbleSolitaireModel.SlotState.Empty);
    Assert.assertEquals(con.getSlotAt(4, 1), MarbleSolitaireModel.SlotState.Marble);

    Assert.assertEquals(con.getSlotAt(4, 0), MarbleSolitaireModel.SlotState.Marble);
    Assert.assertEquals(con.getSlotAt(4, 1), MarbleSolitaireModel.SlotState.Marble);
    Assert.assertEquals(con.getSlotAt(4, 2), MarbleSolitaireModel.SlotState.Empty);
    con.move(4, 0, 4, 2); // right
    Assert.assertEquals("     O          \n" +
            "    O _        \n" +
            "   O O O      \n" +
            "  O _ O O    \n" +
            " _ _ O _ O  \n" +
            "O O O O O O", t.toString());
    Assert.assertEquals(con.getSlotAt(4, 0), MarbleSolitaireModel.SlotState.Empty);
    Assert.assertEquals(con.getSlotAt(4, 1), MarbleSolitaireModel.SlotState.Empty);
    Assert.assertEquals(con.getSlotAt(4, 2), MarbleSolitaireModel.SlotState.Marble);

    Assert.assertEquals(con.getSlotAt(5, 3), MarbleSolitaireModel.SlotState.Marble);
    Assert.assertEquals(con.getSlotAt(4, 2), MarbleSolitaireModel.SlotState.Marble);
    Assert.assertEquals(con.getSlotAt(3, 1), MarbleSolitaireModel.SlotState.Empty);
    con.move(5, 3, 3, 1);
    Assert.assertEquals("     O          \n" +
            "    O _        \n" +
            "   O O O      \n" +
            "  O O O O    \n" +
            " _ _ _ _ O  \n" +
            "O O O _ O O", t.toString());
    Assert.assertEquals(con.getSlotAt(5, 3), MarbleSolitaireModel.SlotState.Empty);
    Assert.assertEquals(con.getSlotAt(4, 2), MarbleSolitaireModel.SlotState.Empty);
    Assert.assertEquals(con.getSlotAt(3, 1), MarbleSolitaireModel.SlotState.Marble);

    Assert.assertEquals(con.getSlotAt(2, 0), MarbleSolitaireModel.SlotState.Marble);
    Assert.assertEquals(con.getSlotAt(3, 1), MarbleSolitaireModel.SlotState.Marble);
    Assert.assertEquals(con.getSlotAt(4, 2), MarbleSolitaireModel.SlotState.Empty);
    con.move(2, 0, 4, 2);
    Assert.assertEquals("     O          \n" +
            "    O _        \n" +
            "   _ O O      \n" +
            "  O _ O O    \n" +
            " _ _ O _ O  \n" +
            "O O O _ O O", t.toString());
    Assert.assertEquals(con.getSlotAt(2, 0), MarbleSolitaireModel.SlotState.Empty);
    Assert.assertEquals(con.getSlotAt(3, 1), MarbleSolitaireModel.SlotState.Empty);
    Assert.assertEquals(con.getSlotAt(4, 2), MarbleSolitaireModel.SlotState.Marble);
  }

  @Test
  public void testIsGameOver() {
    MarbleSolitaireModel con = new TriangleSolitaireModel(2, 0);
    Assert.assertEquals(con.isGameOver(), false);

    con.move(0, 0, 2, 0);
    Assert.assertEquals(con.isGameOver(), false);

    con.move(3, 0, 1, 0);
    Assert.assertEquals(con.isGameOver(), false);
  }

  @Test
  public void testGetScore() {
    MarbleSolitaireModel con1 = new TriangleSolitaireModel(7);
    Assert.assertEquals(con1.getScore(), 27);

    con1.move(2, 0, 0, 0);
    Assert.assertEquals(con1.getScore(), 26);

    try {
      con1.move(2, 0, 0, 0);
    }
    catch (IllegalArgumentException f) {
      Assert.assertEquals(con1.getScore(), 26);
    }


    MarbleSolitaireModel con2 = new TriangleSolitaireModel(3, 0);
    Assert.assertEquals(con2.getScore(), 14);

    con2.move(1, 0, 3, 0);
    Assert.assertEquals(con2.getScore(), 13);

    try {
      con2.move(1, 0, 3, 0);
    }
    catch (IllegalArgumentException f) {
      Assert.assertEquals(con2.getScore(), 13);
    }
  }

  @Test
  public void testExceptions() {
    MarbleSolitaireModel con1 = new TriangleSolitaireModel();

    assertThrows("Arm thickness is less than or equal to zero",
            IllegalArgumentException.class, () -> new TriangleSolitaireModel(- 1));
    assertThrows("Arm thickness is less than or equal to zero",
            IllegalArgumentException.class, () -> new TriangleSolitaireModel(0));
    assertThrows("Invalid position",
            IllegalArgumentException.class, () -> new TriangleSolitaireModel(- 1, -2));
    assertThrows("Invalid position",
            IllegalArgumentException.class, () -> new TriangleSolitaireModel(10, 10));
    assertThrows("Arm thickness is less than or equal to zero",
            IllegalArgumentException.class, () -> new TriangleSolitaireModel(-1, 2, 3));
    assertThrows("Invalid position",
            IllegalArgumentException.class, () -> new TriangleSolitaireModel(3, -1, 0));
    assertThrows("Invalid move: Outside of board",
            IllegalArgumentException.class, () -> con1.move(-1, 2, 0, 0));
    assertThrows("Invalid move: impossible move",
            IllegalArgumentException.class, () -> con1.move(0, 0, 0, 0));
  }
}
