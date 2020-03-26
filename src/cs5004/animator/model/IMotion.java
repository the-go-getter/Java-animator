package cs5004.animator.model;

import java.util.List;

/**
 * Interface containing the methods that should be implemented by a motion class. Classes like
 * Translation, Rotation, Scale and ColorShift which are yet to be implemented.
 */
public interface IMotion {

  /**
   * Returns the first frame of the motion's activity.
   *
   * @return first frame
   */
  int getFirstFrame();

  /**
   * Returns the last frame of the motion's activity.
   *
   * @return last frame
   */
  int getLastFrame();

  /**
   * Returns a list of the relevant parameters of the motion (helpful for constructing an SVG
   * view).
   *
   * @return list of relevant paramters for the motion
   */
  List getParams();

  /**
   * Returns a string representation of the motion, including info such as start/end time and the
   * type and specifics of transformation.
   *
   * @return string representation of motion
   */
  @Override
  String toString();

  /**
   * Returns the type of transformation the Motion is (e.g. Translation).
   *
   * @return type of transformation
   */
  Transformations getType();

  /**
   * Produces a list of shapes which should be drawn on the given frame.
   * @param frame given frame of animation
   * @return list of shapes
   */

  /**
   * Interpolates shape parameters for the current frame.
   *
   * @param a     start value of parameter
   * @param b     end value of parameter
   * @param frame current frame
   * @return interpolated value for parameter on the given frame
   */
  double tween(double a, double b, int frame);
}