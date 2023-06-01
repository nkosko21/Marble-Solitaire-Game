import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import cs3500.model.commands.Blur;
import cs3500.model.commands.FlipVertically;
import cs3500.model.commands.GrayScaleBlue;
import cs3500.model.commands.GrayScaleGreen;
import cs3500.model.commands.GrayScaleIntensity;
import cs3500.model.commands.GrayScaleLuma;
import cs3500.model.commands.GrayScaleRed;
import cs3500.model.commands.GrayScaleValue;
import cs3500.model.commands.SepiaToneColorTransformation;
import cs3500.model.commands.Sharpen;
import cs3500.model.IModel;
import cs3500.model.ImplModel;
import cs3500.model.commands.Brighten;
import cs3500.model.commands.Darken;
import cs3500.model.commands.FlipHorizontally;
import cs3500.model.commands.ICommand;
import cs3500.model.commands.Load;

import static cs3500.ToStringImageUtil.getB;
import static cs3500.ToStringImageUtil.getG;
import static cs3500.ToStringImageUtil.getIntensity;
import static cs3500.ToStringImageUtil.getLuma;
import static cs3500.ToStringImageUtil.getR;
import static cs3500.ToStringImageUtil.getValue;
import static cs3500.model.ImplModel.convertToFourChannel;
import static org.junit.Assert.assertThrows;

/**
 * Test class for every command function object.
 */
public class TestCommands {

  @Test
  public void testSaveLoad() {
    IModel model = new ImplModel();
    new Load("/Users/lukecolombo/Desktop/IntelliJ/ImageProcessing/4x4colors.ppm",
            "test").applyCommand(model);
    Assert.assertEquals(model.getImages().size(), 1);
    Assert.assertNotNull(model.getImages().get("test"));
    model.save("test", "");
//    BufferedImage expected = new BufferedImage(IntArrayImageUtil.readPPM(
//            "/Users/lukecolombo/Desktop/IntelliJ/ImageProcessing/4x4colors.ppm")[0],
//            IntArrayImageUtil.readPPM(
//                    "/Users/lukecolombo/Desktop/IntelliJ/ImageProcessing/4x4colors.ppm")[1],
//            1);
//    IModel model = new ImplModel("fun", expected);
    model.save("fun", "/Users/lukecolombo/Downloads");
    model.load("/Users/lukecolombo/Downloads/fun.ppm", "funAgain");
    BufferedImage actual = model.getImages().get("funAgain");
//    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testBrighten() { // TEST EXCEPTION FOR NEG OR 0 VALUE
    ImplModel model1 = new ImplModel();
      new Load("/Users/lukecolombo/Desktop/IntelliJ/ImageProcessing/4x4colors.ppm",
              "pandaNormal").applyCommand(model1);

    Assert.assertEquals(model1.getImages().size(), 1);
    ICommand cmd1 = new Brighten(10, "pandaNormal", "brighterBy10");
    cmd1.applyCommand(model1);

    Assert.assertEquals(model1.getImages().size(), 2);

    BufferedImage pandaNormal = model1.getImages().get("pandaNormal");
    BufferedImage brighterBy10 = model1.getImages().get("brighterBy10");
    int counter = 0;

    for (int row = 0; row < pandaNormal.getHeight(); row++) {
      for (int col = 0; col < pandaNormal.getWidth(); col++) {
        Color color1 = new Color(pandaNormal.getRGB(col, row));
        Color color2 = new Color(brighterBy10.getRGB(col, row));

        if ((convertToFourChannel(color1.getRed() + 10,
                color1.getGreen() + 10, color1.getBlue() + 10)
                == convertToFourChannel(color2.getRed(), color2.getGreen(), color2.getBlue()))
                || color2.getRed() == 255 || color2.getGreen() == 255 || color2.getBlue() == 255) {
          //empty line
        }
        else {
          counter++;
        }
      }
    }

    Assert.assertEquals(0, counter);
    Assert.assertEquals(model1.getImages().get("pandaNormal") == null, false);
    Assert.assertEquals(model1.getImages().get("brighterBy10") == null, false);
  }


