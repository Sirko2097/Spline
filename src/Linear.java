import java.util.ArrayList;


public class Linear {

    private int n;
    private ArrayList<Double> x = new ArrayList<>();
    private ArrayList<Double> y = new ArrayList<>();

    public Linear(int n, ArrayList<Double> x, ArrayList<Double> y) {
        this.n = n;
        this.x = x;
        this.y = y;
    }

    public void go() throws IndexOutOfBoundsException {
        double a, b;


        int j = 1;
        for (int i = 0; i < n; i++, j++) {
            a = (y.get(j) - y.get(i)) / (x.get(j) - x.get(i));
            b = (y.get(j) * x.get(i) - y.get(i) * x.get(j)) / (x.get(i) - x.get(j));

            System.out.println("[" + x.get(i) + " " + x.get(j) + "]:");
            System.out.println(a + "*x + (" + b + ")");
        }


    }//close go


}//close lineal
