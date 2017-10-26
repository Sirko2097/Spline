import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MagicHappensHere {

    public static int n;
    public static ArrayList<Double> x = new ArrayList<>();
    public static ArrayList<Double> y = new ArrayList<>();
    private static int choice;

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //new Graph().setVisible(true);

        System.out.print("Amount of points = ");
        try {
            n = Integer.parseInt(reader.readLine());
        } catch (IOException ex){
            ex.printStackTrace();
        }

        System.out.println("Enter points:");
        for (int i = 0; i < n; i++) {
            System.out.print(i + ") ");
            try {
                x.add(Double.parseDouble(reader.readLine()));
                y.add(Double.parseDouble(reader.readLine()));
            } catch (IOException ex){
                System.out.println("Invalid input 'x, y'");
            }
        }

        System.out.println("1) Linear spline");
        System.out.println("2) Cubic spline");
        System.out.print("Choose the solution: ");
        try {
            choice = Integer.parseInt(reader.readLine());
        } catch (IOException ex){
            ex.printStackTrace();
        }




        switch (choice) {
            case 1:
                Linear linear = new Linear(n, x, y);
                try {
                    linear.go();
                } catch (Exception ignore){}
                break;
            case 2:
                Cubic cubic = new Cubic(n, x, y);
                try {
                    cubic.go();
                } catch (Exception ignore){}
                break;
            default:
                System.out.println("restart");
                break;
        }//close switch

    }
}