  @Test
  public void testDarken() {
    ImplModel model2 = new ImplModel();
    new Load("/Users/nick/Documents/funnyPanda.jpg",
            "pandaNormal").applyCommand(model2);

    Assert.assertEquals(model2.getImages().size(), 1);
    ICommand cmd2 = new Darken(10, "pandaNormal", "darkenBy10");
    cmd2.applyCommand(model2);

    Assert.assertEquals(model2.getImages().size(), 2);

    BufferedImage pandaNormal = model2.getImages().get("pandaNormal");
    BufferedImage darkenBy10 = model2.getImages().get("darkenBy10");

    int counter = 0;

    for (int row = 0; row < pandaNormal.getHeight(); row++) {
      for (int col = 0; col < pandaNormal.getWidth(); col++) {
        Color color1 = new Color(pandaNormal.getRGB(col, row));
        Color color2 = new Color(darkenBy10.getRGB(col, row));

        if ((convertToFourChannel(color1.getRed() - 10,
                color1.getGreen() - 10, color1.getBlue() - 10)
                == convertToFourChannel(color2.getRed(), color2.getGreen(), color2.getBlue()))
                || color2.getRed() == 0 || color2.getGreen() == 0 || color2.getBlue() == 0) {
          //empty blocks
        } else {
          counter++;
        }
      }
    }

    Assert.assertEquals(counter, 0);
    Assert.assertEquals(model2.getImages().get("darkenBy10") == null, false);
    Assert.assertEquals(model2.getImages().get("pandaNormal") == null, false);
  }

  @Test
  public void testFlipHorizontally() {
    IModel model3 = new ImplModel();
    ImplModel model2 = new ImplModel();
    new Load("/Users/nick/Documents/funnyPanda.jpg",
            "pandaNormal").applyCommand(model3);

    ICommand cmd3 = new FlipHorizontally("pandaNormal", "flipHorizontally");
    cmd3.applyCommand(model3);

    Assert.assertEquals(model3.getImages().size(), 2);

    BufferedImage pandaNormal = model3.getImages().get("pandaNormal");
    BufferedImage flipHorizontally = model3.getImages().get("flipHorizontally");

    int counter = 0;

    for (int row = 0; row < pandaNormal.getHeight(); row++) {
      for (int col = 0; col < pandaNormal.getWidth(); col++) {
        if (flipHorizontally.getRGB(col, row) !=
                (pandaNormal.getRGB(col, pandaNormal.getHeight() - row - 1))) {
          counter++;
        }
      }
    }

    Assert.assertEquals(counter, 0);
    Assert.assertEquals(model3.getImages().get("flipHorizontally") == null, false);
    Assert.assertEquals(model3.getImages().get("pandaNormal") == null, false);
  }

  @Test
  public void testFlipVertically() {
    IModel model4 = new ImplModel();
    new Load("/Users/nick/Documents/funnyPanda.jpg",
            "pandaNormal").applyCommand(model4);

    ICommand cmd4 = new FlipVertically("pandaNormal", "flipVertically");
    cmd4.applyCommand(model4);

    Assert.assertEquals(model4.getImages().size(), 2);

    BufferedImage pandaNormal = model4.getImages().get("pandaNormal");
    BufferedImage flipVertically = model4.getImages().get("flipVertically");

    int counter = 0;

    for (int row = 0; row < pandaNormal.getHeight(); row++) {
      for (int col = 0; col < pandaNormal.getWidth(); col++) {
        if (flipVertically.getRGB(col, row) !=
                (pandaNormal.getRGB(pandaNormal.getWidth() - col - 1, row))) {
          counter++;
        }
      }
    }

    Assert.assertEquals(counter, 0);
    Assert.assertEquals(model4.getImages().get("flipVertically") == null, false);
    Assert.assertEquals(model4.getImages().get("pandaNormal") == null, false);
  }

