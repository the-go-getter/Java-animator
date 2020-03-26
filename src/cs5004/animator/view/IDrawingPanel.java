package cs5004.animator.view;

import java.util.List;

import cs5004.animator.model.IReadOnlyShape;

/**
 * This is an interface for all the drawing panels which offers methods like drawShpaes.
 */
public interface IDrawingPanel {

  /**
   * This mathod takes in a list of the shapes to be drawn and draws them on a JPanel.
   *
   * @param argShapesToDraw The array list containing all the shapes to be drawn on the JPanel.
   */
  void drawShapes(List<IReadOnlyShape> argShapesToDraw);
}
