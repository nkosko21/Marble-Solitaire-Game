import org.junit.Assert;
import org.junit.Test;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import cs3500.model.IModel;
import cs3500.model.ImplModel;

/**
 * Test class for model.
 */
public class TestModel {

  @Test
  public void testFirstConstructor() {
    IModel model = new ImplModel();
    Map<String, BufferedImage> expected = new HashMap<>();
    Assert.assertEquals(model.getImages(), expected);
  }

}
