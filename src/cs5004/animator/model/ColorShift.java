package cs5004.animator.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a shift in RGB color for a given shape.
 */
public class ColorShift extends Motion {

  private double startRed;
  private double startGreen;
  private double startBlue;
  private double endRed;
  private double endGreen;
  private double endBlue;

  // Helper function that determines whether a given set of RGB values is valid.
  private boolean isValidRGB(double r, double g, double b) {
    return !((r < 0) || (r > 255) || (g < 0) || (g > 255) || (b < 0) || (b > 255));
  }

  /**
   * Creates a motion representing a color shift of the shape.
   *
   * @param startR     red value before shift
   * @param startG     green value before shift
   * @param startB     blue value before shift
   * @param endR       red value after shift
   * @param endG       green value after shift
   * @param endB       blue value after shift
   * @param startFrame start of the motion
   * @param endFrame   end of the motion
   */
  protected ColorShift(double startR, double startG, double startB,
                       double endR, double endG, double endB,
                       int startFrame, int endFrame) {
    super(startFrame, endFrame, Transformations.COLORSHIFT);
    if (!isValidRGB(startR, startG, startB) || !isValidRGB(endR, endG, endB)) {
      throw new IllegalArgumentException("RGB values must be between 0-255, inclusive.");
    }
    this.startRed = startR;
    this.startGreen = startG;
    this.startBlue = startB;
    this.endRed = endR;
    this.endGreen = endG;
    this.endBlue = endB;
  }

  /**
   * Returns a list of the relevant parameters of the motion (helpful for constructing an SVG
   * view).
   *
   * @return list containing [start R, start G, start B, end R, end G, end B]
   */
  @Override
  public List getParams() {
    List params = new ArrayList();
    params.add(startRed);
    params.add(startGreen);
    params.add(startBlue);
    params.add(endRed);
    params.add(endGreen);
    params.add(endBlue);

    return params;
  }

  @Override
  public String toString() {
    String out = String.format("Shifting color from ( %.3f, %.3f, %.3f ) to ( %.3f, %.3f, %.3f )"
            , startRed, startGreen, startBlue, endRed, endGreen, endBlue);
    return out;
  }
}
