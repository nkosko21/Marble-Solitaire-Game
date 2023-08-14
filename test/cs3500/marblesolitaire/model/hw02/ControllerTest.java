package cs3500.marblesolitaire.model.hw02;

import org.junit.Assert;
import org.junit.Test;

import java.io.Reader;
import java.io.StringReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;

import static org.junit.Assert.assertThrows;

/**
 * new tests for the controller.
 */
public class ControllerTest {

  @Test
  public void testControllerMovements() {
    Reader in1 = new StringReader("4 2 4 4 q");
    StringBuilder out1 = new StringBuilder();
    EnglishSolitaireModel eModel1 = new EnglishSolitaireModel();
    MarbleSolitaireTextView mTextView1 = new MarbleSolitaireTextView(eModel1, out1);
    MarbleSolitaireControllerImpl test1 =
            new MarbleSolitaireControllerImpl(eModel1, mTextView1, in1);
    test1.playGame();

    Assert.assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n", out1.toString());


    Reader in2 = new StringReader("q");
    StringBuilder out2 = new StringBuilder();
    EnglishSolitaireModel eModel2 = new EnglishSolitaireModel();
    MarbleSolitaireTextView mTextView2 = new MarbleSolitaireTextView(eModel2, out2);
    MarbleSolitaireControllerImpl test2 =
            new MarbleSolitaireControllerImpl(eModel2, mTextView2, in2);
    test2.playGame();

    Assert.assertEquals("Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", out2.toString());


    Reader in3 = new StringReader("0 0 0 0 q");
    StringBuilder out3 = new StringBuilder();
    EnglishSolitaireModel eModel3 = new EnglishSolitaireModel();
    MarbleSolitaireTextView mTextView3 = new MarbleSolitaireTextView(eModel3, out3);
    MarbleSolitaireControllerImpl test3 =
            new MarbleSolitaireControllerImpl(eModel3, mTextView3, in3);
    test3.playGame();

    Assert.assertEquals("Enter the value again\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", out3.toString());

    Reader in4 = new StringReader("4 2 4 4  2 3 4 3 q");
    StringBuilder out4 = new StringBuilder();
    EnglishSolitaireModel eModel4 = new EnglishSolitaireModel();
    MarbleSolitaireTextView mTextView4 = new MarbleSolitaireTextView(eModel4, out4);
    MarbleSolitaireControllerImpl test4 =
            new MarbleSolitaireControllerImpl(eModel4, mTextView4, in4);
    test4.playGame();

    Assert.assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    _ O O\n" +
            "O O _ O O O O\n" +
            "O _ O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 30\n", out4.toString());

    Reader in5 = new StringReader("4 2 4 4  2 3 4 1  2 3 4 3 q");
    StringBuilder out5 = new StringBuilder();
    EnglishSolitaireModel eModel5 = new EnglishSolitaireModel();
    MarbleSolitaireTextView mTextView5 = new MarbleSolitaireTextView(eModel5, out5);
    MarbleSolitaireControllerImpl test5 =
            new MarbleSolitaireControllerImpl(eModel5, mTextView5, in5);
    test5.playGame();

