package cs5004.animator.model;

import java.util.ArrayList;
import java.util.List;

import cs5004.animator.util.TweenModelBuilder;

/**
 * Model containing the shapes and associated animations for a given animation session.  A unique
 * string ID is associated with each shape. A shape's animation can be found in a second mapping.
 * This modularity allows for ease of applying the same animation to multiple shapes. (E.g. could
 * have several circles all moving in the same way for the duration of the animation.)
 */
public class AniModel implements IModel {

  ArrayList<IAnimatableShape> mutableShapes;

  /**
   * Creates an instance of the animation model with a list of animatable shapes.
   */
  public AniModel() {

    this.mutableShapes = new ArrayList<>();
  }


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
  @Override
  public void addShape(String id, ShapeTypes shape, double x, double y, double h, double w,
                       double r, double g, double b, int start, int end,
                       ArrayList<IMotion> motions) {

    if (shape == ShapeTypes.ELLIPSE) {
      mutableShapes.add(new Ellipse(id, x, y, h, w, r, g, b, start, end, motions));
    } else {
      mutableShapes.add(new Rectangle(id, x, y, h, w, r, g, b, start, end, motions));
    }
  }

  /**
   * Removes from the model the shape and animation linked to the given string ID.
   *
   * @param id unique string identifier
   */
  @Override
  public void removeShape(String id) {
    IAnimatableShape shape = findShape(id);
    if (shape == null) {
      throw new IllegalArgumentException("No shape exists with that id\n");
    }
    mutableShapes.remove(shape);
  }

  /**
   * Returns a string representation of the shapes contained in the model paired with their
   * associated animations.
   *
   * @return string listing of shapes and animations
   */
  @Override
  public String getState(int fps) {

    String state = "";

    for (IAnimatableShape shape : mutableShapes) {
      state += "\nName: " + shape.getId() + "\nType: ";
      if (shape instanceof Rectangle) {
        state += "rectangle\n";
      } else {
        state += "oval\n";
      }

      // For 2 fps | can abstract this later
      state += "Appears at t=" + (shape.getFirstFrame() * 1000 / fps) + " ms";
      state += "\nDisappears at t=" + (shape.getLastFrame() * 1000 / fps) + " ms";
    }

    state += "\n";

    for (IAnimatableShape shape : mutableShapes) {
      for (IMotion motion : shape.getAllMotions()) {
        state += "\nShape " + shape.getId() + " " + motion.toString() + "\n";
      }
    }

    return state;
  }

  /**
   * Returns a list containing all the shapes in the model.
   *
   * @return list of all shapes
   */
  @Override
  public List<IReadOnlyShape> getAllShapes() {
    List<IReadOnlyShape> readOnlyShapes = new ArrayList<>(mutableShapes);
    return readOnlyShapes;
  }

  /**
   * Adds a given motion to the list of motions contained by the shape associated with the given
   * ID.
   *
   * @param id     identifier for the shape
   * @param motion motion to be added
   */
  @Override
  public void addMotion(String id, IMotion motion) {
    IAnimatableShape shape = findShape(id);
    if (shape == null) {
      throw new IllegalArgumentException("No shape exists with that id\n");
    }
    shape.addMotion(motion);
  }

  // Helper function to return the shape associated with the given ID.
  private IAnimatableShape findShape(String id) {
    if (mutableShapes != null) {
      for (IAnimatableShape shape : mutableShapes) {
        if (shape.getId().equals(id)) {
          return shape;
        }
      }
    }
    return null;
  }

  @Override
  public List<IReadOnlyShape> produceFrame(int frame) {

    List<IReadOnlyShape> interpolated = new ArrayList<>();

    for (IAnimatableShape shape : mutableShapes) {
      if (shape.getFirstFrame() <= frame && shape.getLastFrame() >= frame) {
        for (IMotion motion : shape.getAllMotions()) {
          if (motion.getFirstFrame() <= frame && motion.getLastFrame() >= frame) {
            List params = motion.getParams();
            switch (motion.getType()) {
              case TRANSLATION:
                shape.setX(motion.tween((double) params.get(0), (double) params.get(2), frame));
                shape.setY(motion.tween((double) params.get(1), (double) params.get(3), frame));
                break;
              case SCALE:
                shape.setW(motion.tween((double) params.get(0), (double) params.get(2), frame));
                shape.setH(motion.tween((double) params.get(1), (double) params.get(3), frame));
                break;
              case COLORSHIFT:
                double r = (motion.tween((double) params.get(0), (double) params.get(2), frame));
                double g = (motion.tween((double) params.get(0), (double) params.get(2), frame));
                double b = (motion.tween((double) params.get(0), (double) params.get(2), frame));
                double[] newCol = {r, g, b};
                shape.setColor(newCol);
                break;
              default:
                throw new UnsupportedOperationException("No valid interpolation for given motion.");
            }
          }
        }
        interpolated.add(shape);
      }
    }
    return interpolated;
  }


  //---------------------------------------------------
  // Embedded class to serve as an intermediary between our model implementation
  // and the animation file reader.
  static TweenModelBuilder getBuilder() {
    return new ModelBuilder();
  }

  /**
   * A static class which implements the methods in TweenBuilder Interface to build a new IModel
   * object.
   */
  public static class ModelBuilder implements TweenModelBuilder {
    IModel model;

    public ModelBuilder() {
      model = new AniModel();
    }

    @Override
    public TweenModelBuilder addOval(String name, float cx, float cy, float xRadius, float yRadius,
                                     float red, float green, float blue, int startOfLife,
                                     int endOfLife) {
      model.addShape(name, ShapeTypes.ELLIPSE, cx, cy, xRadius, yRadius, red, green, blue,
              startOfLife, endOfLife, new ArrayList<>());
      return this;
    }

    @Override
    public TweenModelBuilder addRectangle(String name, float lx, float ly,
                                          float width, float height, float red,
                                          float green, float blue, int startOfLife,
                                          int endOfLife) {
      model.addShape(name, ShapeTypes.RECTANGLE, lx, ly, width, height, red, green, blue,
              startOfLife, endOfLife, new ArrayList<>());
      return this;
    }

    @Override
    public TweenModelBuilder addMove(String name, float moveFromX, float moveFromY,
                                     float moveToX, float moveToY, int startTime, int endTime) {
      IMotion newMotion = new Translation(moveFromX, moveFromY, moveToX, moveToY,
              startTime, endTime);
      model.addMotion(name, newMotion);
      return this;
    }

    @Override
    public TweenModelBuilder addColorChange(String name, float oldR, float oldG, float oldB,
                                            float newR, float newG, float newB, int startTime,
                                            int endTime) {
      IMotion newMotion = new ColorShift(oldR, oldG, oldB, newR, newG, newB, startTime, endTime);
      model.addMotion(name, newMotion);
      return this;
    }

    @Override
    public TweenModelBuilder addScaleToChange(String name, float fromSx, float fromSy,
                                              float toSx, float toSy, int startTime, int endTime) {
      IMotion newMotion = new Scale(fromSx, fromSy, toSx, toSy, startTime, endTime);
      model.addMotion(name, newMotion);
      return this;
    }

    @Override
    public IModel build() {
      return model;
    }
  }
}
