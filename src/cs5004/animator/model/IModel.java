package cs5004.animator.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines the methods offered by a model containing the shapes of the animation.
 */
public interface IModel {

  /**
   * Adds a new shape with the given parameters to the model. Also adds an empty animation
   * associated with the ID.
   *
   * @param id      string identifier for the shape and animation
   * @param shape   the type of shape
   * @param x       horizontal position
   * @param y       vertical position
   * @param h       height (y-radius)
   * @param w       width (x-radius)
   * @param r       red component of the shape's color
   * @param g       green component of the shape's color
   * @param b       blue component of the shape's color
   * @param start   start of life for the shape
   * @param end     end of life for the shape
   * @param motions list of all the motions to be applied for this shape
   */
  void addShape(String id, ShapeTypes shape, double x, double y, double h, double w,
                double r, double g, double b, int start, int end, ArrayList<IMotion> motions);

  /**
   * Removes from the model the shape and animation linked to the given string ID.
   *
   * @param id unique string identifier
   */
  void removeShape(String id);

  /**
   * Returns a string representation of the shapes contained in the model paired with their
   * associated animations.
   *
   * @return string listing of shapes and animations
   */
  String getState(int fps);

  /**
   * Returns a list containing all the shapes in the model.
   *
   * @return list of all shapes
   */
  java.util.List<IReadOnlyShape> getAllShapes();

  /**
   * Adds a given motion to the list of motions contained by the shape associated with the given
   * ID.
   *
   * @param id     identifier for the shape
   * @param motion motion to be added
   */
  void addMotion(String id, IMotion motion);

  /**
   * Produces a list of shapes which should be drawn on the given frame.
   *
   * @param frame given frame of animation
   * @return list of shapes
   */
  List<IReadOnlyShape> produceFrame(int frame);
}
