import org.junit.Assert;
import org.junit.Test;

import java.io.Reader;
import java.io.StringReader;

import cs3500.controller.ControllerV1;
import cs3500.controller.IController;
import cs3500.model.IModel;
import cs3500.model.ImplModel;

/**
 * Test class for the controller.
 */
public class TestController {

  @Test
  public void testInputs() {
    Reader in = new StringReader("load /Users/nick/Documents/funnyPanda.jpg Koala \n" +
            "brighten 10 Koala KoalaBrighten \n" +
            "darken 10 Koala KoalaDarken \n" +
            "horizontal-flip Koala KoalaHorizontal \n" +
            "vertical-flip KoalaHorizontal KoalaVertical \n" +
            "blue-component Koala KoalaBlue \n" +
            "green-component Koala KoalaGreen \n" +
            "red-component Koala KoalaRed \n" +
            "intensity-component Koala KoalaIntensity \n" +
            "luma-component Koala KoalaLuma \n" +
            "value-component Koala KoalaValue \n" +
            "badCommand \n" +
            "\n");
    StringBuilder out = new StringBuilder();
    IModel model = new ImplModel();

    IController controller = new ControllerV1(model, in, out);

    controller.runProgram();

    Assert.assertEquals(model.getImages().size(), 11);
    Assert.assertEquals(out, "Welcome to the image processing program. " +
            "Type help to see a list of supported commands." +
            " At any time, type q or quit to exit the program.\n" +
            "That command was not recognized. Commands are all lowercase. " +
            "If it is multiple words, put hyphens between every word.");
  }

  @Test
  public void scriptInput() {
    Reader in2 = new StringReader("-file /Users/nick/Documents/script.txt");

    StringBuilder out2 = new StringBuilder();
    IModel model2 = new ImplModel();

    IController controller2 = new ControllerV1(model2, in2, out2);

    controller2.runProgram();

    Assert.assertEquals(model2.getImages().size(), 2);
    Assert.assertEquals(out2, "");
  }
}
