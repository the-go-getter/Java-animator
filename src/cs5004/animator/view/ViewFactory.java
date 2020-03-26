package cs5004.animator.view;

/**
 * Class designed to create the appropriate views for use by the controller.
 */
public class ViewFactory {

  /**
   * Constructs the appropriate view based on the selected type (SVG/Text).
   *
   * @param viewType name of the selected view type
   * @return the created view
   */
  public static IView makeView(String viewType) {

    IView view;
    if (viewType.equals("svg")) {
      view = new SVGView();
    } else if (viewType.equals("swing")) {
      view = new SwingView();
      view.showWindow(true);
    } else {
      view = new TextView();
    }

    return view;
  }


}
