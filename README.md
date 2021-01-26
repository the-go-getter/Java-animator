<h2> Easy Animator </h2>

<p> This is the repository for a Java based application used for viewing and creating animations from 
.SVG and .txt files. </p>
<p> This project makes use of Java's swing graphics to render the graphics.</p>
<p> The next section describes how to run this application</p>


<a name="run"><h3> How to run this application </h3></a>
<p>The main() method will be the entry point for our application. Our application needs to take 
inputs as command-line arguments (available in our application through the argument args).
   
   The command-line arguments will be of the form
   
   -in "name-of-animation-file" -view "type-of-view" -out "where-output-show-go" -speed "integer-ticks-per-second"
   
   <h6>Characteristics of a valid input are:</h6>
   
   Each pair of arguments (-in "input-file", -out "output-file", etc.) may appear in any order 
   (e.g. the -view pair can appear first, followed by -in and so on)
   
   Each pair of arguments are ordered. That is, if the user types -in then the next input must be 
   the name of an input file, and so on.
   
   Providing an input file (the -in pair) and a view (the -view pair) are mandatory. If the output 
   set is not specified, the default will be System.out. If the speed is not specified, the default 
   is 1 tick per second.
   
   This main() method will be the entry point for our application. We will need to create an 
   Application run configuration in IntelliJ (or any other IDE) that chooses cs5004.animator.EasyAnimator 
   as its main class. In this run configuration, we can also specify command-line arguments, 
   such as the file you want to read in, and the view name you want to use. 
   The options for the view name are "text" and "visual".
   
   <h6>Here are some examples of valid command-line arguments and what they mean:</h6>
   
   -in smalldemo.txt -view text -speed 2: use smalldemo.txt for the animation file, and create a 
   text view with its output going to System.out, and a speed of 2 ticks per second.
   
   -in smalldemo.txt -view text: use smalldemo.txt for the animation file, and create a text view 
   with its output going to System.out.
   
   -in smalldemo.txt -speed 50 -view visual: use smalldemo.txt for the animation file, and create a 
   visual view to show the animation at a speed of 50 ticks per second.
   
   <h6> Please find sample animation files in the "animation files" folder of this repo </h6>
   </p>