    Assert.assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "score: 31\n" +
            "Invalid move. Play again.\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    _ O O\n" +
            "O O _ O O O O\n" +
            "O _ O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 30\n", out5.toString());


    Reader in6 = new StringReader("4 2 4  q");
    StringBuilder out6 = new StringBuilder();
    EnglishSolitaireModel eModel6 = new EnglishSolitaireModel();
    MarbleSolitaireTextView mTextView6 = new MarbleSolitaireTextView(eModel6, out6);
    MarbleSolitaireControllerImpl test6 =
            new MarbleSolitaireControllerImpl(eModel6, mTextView6, in6);
    test6.playGame();

    Assert.assertEquals("Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", out6.toString());


    Reader in7 = new StringReader("4 2 4 4 q 2 3 4 3");
    StringBuilder out7 = new StringBuilder();
    EnglishSolitaireModel eModel7 = new EnglishSolitaireModel();
    MarbleSolitaireTextView mTextView7 = new MarbleSolitaireTextView(eModel7, out7);
    MarbleSolitaireControllerImpl test7 =
            new MarbleSolitaireControllerImpl(eModel7, mTextView7, in7);
    test7.playGame();

    Assert.assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n", out7.toString());


    Reader in8 = new StringReader("4 2 4 4 q 2 2 1 3");
    StringBuilder out8 = new StringBuilder();
    EnglishSolitaireModel eModel8 = new EnglishSolitaireModel();
    MarbleSolitaireTextView mTextView8 = new MarbleSolitaireTextView(eModel8, out8);
    MarbleSolitaireControllerImpl test8 =
            new MarbleSolitaireControllerImpl(eModel8, mTextView8, in8);
    test8.playGame();

    Assert.assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n", out8.toString());


    Reader in9 = new StringReader("6 4 4 4  3 4 5 4  1 4 3 4  4 2 4 4  4 5 4 3  4 7 4 5 q");
    StringBuilder out9 = new StringBuilder();
    EnglishSolitaireModel eModel9 = new EnglishSolitaireModel();
    MarbleSolitaireTextView mTextView9 = new MarbleSolitaireTextView(eModel9, out9);
    MarbleSolitaireControllerImpl test9 =
            new MarbleSolitaireControllerImpl(eModel9, mTextView9, in9);
    test9.playGame();

    Assert.assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "score: 31\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O _ O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "score: 30\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "score: 29\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "score: 28\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "O _ O _ _ O O\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "score: 27\n" +
            "Game over!\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "O _ O _ O _ _\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 26\n", out9.toString());


    Reader in10 = new StringReader("6 4 t 4 4 q");
    StringBuilder out10 = new StringBuilder();
    EnglishSolitaireModel eModel10 = new EnglishSolitaireModel();
    MarbleSolitaireTextView mTextView10 = new MarbleSolitaireTextView(eModel10, out10);
    MarbleSolitaireControllerImpl test10 =
            new MarbleSolitaireControllerImpl(eModel10, mTextView10, in10);
    test10.playGame();

    Assert.assertEquals("Enter the value again\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n", out10.toString());

  }

  @Test
  public void testControllerInputs() {
    Reader in1 = new StringReader("4 2 4 4 q");
    StringBuilder out1 = new StringBuilder();

    StringBuilder log1 = new StringBuilder();

    MarbleSolitaireModel mModel1 = new MockModel(log1);
    MarbleSolitaireTextView mTextView1 = new MarbleSolitaireTextView(mModel1, out1);
    MarbleSolitaireControllerImpl test1 =
            new MarbleSolitaireControllerImpl(mModel1, mTextView1, in1);
    test1.playGame();

    Assert.assertEquals("3 1 3 3", log1.toString());

    Reader in2 = new StringReader("1 1 1 1 q");
    StringBuilder out2 = new StringBuilder();
    StringBuilder log2 = new StringBuilder();

    MarbleSolitaireModel mModel2 = new MockModel(log2);
    MarbleSolitaireTextView mTextView2 = new MarbleSolitaireTextView(mModel2, out2);
    MarbleSolitaireControllerImpl test2 =
            new MarbleSolitaireControllerImpl(mModel2, mTextView2, in2);
    test2.playGame();

    Assert.assertEquals("0 0 0 0", log2.toString());


    Reader in3 = new StringReader("4 2 4 4  2 3 4 1  2 3 4 3 q");
    StringBuilder out3 = new StringBuilder();
    StringBuilder log3 = new StringBuilder();

    MarbleSolitaireModel mModel3 = new MockModel(log3);
    MarbleSolitaireTextView mTextView3 = new MarbleSolitaireTextView(mModel3, out3);
    MarbleSolitaireControllerImpl test3 =
            new MarbleSolitaireControllerImpl(mModel3, mTextView3, in3);
    test3.playGame();

    Assert.assertEquals("3 1 3 31 2 3 01 2 3 2", log3.toString());
  }

  @Test
  public void testExceptions() {
    Reader in4 = new StringReader("0 ");
    StringBuilder out4 = new StringBuilder();
    EnglishSolitaireModel eModel4 = new EnglishSolitaireModel();
    MarbleSolitaireTextView mTextView4 = new MarbleSolitaireTextView(eModel4, out4);
    MarbleSolitaireControllerImpl test4 =
            new MarbleSolitaireControllerImpl(eModel4, mTextView4, in4);
    assertThrows( "", IllegalArgumentException.class, () -> test4.playGame());


    Reader in5 = new StringReader("a ");
    StringBuilder out5 = new StringBuilder();
    EnglishSolitaireModel eModel5 = new EnglishSolitaireModel();
    MarbleSolitaireTextView mTextView5 = new MarbleSolitaireTextView(eModel5, out5);
    MarbleSolitaireControllerImpl test5 =
            new MarbleSolitaireControllerImpl(eModel5, mTextView5, in5);
    assertThrows( "", IllegalArgumentException.class, () -> test5.playGame());

    assertThrows("",
            IllegalArgumentException.class,
            () -> new MarbleSolitaireControllerImpl(null, null, null));


    Reader in11 = new StringReader("6 4 4 4");
    StringBuilder out11 = new StringBuilder();
    EnglishSolitaireModel eModel11 = new EnglishSolitaireModel();
    MarbleSolitaireTextView mTextView11 = new MarbleSolitaireTextView(eModel11, out11);
    MarbleSolitaireControllerImpl test11 =
            new MarbleSolitaireControllerImpl(eModel11, mTextView11, in11);


    assertThrows( "", IllegalArgumentException.class, () -> test11.playGame());
  }
}
