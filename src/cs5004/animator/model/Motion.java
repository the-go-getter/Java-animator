package cs5004.animator.model;

/**
 * Class containing the common elements of motions in an animation (i.e. the start and end frames of
 * the motion).
 */
public abstract class Motion implements IMotion {

  // Start and end frames.
  protected int start;
  protected int end;

  protected final Transformations type;

  /**
   * Creates a motion with the given start and end frames.
   *
   * @param start beginning of motion
   * @param end   end of motion
   */
  protected Motion(int start, int end, Transformations type) {
    if (start >= 0 && end >= 0 && start != end) {
      this.start = start;
      this.end = end;
    } else {
      throw new IllegalArgumentException("Start and end" +
              " frames must be different and at least 0.");
    }

    this.type = type;
  }

  @Override
  public int getFirstFrame() {
    return start;
  }

  @Override
  public int getLastFrame() {
    return end;
  }

  @Override
  public Transformations getType() {
    return this.type;
  }

  // Calculates the intermediate values for a shape
  // on the given frame.
  @Override
  public double tween(double a, double b, int frame) {

    if (frame < this.start || frame > this.end) {
      throw new IllegalArgumentException("nnfesf");
    }
    int timeDiff = this.end - this.start;
    double term1 = a * (this.end - frame) / (timeDiff);
    double term2 = b * (frame - this.start) / (timeDiff);

    return term1 + term2;
  }

}