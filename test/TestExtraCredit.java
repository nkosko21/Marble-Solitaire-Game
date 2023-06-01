import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import java.awt.image.BufferedImage;

import cs3500.model.IModel;
import cs3500.model.ImplModel;

/**
 * Test class for all extra credit functionality.
 */
public class TestExtraCredit {
  private IModel model;
  private BufferedImage image;

  @Before
  public void setup() {
    model = new ImplModel();
    model.load("/Users/lukecolombo/Desktop/IntelliJ/ImageProcessing/funnyPanda.jpg",
            "test");
    image = model.getImages().get("test");
  }

  @Test
  public void testMask() {
    model.maskImage("test", "test", "blur");
    for (int row = 0; row < image.getHeight(); row++) {
      for (int col = 0; col < image.getWidth(); col++) {

      }
    }
  }

}
