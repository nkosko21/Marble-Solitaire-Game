package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.controller.MarbleSolitaireGUIFeatures;

public class MockView implements MarbleSolitaireGuiView {
  private final StringBuilder log;

  public MockView(StringBuilder log) {
    this.log = log;
  }

  @Override
  public void refresh() {
    log.append("Refreshed");
  }

  @Override
  public void renderMessage(String message) {
    log.append(message);
  }

  @Override
  public void giveFeatureToController(MarbleSolitaireGUIFeatures feature) {

  }

  @Override
  public void highlight(int row, int col) {

  }


}
