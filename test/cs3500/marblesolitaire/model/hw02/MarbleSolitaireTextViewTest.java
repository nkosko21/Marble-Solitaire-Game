package cs3500.marblesolitaire.model.hw02;

import org.junit.Assert;
import org.junit.Test;

import cs3500.marblesolitaire.view.MarbleSolitaireTextView;

/**
 * tests for MarbleSolitaireTextView.
 */
public class MarbleSolitaireTextViewTest {

  @Test
  public void testConstructor() {
    MarbleSolitaireModelState board1 = new EnglishSolitaireModel();

    MarbleSolitaireTextView constructor1 = new MarbleSolitaireTextView(board1);

    Assert.assertEquals(constructor1, constructor1); // it works
  }

  @Test
  public void testToString() {
    EnglishSolitaireModel board1 = new EnglishSolitaireModel();
    MarbleSolitaireTextView constructor1 = new MarbleSolitaireTextView(board1);
    String con1 = "  OOO  \n" +
            "  OOO  \n" +
            "OOOOOOO\n" +
            "OOO_OOO\n" +
            "OOOOOOO\n" +
            "  OOO  \n" +
            "  OOO  ";
    String con2 = "  OOO  \n" +
            "  OOO  \n" +
            "OOOOOOO\n" +
            "O__OOOO\n" +
            "OOOOOOO\n" +
            "  OOO  \n" +
            "  OOO  ";

    constructor1.toString();

    Assert.assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", constructor1.toString());

    board1.move(3, 1, 3, 3);

    constructor1 = new MarbleSolitaireTextView(board1);

    Assert.assertEquals(constructor1.toString(), con2);
  }
}
