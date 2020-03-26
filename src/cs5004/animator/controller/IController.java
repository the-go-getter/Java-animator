package cs5004.animator.controller;

import cs5004.animator.view.IView;

/**
 * Interface detailing the method(s) which should be implemented by a controller for the animator.
 */
public interface IController {

  /**
   * Runs the animator using the given view (e.g. SVG).
   *
   * @param view the given view
   */
  void run(IView view);
}
