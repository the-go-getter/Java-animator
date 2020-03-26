package cs5004.animator.controller;

import javax.swing.*;

import cs5004.animator.model.IModel;
import cs5004.animator.view.IView;

/**
 * A controller made for our animator application's swing view.
 */
public class SwingController implements IController {
  IView view;
  IModel model;
  Timer timer;
  int currentFrame;

  /**
   * The constructor for Swing Controller which takes in the appropriate view, model and frames to
   * be displayed per second.
   * @param view The view which will display the appropriate output.
   * @param model The model to generate the output.
   * @param fps The number of frames to be
   */
  public SwingController(IView view, IModel model, int fps) {
    this.view = view;
    this.model = model;
    currentFrame = 0;
    timer = new Timer(1000 / fps, e -> {
      view.render(model.produceFrame(currentFrame));
      currentFrame++;
    });
  }

  @Override
  public void run(IView view) {
    timer.start();
  }
}
