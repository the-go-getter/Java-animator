package cs5004.animator.controller;

import cs5004.animator.model.IModel;
import cs5004.animator.view.IView;

/**
 * Class designed to create the appropriate controller for our application.
 */
public class ControllerFactory {

  /**
   * Generates the controller based on the view selected because SwingView would require a different
   * controller in our implementation.
   *
   * @param model    The model passed into the controller.
   * @param view     The view passed into the controller.
   * @param viewType The type of the view passed as a string.
   * @param output   destination for output (e.g. System.out or file)
   * @param fps      speed of the animation
   */
  public static IController make(IModel model, IView view, String viewType,
                                 Appendable output, int fps) {
    if (viewType.equals("swing")) {
      return new SwingController(view, model, fps);
    }
    return new AniController(model, output, fps);
  }
}