  @Test
  public void testGrayScaleIntensity() {
    IModel model5 = new ImplModel();
    new Load("/Users/nick/Documents/funnyPanda.jpg",
            "pandaNormal").applyCommand(model5);

    ICommand cmd5 = new GrayScaleIntensity("pandaNormal", "koalaIntensity");
    cmd5.applyCommand(model5);

    BufferedImage pandaNormal = model5.getImages().get("pandaNormal");
    BufferedImage koalaIntensity = model5.getImages().get("koalaIntensity");

    int counter = 0;

    for (int row = 0; row < pandaNormal.getHeight(); row++) {
      for (int col = 0; col < pandaNormal.getWidth(); col++) {
        Color color = new Color(koalaIntensity.getRGB(col, row));

        if (getIntensity(pandaNormal.getRGB(col, row)) != color.getRed()
                || getIntensity(pandaNormal.getRGB(col, row)) != color.getGreen()
                || getIntensity(pandaNormal.getRGB(col, row)) != color.getBlue()) {
          counter++;
        }
      }
    }

    Assert.assertEquals(counter, 0);
    Assert.assertEquals(model5.getImages().get("koalaIntensity") == null, false);
    Assert.assertEquals(model5.getImages().get("pandaNormal") == null, false);
  }

  @Test
  public void testGrayScaleBlue() {
    IModel model6 = new ImplModel();
    new Load("/Users/nick/Documents/funnyPanda.jpg",
            "pandaNormal").applyCommand(model6);

    ICommand cmd6 = new GrayScaleIntensity("pandaNormal", "koalaBlue");
    cmd6.applyCommand(model6);

    BufferedImage pandaNormal = model6.getImages().get("pandaNormal");
    BufferedImage koalaBlue = model6.getImages().get("koalaBlue");

    int counter = 0;

    for (int row = 0; row < pandaNormal.getHeight(); row++) {
      for (int col = 0; col < pandaNormal.getWidth(); col++) {
        Color color1 = new Color(pandaNormal.getRGB(col, row));
        Color color2 = new Color(koalaBlue.getRGB(col, row));

        if (color1.getBlue() != color2.getRed()
                || color1.getBlue() != color2.getGreen()
                || color1.getBlue() != color2.getBlue()) {
          counter++;
        }
      }
    }

    Assert.assertEquals(counter, 0);
    Assert.assertEquals(model6.getImages().get("koalaBlue") == null, false);
    Assert.assertEquals(model6.getImages().get("pandaNormal") == null, false);
  }

  @Test
  public void testGrayScaleGreen() {
    IModel model7 = new ImplModel();
    new Load("/Users/nick/Documents/funnyPanda.jpg",
            "pandaNormal").applyCommand(model7);

    ICommand cmd7 = new GrayScaleIntensity("pandaNormal", "koalaGreen");
    cmd7.applyCommand(model7);

    BufferedImage pandaNormal = model7.getImages().get("pandaNormal");
    BufferedImage koalaGreen = model7.getImages().get("koalaGreen");

    int counter = 0;

    for (int row = 0; row < pandaNormal.getHeight(); row++) {
      for (int col = 0; col < pandaNormal.getWidth(); col++) {
        Color color1 = new Color(pandaNormal.getRGB(col, row));
        Color color2 = new Color(koalaGreen.getRGB(col, row));
        if (color1.getGreen() != color2.getRed()
                || color1.getGreen() != color2.getGreen()
                || color1.getGreen() != color2.getBlue()) {
          counter++;
        }
      }
    }


    Assert.assertEquals(counter, 0);
    Assert.assertEquals(model7.getImages().get("koalaGreen") == null, false);
    Assert.assertEquals(model7.getImages().get("pandaNormal") == null, false);
  }

  @Test
  public void testGrayScaleLuma() {
    IModel model8 = new ImplModel();
    new Load("/Users/nick/Documents/funnyPanda.jpg",
            "pandaNormal").applyCommand(model8);

    ICommand cmd8 = new GrayScaleIntensity("pandaNormal", "koalaLuma");
    cmd8.applyCommand(model8);

    BufferedImage pandaNormal = model8.getImages().get("pandaNormal");
    BufferedImage koalaLuma = model8.getImages().get("koalaLuma");

    int counter = 0;

    for (int row = 0; row < pandaNormal.getHeight(); row++) {
      for (int col = 0; col < pandaNormal.getWidth(); col++) {
        Color color = new Color(koalaLuma.getRGB(col, row));
        if (getLuma(pandaNormal.getRGB(col, row)) != color.getRed()
                || getLuma(pandaNormal.getRGB(col, row)) != color.getGreen()
                || getLuma(pandaNormal.getRGB(col, row)) != color.getBlue()) {
          counter++;
        }
      }
    }

    Assert.assertEquals(counter, 0);
    Assert.assertEquals(model8.getImages().get("koalaLuma") == null, false);
    Assert.assertEquals(model8.getImages().get("pandaNormal") == null, false);
  }

