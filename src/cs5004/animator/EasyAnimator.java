package cs5004.animator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

import cs5004.animator.controller.ControllerFactory;
import cs5004.animator.controller.IController;
import cs5004.animator.model.AniModel;
import cs5004.animator.model.IModel;
import cs5004.animator.util.AnimationFileReader;
import cs5004.animator.util.TweenModelBuilder;
import cs5004.animator.view.IView;
import cs5004.animator.view.ViewFactory;

/**
 * Entry point for the animator program.
 */
public final class EasyAnimator {

  /**
   * Entry point for the animator program.
   *
   * @param args string arguments detailing the run configuration
   */
  public static void main(String[] args) {

    String file = "";
    String view = "";
    String outSrc = "";
    int fps = 1;

    String next;
    // Odd number of args means input error--ignore last.
    for (int i = 0; i < args.length - 1; i += 2) {

      next = args[i];

      switch (next) {
        case "-if":
          file = args[i + 1];
          break;
        case "-iv":
          view = args[i + 1];
          break;
        case "-o":
          outSrc = args[i + 1];
          break;
        case "-speed":
          fps = Integer.parseInt(args[i + 1]);
          break;
        default:
          System.out.println("Error$#%@#@");
      }
    }

    if ((file.equals("")) || (view.equals(""))) {
      System.out.println("Error@#$@#$");
    }

    try {
      FileInputStream in = new FileInputStream(file);
    } catch (FileNotFoundException e) {
      System.out.println("Error--file not found.");
    }

    OutputStreamWriter out = null;
    PrintStream fOut = null;
    if (outSrc.equals("") || outSrc.equals("out")) {
      out = new OutputStreamWriter(System.out);
    } else {
      try {
        fOut = new PrintStream(new File(outSrc));
      } catch (IOException ignore) {
        // Ignore.
      }
    }

    IModel model = new AniModel();
    TweenModelBuilder m = new AniModel.ModelBuilder();
    AnimationFileReader a = new AnimationFileReader();
    try {
      model = (IModel) a.readFile(file, m);
    } catch (FileNotFoundException ignore) {
      // Ignore.
    }

    Appendable output;
    if (out != null) {
      output = out;
    } else {
      output = fOut;
    }


    IView v = ViewFactory.makeView(view);
    IController controller = ControllerFactory.make(model, v, view, output, fps);


    controller.run(v);
  }


}
