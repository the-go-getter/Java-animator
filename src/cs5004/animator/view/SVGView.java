package cs5004.animator.view;

import java.io.IOException;
import java.util.List;

import cs5004.animator.model.ColorShift;
import cs5004.animator.model.IModel;
import cs5004.animator.model.IMotion;
import cs5004.animator.model.IReadOnlyShape;
import cs5004.animator.model.Rectangle;
import cs5004.animator.model.Translation;

/**
 * View designed to format animation info for export into an SVG file.
 */
public class SVGView implements IView {

  /**
   * Formats the given model state into SVG-friendly tags. The resultant file should thus be
   * playable as an animation in a browser.
   *
   * @param model the model to render the state of
   * @param out   the output file
   * @param fps   frames-per-second speed of the animation
   */
  @Override
  public void render(IModel model, Appendable out, int fps) {
    try {
      out.append("<svg width=\"2000\" height=\"2000\" version=\"1.1\"" +
              " xmlns=\"http://www.w3.org/2000/svg\">\n");
    } catch (IOException ignore) {
      // Ignore.
    }
    String endTag;
    String x;
    String y;
    for (IReadOnlyShape shape : model.getAllShapes()) {
      if (shape instanceof Rectangle) {
        endTag = "</rect>\n";
        x = "x";
        y = "y";
        try {
          out.append("\n<rect id=\"" + shape.getId() + "\" x=\"" + shape.getX() + "\" y=\"" +
                  shape.getY() + "\" width=\"" + shape.getParam1() + "\" height=\"" +
                  shape.getParam2() + "\" fill=\"rgb(" + shape.getColor()[0] + "," +
                  shape.getColor()[1] + "," + shape.getColor()[2] + ")\" visibility=\"visible\"" +
                  " >\n");
        } catch (IOException ignore) {
          // Ignore.
        }
      } else {
        endTag = "</ellipse>\n";
        x = "cx";
        y = "cy";
        try {
          out.append("\n<ellipse id=\"" + shape.getId() + "\" cx=\"" + shape.getX() + "\" cy=\"" +
                  shape.getY() + "\" rx=\"" + shape.getParam1() + "\" ry=\"" +
                  shape.getParam2() + "\" fill=\"rgb(" + shape.getColor()[0] + "," +
                  shape.getColor()[1] + "," + shape.getColor()[2] + ")\" visibility=\"visible\"" +
                  " >\n");
        } catch (IOException ignore) {
          // Ignore.
        }
      }

      List params;
      double start;
      double dur;
      for (IMotion motion : shape.getAllMotions()) {
        params = motion.getParams();

        start = motion.getFirstFrame() / fps * 1000;
        dur = (motion.getLastFrame() / fps * 1000) - start;

        if (motion instanceof Translation) {
          try {
            out.append("\n<animate attributeType=\"xml\" begin=\"" + start
                    + "ms\" dur=\"" + dur + "ms\" attributeName=\"" + x + "\" from=\""
                    + params.get(0) + "\" to=\"" + params.get(1) + "\" fill=\"remove\" />\n");

            out.append("\n<animate attributeType=\"xml\" begin=\"" + start + "ms\"" +
                    " dur=\"" + dur + "ms\" attributeName=\"" + y + "\" from=\"" +
                    params.get(2) + "\" to=\"" + params.get(3) + "\" fill=\"remove\" />\n");
          } catch (IOException ignore) {
            // Ignore.
          }
        } else if (motion instanceof ColorShift) {
          try {
            out.append("\n<animate attributeType=\"xml\" begin=\"" + start
                    + "ms\" dur=\"" + dur + "ms\" attributeName=\"fill\" to=\"rgb("
                    + params.get(3) + "," + params.get(4) + "," + params.get(5) + ")\" " +
                    "fill=\"freeze\" />\n");
          } catch (IOException ignore) {
            // Ignore.
          }
        }
        // Scale
        else {

          try {
            out.append("\n<animateTransform attributeType=\"xml\" begin=\"" + start + "ms\"" +
                    " dur=\"" + dur + "ms\" attributeName=\"transform\" type=\"scale\" from=\""
                    + params.get(0) + "," + params.get(1) + "\" to=\"" + params.get(2) + ","
                    + params.get(3) + "\" additive=\"sum\" fill=\"freeze\" />\n");
          } catch (IOException ignore) {
            // Ignore.
          }
        }
      }
      try {
        out.append(endTag);
      } catch (IOException ignore) {
        // Ignore.
      }
    }
    try {
      out.append("\n</svg>");
    } catch (IOException ignore) {
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