  @Test
  public void testGrayScaleRed() {
    IModel model9 = new ImplModel();
    new Load("/Users/nick/Documents/funnyPanda.jpg",
            "pandaNormal").applyCommand(model9);

    ICommand cmd9 = new GrayScaleIntensity("pandaNormal", "koalaRed");
    cmd9.applyCommand(model9);

    BufferedImage pandaNormal = model9.getImages().get("pandaNormal");
    BufferedImage koalaRed = model9.getImages().get("koalaRed");

    int counter = 0;

    for (int row = 0; row < pandaNormal.getHeight(); row++) {
      for (int col = 0; col < pandaNormal.getWidth(); col++) {
        Color color1 = new Color(pandaNormal.getRGB(col, row));
        Color color2 = new Color(pandaNormal.getRGB(col, row));
        if (color1.getRed() != color2.getRed()
                || color1.getRed() != color2.getGreen()
                || color1.getRed() != color2.getBlue()) {
          counter++;
        }
      }
    }

    Assert.assertEquals(counter, 0);
    Assert.assertEquals(model9.getImages().get("koalaRed") == null, false);
    Assert.assertEquals(model9.getImages().get("pandaNormal") == null, false);
  }

  @Test
  public void testGrayScaleValue() {
    IModel model10 = new ImplModel();
    new Load("/Users/nick/Documents/funnyPanda.jpg",
            "pandaNormal").applyCommand(model10);

    ICommand cmd10 = new GrayScaleIntensity("pandaNormal", "koalaValue");
    cmd10.applyCommand(model10);

    BufferedImage pandaNormal = model10.getImages().get("pandaNormal");
    BufferedImage koalaValue = model10.getImages().get("koalaValue");

    int counter = 0;

    for (int row = 0; row < pandaNormal.getHeight(); row++) {
      for (int col = 0; col < pandaNormal.getWidth(); col++) {
        Color color = new Color(koalaValue.getRGB(col, row));
        if (getValue(pandaNormal.getRGB(col, row)) != color.getRed()
                || getValue(pandaNormal.getRGB(col, row)) != color.getGreen()
                || getValue(pandaNormal.getRGB(col, row)) != color.getBlue()) {
          counter++;
        }
      }
    }

    Assert.assertEquals(counter, 0);
    Assert.assertEquals(model10.getImages().get("pandaNormal") == null, false);
    Assert.assertEquals(model10.getImages().get("koalaValue") == null, false);
  }

  @Test
  public void testBlur() {
    IModel model13 = new ImplModel();
    new Load("/Users/nick/Documents/My4x4test.ppm",
            "testPPM").applyCommand(model13);
    ICommand cmd11 = new Blur("testPPM", "newPPM");
    cmd11.applyCommand(model13);
    BufferedImage newPPM = model13.getImages().get("newPPM");

    for (int counter2 = 0; counter2 < newPPM.getWidth(); counter2++) {
      for (int counter = 0; counter < newPPM.getHeight(); counter++) {
        System.out.println(newPPM.getRGB(counter2, counter));
      }
    }

    Assert.assertEquals(newPPM.getRGB(0, 0), -10201019);
    Assert.assertEquals(newPPM.getRGB(0, 1), -14088243);
    Assert.assertEquals(newPPM.getRGB(0, 2), -796504);
    Assert.assertEquals(newPPM.getRGB(0, 3), -11845068);
    Assert.assertEquals(newPPM.getRGB(1, 0), -13620703);
    Assert.assertEquals(newPPM.getRGB(1, 1), -730711);
    Assert.assertEquals(newPPM.getRGB(1, 2), -13028825);
    Assert.assertEquals(newPPM.getRGB(1, 3), -204625);
    Assert.assertEquals(newPPM.getRGB(2, 0), -3887480);
    Assert.assertEquals(newPPM.getRGB(2, 1), -7899043);
    Assert.assertEquals(newPPM.getRGB(2, 2), -6123408);
    Assert.assertEquals(newPPM.getRGB(2, 3), -5334151);
    Assert.assertEquals(newPPM.getRGB(3, 0), -7044250);
    Assert.assertEquals(newPPM.getRGB(3, 1), -4347773);
    Assert.assertEquals(newPPM.getRGB(3, 2), -10529727);
    Assert.assertEquals(newPPM.getRGB(3, 3), -10792641);
  }

