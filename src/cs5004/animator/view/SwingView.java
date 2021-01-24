package cs5004.animator.view;

import java.awt.*;
import java.util.List;

import javax.swing.*;

import cs5004.animator.model.IModel;
import cs5004.animator.model.IReadOnlyShape;

/**
 * A class to implement the swing view.
 */
public class SwingView extends JFrame implements IView {
  DrawingPanel drawingPanel;
  JButton play;
  JButton pause;

  /**
   * A constructor for the swing view class.
   */
  public SwingView() {
    drawingPanel = new DrawingPanel();
    drawingPanel.setBackground(Color.white);
    drawingPanel.setPreferredSize(new Dimension(1500,1500));
    setSize(1000, 1000);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    JScrollPane pane = new JScrollPane(drawingPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    setLayout(new BorderLayout());
    add(pane, BorderLayout.CENTER);
    setVisible(true);
  }

  @Override
  public void render(IModel model, Appendable out, int fps) {
    drawingPanel.drawShapes(model.getAllShapes());
  }

  @Override
  public void render(List<IReadOnlyShape> shapes) {
    drawingPanel.drawShapes(shapes);
  }

  @Override
  public void showWindow(boolean value) {
    setVisible(value);
  }
}