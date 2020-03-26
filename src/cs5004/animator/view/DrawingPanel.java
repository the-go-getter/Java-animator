package cs5004.animator.view;

import java.awt.*;
import java.util.List;

import javax.swing.*;

import cs5004.animator.model.IReadOnlyShape;
import cs5004.animator.model.ShapeTypes;

/**
 * A class for the drawing panel of our Swing View which extends JPanel and implements the methods
 * offered by IDrawingPanel.
 */
public class DrawingPanel extends JPanel implements IDrawingPanel {

  List<IReadOnlyShape> shapesToDraw = null;

  @Override
  public void drawShapes(List<IReadOnlyShape> argShapesToDraw) {
    this.shapesToDraw = argShapesToDraw;
    //removeAll();
    repaint();
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (shapesToDraw != null) {
      //repaint();
      for (IReadOnlyShape shape : this.shapesToDraw) {
        /*
         (Lines 28-32) Our getColor method returns an array of double but we need three separate
         integer values representing the red, green and blue components of the color to build an
         awt type color,which is the type of color we require to set color of a Graphics type
         object.
        */
        int red = (int) Math.round(shape.getColor()[0] * 255);
        int green = (int) Math.round(shape.getColor()[1] * 255);
        int blue = (int) Math.round(shape.getColor()[2] * 255);
        Color awtColor = new Color(red, green, blue);
        g.setColor(awtColor);
        if (shape.getShapeType() == ShapeTypes.RECTANGLE) {
          g.fillRect((int) shape.getX(), (int) shape.getY(),
                  (int) shape.getParam1(), (int) shape.getParam2());
        } else {
          g.fillOval((int) shape.getX(), (int) shape.getY(),
                  (int) shape.getParam1(), (int) shape.getParam2());
        }
      }
    }
  }
}