  @Test
  public void testSharpen() {
    IModel model15 = new ImplModel();
    new Load("/Users/nick/Documents/My4x4test.ppm",
            "testPPM").applyCommand(model15);
    ICommand cmd11 = new Sharpen("testPPM", "newPPM");
    cmd11.applyCommand(model15);
    BufferedImage newPPM = model15.getImages().get("newPPM");

    for (int counter2 = 0; counter2 < newPPM.getWidth(); counter2++) {
      for (int counter = 0; counter < newPPM.getHeight(); counter++) {
        System.out.println(newPPM.getRGB(counter2, counter));
      }
    }

    Assert.assertEquals(newPPM.getRGB(0, 0), -10201019);
    Assert.assertEquals(newPPM.getRGB(0, 1), -14088243);
    Assert.assertEquals(newPPM.getRGB(0, 2), -796504);
    Assert.assertEquals(newPPM.getRGB(0, 3), -11845068);
    Assert.assertEquals(newPPM.getRGB(1, 0), -13620703);
    Assert.assertEquals(newPPM.getRGB(1, 1), -730711);
    Assert.assertEquals(newPPM.getRGB(1, 2), -13028825);
    Assert.assertEquals(newPPM.getRGB(1, 3), -204625);
    Assert.assertEquals(newPPM.getRGB(2, 0), -3887480);
    Assert.assertEquals(newPPM.getRGB(2, 1), -7899043);
    Assert.assertEquals(newPPM.getRGB(2, 2), -6123408);
    Assert.assertEquals(newPPM.getRGB(2, 3), -5334151);
    Assert.assertEquals(newPPM.getRGB(3, 0), -7044250);
    Assert.assertEquals(newPPM.getRGB(3, 1), -4347773);
    Assert.assertEquals(newPPM.getRGB(3, 2), -10529727);
    Assert.assertEquals(newPPM.getRGB(3, 3), -10792641);
  }

  @Test
  public void testSepia() {
    IModel model14 = new ImplModel();
    new Load("/Users/nick/Documents/My4x4test.ppm",
            "testPPM").applyCommand(model14);
    ICommand cmd11 = new SepiaToneColorTransformation("testPPM", "newPPM");
    cmd11.applyCommand(model14);
    BufferedImage newPPM = model14.getImages().get("newPPM");

    Assert.assertEquals(newPPM.getRGB(0, 0), -10201019);
    Assert.assertEquals(newPPM.getRGB(0, 1), -14088243);
    Assert.assertEquals(newPPM.getRGB(0, 2), -796504);
    Assert.assertEquals(newPPM.getRGB(0, 3), -11845068);
    Assert.assertEquals(newPPM.getRGB(1, 0), -13620703);
    Assert.assertEquals(newPPM.getRGB(1, 1), -730711);
    Assert.assertEquals(newPPM.getRGB(1, 2), -13028825);
    Assert.assertEquals(newPPM.getRGB(1, 3), -204625);
    Assert.assertEquals(newPPM.getRGB(2, 0), -3887480);
    Assert.assertEquals(newPPM.getRGB(2, 1), -7899043);
    Assert.assertEquals(newPPM.getRGB(2, 2), -6123408);
    Assert.assertEquals(newPPM.getRGB(2, 3), -5334151);
    Assert.assertEquals(newPPM.getRGB(3, 0), -7044250);
    Assert.assertEquals(newPPM.getRGB(3, 1), -4347773);
    Assert.assertEquals(newPPM.getRGB(3, 2), -10529727);
    Assert.assertEquals(newPPM.getRGB(3, 3), -10792641);
  }


