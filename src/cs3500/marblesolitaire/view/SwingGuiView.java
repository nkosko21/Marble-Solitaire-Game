package cs3500.marblesolitaire.view;

import java.awt.*;

import javax.swing.*;

//import cs3500.marblesolitaire.controller.ControllerFeatures;
import cs3500.marblesolitaire.controller.MarbleSolitaireGUIFeatures;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * This class represents a GUI view that is implemented using Java
 * Swing.
 */
public class SwingGuiView extends JFrame implements MarbleSolitaireGuiView {

  //the custom panel on which the board will be drawn
  private BoardPanelGUI boardPanel;
  //the model state
  private MarbleSolitaireModelState modelState;
  //a label to display the score
  private JLabel scoreLabel;
  //a label to display any messages to the user
  private JLabel messageLabel;
  //a square that highlights a certain cell
  private JLabel highlight;

  public SwingGuiView(MarbleSolitaireModelState state) {
    super("Marble solitaire");
    this.modelState = state;
    /* main frame uses a border layout. Read about it here:
    *
    * */
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());
    //initialize the custom board with the model state
    boardPanel = new BoardPanel(this.modelState);
    //add custom board to the center of the frame
    this.add((Component) boardPanel,BorderLayout.CENTER);
    //create the score label
    this.scoreLabel = new JLabel();
    //create the message label
    this.messageLabel = new JLabel();
    //put them both in a panel. This is done mostly to arrange them properly
    JPanel panel = new JPanel();
    /*
    the panel uses a grid layout with two columns. The gridlayout
    will stretch the labels so that they are exactly half of the width
    of this panel.

    Since we mention that we want a grid of 2 columns, and we
    add exactly two things to it, it will use one row.
     */

    panel.setLayout(new GridLayout(0,2));
    panel.add(scoreLabel);
    panel.add(messageLabel);
    //add this panel to the bottom of the frame
    this.add(panel,BorderLayout.PAGE_END);
    pack();
    setVisible(true);
  }

  public void refresh() {
    //refresh the score
    this.scoreLabel.setText("Score: "+modelState.getScore());
    //this repaints the frame, which cascades to everything added
    //in the frame
    this.repaint();
  }

  @Override
  public void highlight(int row, int col) {
    this.boardPanel.setHighlightCoordinates(row, col);
  }

  @Override
  public void renderMessage(String message) {
    this.messageLabel.setText(message);
  }

  @Override
  public void giveFeatureToController(MarbleSolitaireGUIFeatures feature) {
    this.boardPanel.addFeature(feature);
  }
}

