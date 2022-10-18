public class LinearEquation {
    /* Instance Variables */
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    private boolean v = false;

    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;

        if (x1 == x2) {

            v = true;

        }
    }


    /* Calculates and returns distance between (x1, y1) and (x2, y2), rounded to
       the nearest hundredth */
    public double distance() {
        return roundedToHundredth(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
    }


    /* Calculates and returns the y-intercept of the line between (x1, y1) and
       (x2, y2), rounded to the nearest hundredth */
    public double yIntercept() {
        return y1 - (slope() * x1);
    }


    /* Calculates and returns the slope of the line between (x1, y1) and
       (x2, y2), rounded to the nearest hundredth */
    public double slope() {

        return roundedToHundredth((double) (y1 - y2) / (x1 - x2));
    }


    /* Returns a String that represents the linear equation of the line through points
       (x1, y1) and (x2, y2) in slope-intercept (y = mx + b) form, e.g. "y = 3x + 1.5".

        When generating the m value (slope), here are examples of "printable" slopes:
           5, -5, 1/2, 6/8 (reducing not required), 8/5, -2/3, -18/7

        Here are non-examples of "printable" slopes:
     1/-2 (should be -1/2), -4/-3 (should be 4/3), 8/4 (should be reduced to 2),
           -12/3 (should be -4), 3/3 (should be 1), -6/6 (should be -1)

        HINT: Be sure to check if the line is horizontal and return an appropriate string,
        e.g. y = 6
        HINT: Absolute value might be helpful for ensuring proper placement of negative sign!


        When generating the b value, here are some examples of "printable" y-intercepts:
           + 1.0 	- 2.35	      + 12.5		- 8.0		+ 17.19

        Here are non-examples of "printable" y-intercepts:
           - -1.0 	+ -2.35	- -12.5	+ -8.0	     - -17.19	+ 0	- 0

        HINT: Absolute value might be helpful for printing negative y-intercepts as
               subtraction!
     */
    public String equation() {


        double dec = slope() % 1;
        String addSub = "+ ";
        double yint = yIntercept();
        String yintStr = ""+yIntercept();

        if (yint<0) {
            addSub = "- ";
            yintStr = ""+Math.abs(yint);
        } else if (yint == 0)  {
            addSub = "";
            yintStr = "";
        }

        if (dec == 0.0) { //if whole number
            int s = (int) slope();
            if (s == 0) {
                return "y = " + yIntercept();
            } else if (s == 1) {
                return "y = x " + addSub + yintStr;
            } else if (s == -1) {
                return "y = -x " + addSub + yintStr;
            } else {
                return "y = " + s + "x " + addSub + yintStr;
            }

        } else {
            boolean x = true;
            double n = slope();
            double firstN = n;
            int d = 1;
            while (x) {

                n += firstN;
                n = roundedToHundredth(n);
                d += 1;


                if ((n % 1) == 0) {
                    x = false;
                    break;
                }
            }

            return "y = " + (int) n + "/" + d + "x " + addSub + yintStr;
        }

    }


    /* Returns a String of the coordinate point on the line that has the given x value, with
       both x and y coordinates as decimals to the nearest hundredth, e.g (-5.0, 6.75) */
    public String coordinateForX(double xValue) {
        if (!v) {
            double y = (slope() * xValue) + yIntercept();
            return "(" + xValue + ", " + y + ")";
        } else {
            return "";
        }

    }


    /* "Helper" method for use elsewhere in your methods; returns the value toRound rounded
        to the nearest hundredth

        HINT:  the Math.round method can help with this!
     */
    public double roundedToHundredth(double toRound) {
        return Math.round(toRound * 100) / 100.0;
    }


    /* Returns a string that includes all information about the linear equation, each on
       separate lines:
         - The original points: (x1, y1) and (x2, y2)
         - The equation of the line in y = mx + b format (using equation() method)
         - The slope of the line, as a decimal (using slope() method)
         - The y-intercept of the line (using yIntercept() method)
         - The distance between the two points (using distance() method)

      This method should call all other appropriate methods to get the info it needs:
      equation(), slope(), yIntercept(), distance().

      */
    public String lineInfo() {

        if (!v) {
            String n = "\n";

            String l1 = "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")";
            String l2 = "The equation of the line between these points is: " + equation();
            String l3 = "The slope of this line is: " + slope();
            String l4 = "The y-intercept of the line is: " + yIntercept();
            String l5 = "The distance between the two points is: " + distance();
            return l1 + n + l2 + n + l3 + n + l4 + n + l5 + n;
        }
        return "These points are on a vertical line: x = " + x1;
    }
}