  @Test
  public void testLoad() {
    IModel model11 = new ImplModel();

    ICommand cmd11 = new Load("/Users/nick/Documents/funnyPanda.jpg", "KoalaOne");
    cmd11.applyCommand(model11);
    Assert.assertEquals(model11.getImages().size(), 1);
    Assert.assertEquals(model11.getImages().get("KoalaOne") == null, false);

    ICommand cmd2 = new Load("/Users/nick/Documents/funnyPanda.jpg", "KoalaBlue");
    cmd2.applyCommand(model11);
    Assert.assertEquals(model11.getImages().size(), 2);
    Assert.assertEquals(model11.getImages().get("KoalaBlue") == null, false);
  }

  @Test
  public void testExceptions() {
    IModel model12 = new ImplModel();
    ICommand cmd11 = new Load("/Users/nick/Documents/funnyPanda.jpg", "KoalaOne");
    cmd11.applyCommand(model12);

    assertThrows("", IllegalArgumentException.class, () -> new Brighten(0,
            "exampleName", "examplePath"));

    assertThrows("", IllegalArgumentException.class, () -> new Brighten(-1,
            "exampleName", "examplePath"));

    ICommand cmd12 = new Brighten(12, "KoalaOne", "KoalaOne");
    assertThrows("", IllegalArgumentException.class, () -> cmd12.applyCommand(model12));

    ICommand cmd13 = new Brighten(12, "ExampleName", "examplePath");
    assertThrows("", IllegalArgumentException.class, () -> cmd13.applyCommand(model12));

    assertThrows("", IllegalArgumentException.class, () -> new Darken(0,
            "exampleName", "examplePath"));

    assertThrows("", IllegalArgumentException.class, () -> new Darken(-1,
            "exampleName", "examplePath"));

    ICommand cmd14 = new Darken(12, "KoalaOne", "KoalaOne");
    assertThrows("", IllegalArgumentException.class, () -> cmd14.applyCommand(model12));

    ICommand cmd15 = new Darken(12, "ExampleName", "examplePath");
    assertThrows("", IllegalArgumentException.class, () -> cmd15.applyCommand(model12));

    ICommand cmd16 = new FlipHorizontally("KoalaOne", "KoalaOne");
    assertThrows("", IllegalArgumentException.class, () -> cmd16.applyCommand(model12));

    ICommand cmd17 = new FlipHorizontally("ExampleName", "examplePath");
    assertThrows("", IllegalArgumentException.class, () -> cmd17.applyCommand(model12));

    ICommand cmd18 = new FlipVertically("KoalaOne", "KoalaOne");
    assertThrows("", IllegalArgumentException.class, () -> cmd18.applyCommand(model12));

    ICommand cmd19 = new FlipVertically("ExampleName", "examplePath");
    assertThrows("", IllegalArgumentException.class, () -> cmd19.applyCommand(model12));

    ICommand cmd20 = new GrayScaleBlue("KoalaOne", "KoalaOne");
    assertThrows("", IllegalArgumentException.class, () -> cmd20.applyCommand(model12));

    ICommand cmd21 = new GrayScaleBlue("ExampleName", "examplePath");
    assertThrows("", IllegalArgumentException.class, () -> cmd21.applyCommand(model12));

    ICommand cmd22 = new GrayScaleGreen("KoalaOne", "KoalaOne");
    assertThrows("", IllegalArgumentException.class, () -> cmd22.applyCommand(model12));

    ICommand cmd23 = new GrayScaleGreen("ExampleName", "examplePath");
    assertThrows("", IllegalArgumentException.class, () -> cmd23.applyCommand(model12));

    ICommand cmd24 = new GrayScaleIntensity("KoalaOne", "KoalaOne");
    assertThrows("", IllegalArgumentException.class, () -> cmd24.applyCommand(model12));

    ICommand cmd25 = new GrayScaleIntensity("ExampleName", "examplePath");
    assertThrows("", IllegalArgumentException.class, () -> cmd25.applyCommand(model12));

    ICommand cmd26 = new GrayScaleLuma("KoalaOne", "KoalaOne");
    assertThrows("", IllegalArgumentException.class, () -> cmd26.applyCommand(model12));

    ICommand cmd27 = new GrayScaleLuma("ExampleName", "examplePath");
    assertThrows("", IllegalArgumentException.class, () -> cmd27.applyCommand(model12));

    ICommand cmd28 = new GrayScaleRed("KoalaOne", "KoalaOne");
    assertThrows("", IllegalArgumentException.class, () -> cmd20.applyCommand(model12));

    ICommand cmd29 = new GrayScaleRed("ExampleName", "examplePath");
    assertThrows("", IllegalArgumentException.class, () -> cmd29.applyCommand(model12));

    ICommand cmd30 = new GrayScaleValue("KoalaOne", "KoalaOne");
    assertThrows("", IllegalArgumentException.class, () -> cmd30.applyCommand(model12));

    ICommand cmd31 = new GrayScaleValue("ExampleName", "examplePath");
    assertThrows("", IllegalArgumentException.class, () -> cmd31.applyCommand(model12));

    ICommand cmd32 = new Load("KoalaOne", "KoalaOne");
    assertThrows("", IllegalArgumentException.class, () -> cmd32.applyCommand(model12));

    ICommand cmd33 = new Load("ExampleName", "examplePath");
    assertThrows("", IllegalArgumentException.class, () -> cmd33.applyCommand(model12));
  }

