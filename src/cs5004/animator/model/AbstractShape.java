package cs5004.animator.model;

import java.util.ArrayList;

/**
 * An abstract class to implement getters for IReadOnlyShape objects.
 */
public abstract class AbstractShape implements IReadOnlyShape {

  protected String id;
  protected double x;
  protected double y;
  protected double param1;
  protected double param2;
  protected ShapeTypes type;
  protected double r;
  protected double g;
  protected double b;
  protected int startOfLife;
  protected int endOfLife;
  protected ArrayList<IMotion> motions;

  @Override
  public String getId() {
    return id;
  }

  @Override
  public double getX() {
    return x;
  }

  @Override
  public double getY() {
    return y;
  }

  @Override
  public double getParam1() {
    return param1;
  }

  @Override
  public double getParam2() {
    return param2;
  }

  @Override
  public ShapeTypes getShapeType() {
    return this.type;
  }

  @Override
  public Double[] getColor() {
    return new Double[]{this.r, this.g, this.b};
  }

  @Override
  public int getFirstFrame() {
    return startOfLife;
  }

  @Override
  public int getLastFrame() {
    return endOfLife;
  }

  @Override
  public ArrayList<IMotion> getAllMotions() {
    return motions;
  }
}
