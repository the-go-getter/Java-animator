package cs5004.animator.model;

import java.util.ArrayList;

/**
 * Contains constructors where the position of the ellipse's center is set to x and y and the
 * parameter 1, 2 are half the length  of xRadius, yRadius of the rectangle respectively.
 */
public class Ellipse extends AnimatableShape {
  /**
   * Default constructor where the position of the center is set to (0, 0) and the radius of the
   * xRadius is 1 and yRadius 1.
   */
  public Ellipse() {
    this("", 0, 0, 1, 1, 255, 255, 255, 0, 10, new ArrayList<>());
  }


  /**
   * Constructor which takes in all the parameters and sets the protected variables of the super
   * class accordingly.
   *
   * @param x       X-coordinate of the center.
   * @param y       Y-coordinate of the center.
   * @param xRadius Radius of the xRadius.
   * @param yRadius Radius of the yRadius.
   * @param r       The red component of this shape's color
   * @param g       The green component of this shape's color
   * @param b       The blue component of this shape's color.
   */
  public Ellipse(String id, double x, double y, double xRadius, double yRadius, double r, double g,
                 double b, int startOfLife, int endOfLife, ArrayList<IMotion> motions) {
    if (xRadius <= 0 || yRadius <= 0 || r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255) {
      throw new IllegalArgumentException("X-radius and Y-radius of the shape must be greater" +
              " than 0");
    }
    this.id = id;
    super.x = x;
    super.y = y;
    super.param1 = xRadius;
    super.param2 = yRadius;
    super.type = ShapeTypes.ELLIPSE;
    super.r = r;
    super.g = g;
    super.b = b;
    super.startOfLife = startOfLife;
    super.endOfLife = endOfLife;
    super.motions = motions;
  }
}
