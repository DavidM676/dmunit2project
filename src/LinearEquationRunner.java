import java.util.Scanner;

public class LinearEquationRunner {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome!");
        System.out.print("Enter coordinate 1: ");
        String c1 = scan.nextLine();
        System.out.print("Enter coordinate 2: ");
        String c2 = scan.nextLine();

        int x1 = Integer.parseInt(c1.substring(1, c1.indexOf(",")));
        int y1 = Integer.parseInt(c1.substring(c1.indexOf(", ") + 2, c1.indexOf(")")));
        int x2 = Integer.parseInt(c2.substring(1, c2.indexOf(",")));
        int y2 = Integer.parseInt(c2.substring(c2.indexOf(", ") + 2, c2.indexOf(")")));

        if (!(x1 == x2)) {


            LinearEquation equation = new LinearEquation(x1, y1, x2, y2);

            System.out.println(equation.lineInfo());
            System.out.println();

            System.out.print("Enter a value for x: ");

            double testX = scan.nextDouble();
            System.out.println("Coordinate for x: " + equation.coordinateForX(testX));

        } else {
            System.out.println("These points are on a vertical line: x = " + x1);
        }
    }

}
