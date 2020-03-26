package cs5004.animator.model;

/**
 * Interface detailing the methods that should be provided by an class representing an animatable
 * shape.
 */
public interface IAnimatableShape extends IReadOnlyShape {

  /**
   * Sets the x-coordinate of the shape's lower-left corner (or center, if an ellipse).
   *
   * @param x x-coordinate
   */
  void setX(double x);

  /**
   * Sets the y-coordinate of the shape's lower-left corner (or center, if an ellipse).
   *
   * @param y y-coordinate
   */
  void setY(double y);

  /**
   * Sets the width (x-radius) of the shape.
   *
   * @param w width
   */
  void setW(double w);

  /**
   * Sets the height (y-radius) of the shape.
   *
   * @param h height
   */
  void setH(double h);

  /**
   * Sets the RGB values of the shape's color.
   *
   * @param color triplet of valid RGB values
   */
  void setColor(double[] color);

  /**
   * Adds a motion to the shape's list of motions.
   *
   * @param motion motion to be added to the animation
   */

  void addMotion(IMotion motion);

  /**
   * Removes a motion from the shape's list of motions.
   *
   * @param motion motion to be removed from the animation
   */
  void removeMotion(IMotion motion);
}
