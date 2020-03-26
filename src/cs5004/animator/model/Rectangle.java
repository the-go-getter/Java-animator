package cs5004.animator.model;

import java.util.ArrayList;

/**
 * Contains constructors where the position of the lower left corner is set to x and y and the
 * parameter 1, 2 are the width, height of the rectangle respectively.
 */
public class Rectangle extends AnimatableShape {

  /**
   * Default constructor where the position of the lower left corner is set to (0, 0) and the width
   * and height are 1. Default color is white and duration of the shape's life is first 10 ticks,
   */
  public Rectangle() {
    this("", 0, 0, 1, 1, 255, 255, 255, 0, 10, new ArrayList<>());
  }


  /**
   * Constructor which takes in all the parameters and sets the protected variables of the super
   * class.
   *
   * @param x      X-coordinate of the lower left corner's position.
   * @param y      Y-coordinate of the lower left corner's position.
   * @param width  Width of this rectangle.
   * @param height Height of this rectangle.
   * @param r      The red component of this shape's color
   * @param g      The green component of this shape's color
   * @param b      The blue component of this shape's color
   */
  public Rectangle(String id, double x, double y, double width, double height, double r,
                   double g, double b, int startOfLife, int endOfLife,
                   ArrayList<IMotion> motions) {
    if (width <= 0 || height <= 0 || r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255) {
      throw new IllegalArgumentException("Width and Height of the shape must be greater" +
              " than 0. RGB values must be between 0 and 255");
    }
    super.id = id;
    super.x = x;
    super.y = y;
    super.param1 = width;
    super.param2 = height;
    super.type = ShapeTypes.RECTANGLE;
    super.r = r;
    super.g = g;
    super.b = b;
    super.startOfLife = startOfLife;
    super.endOfLife = endOfLife;
    super.motions = motions;
  }
}
