import org.junit.Assert;
import org.junit.Test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import cs3500.Histogram;
import cs3500.controller.ControllerGUI;
import cs3500.controller.HandleFeatures;
import cs3500.model.IModel;
import cs3500.model.ImplModel;
import cs3500.view.JFrameView;

/**
 * class for testing the UI.
 */
public class TestUI {

  @Test
  public void testHistogram() {
    try {
      BufferedImage img;
      img = ImageIO.read(new File(
              "/Users/nick/Documents/funnyPanda.jpg"));
      Histogram h = new Histogram(img, 1);
      Histogram h2 = new Histogram(img, 2);
      Histogram h3 = new Histogram(img, 1);
      Assert.assertNotEquals(img, h.getTestImage());
      Assert.assertNotEquals(h, h2);
      Assert.assertEquals(h, h3);
    }
    catch (IOException e) {
      throw new IllegalArgumentException("no");
    }
  }

  @Test
  public void testJFrameView() {
    JFrameView view = new JFrameView("test");
    Assert.assertNotNull(view);
  }

  @Test
  public void testControllerGUI() {
    IModel model = new ImplModel();
    JFrameView view = new JFrameView("test");

    ControllerGUI gui = new ControllerGUI(model, view);
    Assert.assertNotNull(gui);
  }

  @Test
  public void testHandleFeatures() {
    IModel model = new ImplModel();
    JFrameView view = new JFrameView("test");

    HandleFeatures gui = new HandleFeatures(model, view);
    Assert.assertNotNull(gui);
  }
}
