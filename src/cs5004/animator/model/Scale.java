package cs5004.animator.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a scaling effect to be applied to a shape.
 */
public class Scale extends Motion {

  double startXRad;
  double startYRad;
  double endXRad;
  double endYRad;

  /**
   * Creates a motion representing a scaling effect on the shape.
   *
   * @param startXRad  x-radius (width) before the scaling
   * @param startYRad  y-radius (height) before the scaling
   * @param endXRad    x-radius after scaling
   * @param endYRad    y-radius after scaling
   * @param startFrame start of the motion
   * @param endFrame   end of the motion
   */
  protected Scale(double startXRad, double startYRad,
                  double endXRad, double endYRad,
                  int startFrame, int endFrame) {
    super(startFrame, endFrame, Transformations.SCALE);
    if (startXRad <= 0 || startYRad <= 0) {
      throw new IllegalArgumentException("X and Y-radii" +
              " must be positive.");
    }
    this.startXRad = startXRad;
    this.endXRad = endXRad;
    this.startYRad = startYRad;
    this.endYRad = endYRad;
  }

  /**
   * Returns a list of the relevant parameters of the motion (helpful for constructing an SVG
   * view).
   *
   * @return list containing [start x-rad, start y-rad, end x-rad, end y-rad]
   */
  @Override
  public List getParams() {
    List params = new ArrayList();
    params.add(startXRad);
    params.add(startYRad);
    params.add(endXRad);
    params.add(endYRad);

    return params;
  }

  @Override
  public String toString() {
    return "Resizing from " + startXRad + " x " + startYRad
            + " to " + endXRad + " x " + endYRad + ".";
  }
}
