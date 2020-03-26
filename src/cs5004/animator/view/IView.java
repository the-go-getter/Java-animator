package cs5004.animator.view;

import java.util.List;

import cs5004.animator.model.IModel;
import cs5004.animator.model.IReadOnlyShape;

/**
 * Contains the methods that should be supported by a view for the animation.
 */
public interface IView {

  /**
   * Renders the list of shapes and their motions in the text and svg views.
   *
   * @param model the model to render the state of
   * @param out   the output source
   */
  void render(IModel model, Appendable out, int fps);

  /**
   * Same as the render function above except this one is used only by swing view.
   */
  void render(List<IReadOnlyShape> shapes);

  /**
   * A method to show the window based on the given boolean value.
   *
   * @param value The input boolean value.
   */
  void showWindow(boolean value);
}