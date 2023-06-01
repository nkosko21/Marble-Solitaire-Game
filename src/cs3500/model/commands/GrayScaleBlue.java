package cs3500.model.commands;

import cs3500.model.IModel;

/**
 * Function object to grayscale an image using its blue value.
 * This means each pixel's r, g, and b values are set to the b value.
 */
public class GrayScaleBlue implements ICommand {
  private final String fileName;
  private final String filePath;

  /**
   * Constructor to create an instance of this function object with both fields.
   * @param fileName which file to perform the action on.
   * @param filePath what the new name of the file will be.
   */
  public GrayScaleBlue(String fileName, String filePath) {
    this.fileName = fileName;
    this.filePath = filePath;
  }


  @Override
  public void applyCommand(IModel m) {

    m.grayScaleBlue(this.fileName, this.filePath);
  }
}
