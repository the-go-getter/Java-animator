package cs5004.animator.controller;

import java.util.Objects;

import cs5004.animator.model.IModel;
import cs5004.animator.view.IView;

/**
 * A controller made for our animator application's text view and svg view.
 */
public class AniController implements IController {

  IModel model;
  Appendable out;
  int fps;

  /**
   * Creates a controller for the animator using the given model, output
   * destination, and frames-per-second speed.
   * @param model model for the animator
   * @param out destination for output (e.g. System.out or file)
   * @param fps speed of the animation
   */
  public AniController(IModel model, Appendable out, int fps) {
    Objects.requireNonNull(model);
    this.model = model;

    Objects.requireNonNull(out);
    this.out = out;

    if (fps > 0) {
      this.fps = fps;
    }
  }

  @Override
  public void run(IView view) {
    view.render(this.model, this.out, fps);
  }
}