  @Test
  public void testLoadPPM() {
    IModel model = new ImplModel();
    new Load("/Users/lukecolombo/Desktop/IntelliJ/ImageProcessing/4x4colors.ppm",
            "test").applyCommand(model);
    BufferedImage img = model.getImages().get("test");
    Assert.assertEquals(model.getImages().size(), 1);
    Assert.assertNotNull(img);
    //model.display("test");
    Assert.assertEquals(4, img.getHeight());
    Assert.assertEquals(4, img.getWidth());
    // check each R,G, and B value of every single pixel
    // this is the first row
    Assert.assertEquals(255, getR(img.getRGB(0, 0)));
    Assert.assertEquals(0, getG(img.getRGB(0, 0)));
    Assert.assertEquals(0, getB(img.getRGB(0, 0)));
    Assert.assertEquals(0, getR(img.getRGB(1, 0)));
    Assert.assertEquals(255, getG(img.getRGB(1, 0)));
    Assert.assertEquals(0, getB(img.getRGB(1, 0)));
    Assert.assertEquals(0, getR(img.getRGB(2, 0)));
    Assert.assertEquals(0, getG(img.getRGB(2, 0)));
    Assert.assertEquals(255, getB(img.getRGB(2, 0)));
    Assert.assertEquals(255, getR(img.getRGB(3, 0)));
    Assert.assertEquals(255, getG(img.getRGB(3, 0)));
    Assert.assertEquals(0, getB(img.getRGB(3, 0)));
    //second row
    Assert.assertEquals(255, getR(img.getRGB(0, 1)));
    Assert.assertEquals(0, getG(img.getRGB(0, 1)));
    Assert.assertEquals(255, getB(img.getRGB(0, 1)));
    Assert.assertEquals(0, getR(img.getRGB(1, 1)));
    Assert.assertEquals(255, getG(img.getRGB(1, 1)));
    Assert.assertEquals(255, getB(img.getRGB(1, 1)));
    Assert.assertEquals(100, getR(img.getRGB(2, 1)));
    Assert.assertEquals(100, getG(img.getRGB(2, 1)));
    Assert.assertEquals(100, getB(img.getRGB(2, 1)));
    Assert.assertEquals(140, getR(img.getRGB(3, 1)));
    Assert.assertEquals(140, getG(img.getRGB(3, 1)));
    Assert.assertEquals(140, getB(img.getRGB(3, 1)));
  }

  @Test
  public void testConvertToFourChannel() {
    int result = convertToFourChannel(255, 255, 255);
    Assert.assertEquals(getR(result), 255);
    Assert.assertEquals(getR(result), 255);
    Assert.assertEquals(getR(result), 255);
    int result2 = convertToFourChannel(0, 0, 0);
    Assert.assertEquals(getR(result2), 0);
    Assert.assertEquals(getG(result2), 0);
    Assert.assertEquals(getB(result2), 0);
    int result3 = convertToFourChannel(100, 40, 190);
    Assert.assertEquals(getR(result3), 100);
    Assert.assertEquals(getG(result3), 40);
    Assert.assertEquals(getB(result3), 190);
  }


}
