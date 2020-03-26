package cs5004.animator.model;

import java.util.ArrayList;

/**
 * An interface to represent the operations offered by an IReadOnlyShape object.
 */
public interface IReadOnlyShape {
  /**
   * Getter for the id of a particular shape.
   *
   * @return The id of the shape .
   */
  String getId();

  /**
   * Getter for the x-coordinate of a particular shape.
   *
   * @return The x coordinate of the shape .
   */
  double getX();

  /**
   * Getter for the y-coordinate of a particular shape.
   *
   * @return The y coordinate of the shape .
   */
  double getY();

  /**
   * Getter for the first parameter of a particular shape. Example, width for rectang;le.
   *
   * @return The first parameter of the shape .
   */
  double getParam1();

  /**
   * Getter for the second parameter of a particular shape. Example, height for rectangle.
   *
   * @return The second parameter of the shape .
   */
  double getParam2();

  /**
   * Getter for the color of the shape.
   *
   * @return the color of this shape represented by an array of size 3 containing doubles
   * representing the red, blue and green components of the color.
   */
  Double[] getColor();

  /**
   * Getter for the type of the shape.
   *
   * @return An enumerator ShapeType representing the type of the shape .
   */
  ShapeTypes getShapeType();

  /**
   * Getter for the initial frame of animation for the given shape (start of life).
   *
   * @return first frame of shape's animation
   */
  int getFirstFrame();

  /**
   * Getter for the last frame of animation for the given shape (end of life).
   *
   * @return last frame of shape's animation
   */
  int getLastFrame();

  /**
   * Gets a list of all motions performed by the shape.
   *
   * @return all motions in the shape's animation
   */
  ArrayList<IMotion> getAllMotions();
}
