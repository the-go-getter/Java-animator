package cs5004.animator.model;

/**
 * Class representing an animatable shape for the animation (i.e. can have parameters set and
 * motions added).
 */
public class AnimatableShape extends AbstractShape implements IAnimatableShape {

  @Override
  public void setX(double x) {
    this.x = x;
  }

  @Override
  public void setY(double y) {
    this.y = y;
  }

  @Override
  public void setW(double w) {
    this.param1 = w;
  }

  @Override
  public void setH(double h) {
    this.param2 = h;
  }

  @Override
  public void setColor(double[] color) {
    if (color.length < 3) {
      throw new IllegalArgumentException("Values for R, G, and B must be supplied\n");
    }
    this.r = color[0];
    this.g = color[1];
    this.b = color[2];
  }

  /**
   * Adds a new motion to the animation.  This also updates the first and last frame fields of the
   * animation.
   *
   * @param motion the motion to be added
   */
  @Override
  public void addMotion(IMotion motion) {

    int mStart = motion.getFirstFrame();
    int mEnd = motion.getLastFrame();

    // Checking if the motion is within the lifetime of the shape.
    if (mStart < startOfLife || mEnd > endOfLife) {
      throw new IllegalArgumentException("Start and end frames must be within start/end of" +
              " life range for the shape.");
    }

    motions.add(motion);
  }

  /**
   * Removes the given motion from the animation.  This also updates the first and last
   * frame fields of the animation.
   *
   * @param motion the motion to be removed
   */
  @Override
  public void removeMotion(IMotion motion) {

    // Does this remove all the motions of this type or only the first one?
    motions.remove(motion);
    startOfLife = -1;
    endOfLife = 0;
    for (IMotion motionIterator : motions) {
      if (motionIterator.getFirstFrame() < startOfLife || startOfLife == -1) {
        startOfLife = motionIterator.getFirstFrame();
      }
      if (motionIterator.getLastFrame() > endOfLife) {
        endOfLife = motionIterator.getLastFrame();
      }
    }
  }
}
