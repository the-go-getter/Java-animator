package cs5004.animator.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a geometric translation motion.
 */
public class Translation extends Motion {

  private double startX;
  private double endX;
  private double startY;
  private double endY;

  /**
   * Creates a motion representing a geometric translation (linear movement).
   *
   * @param startX     starting x-coordinate (lower left corner for rectangle, center for ellipse)
   * @param startY     starting y-coordinate
   * @param endX       ending x-coordinate
   * @param endY       ending y-coordinate
   * @param startFrame start of the motion
   * @param endFrame   end of the motion
   */
  public Translation(double startX, double startY,
                     double endX, double endY,
                     int startFrame, int endFrame) {
    super(startFrame, endFrame, Transformations.TRANSLATION);
    this.startX = startX;
    this.startY = startY;
    this.endX = endX;
    this.endY = endY;
  }

  /**
   * Returns a list of the relevant parameters of the motion (helpful for constructing an SVG
   * view).
   *
   * @return list containing [start x, start y, end x, end y]
   */
  @Override
  public List getParams() {
    List params = new ArrayList();
    params.add(startX);
    params.add(startY);
    params.add(endX);
    params.add(endY);

    return params;
  }

  @Override
  public String toString() {
    return "Move from (" + startX + ", " + startY + ") to"
            + " (" + endX + ", " + endY + ") from frames " + this.start
            + " to " + this.end + ".";
  }
}
