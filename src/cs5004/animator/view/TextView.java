package cs5004.animator.view;

import java.util.List;

import cs5004.animator.model.IModel;
import cs5004.animator.model.IReadOnlyShape;

/**
 * Text-based view for the animation.
 */
public class TextView implements IView {

  /**
   * Displays info about the model's state in a textual format. Includes info such as the shape ID
   * and associated motions.
   *
   * @param model the model to render the state of
   * @param out   the output source
   * @param fps   the frames-per-second rate of animation
   */
  @Override
  public void render(IModel model, Appendable out, int fps) {

    try {
      out.append(model.getState(fps));
    } catch (Exception ignore) {
      // Ignore.
    }
  }

  @Override
  public void render(List<IReadOnlyShape> shapes) {
    // Having this method here so that IView can be used.
  }

  @Override
  public void showWindow(boolean value) {
    // Having this method here so that IView can be used.
  }
}
