import java.util.ArrayList;

public class Cubic {
    private int n;
    private ArrayList<Double> x = new ArrayList<>();
    private ArrayList<Double> y = new ArrayList<>();
    private static ArrayList<Double> d = new ArrayList<>();
    private static ArrayList<Double> h = new ArrayList<>();

    private double[][] s = new double[3][4];

    public Cubic(int n, ArrayList<Double> x, ArrayList<Double> y) {
        this.n = n;
        this.x = x;
        this.y = y;
    }

    public void go() throws IndexOutOfBoundsException{
        int dSa = -2;
        int dSb = 3;

        double m2 = -384 / 273;
        double m1 = -(6 + 4 * m2) / 17;

        for (int i = 0; i < n - 1; i++) {
            h.add(x.get(i+1) - x.get(i));
        }

        for (int i = 0; i < n - 1; i++) {
            d.add((y.get(i+1) - y.get(i)) / h.get(i));
        }

        double m0 = 3 / h.get(0) * (d.get(0) - dSa) - m1 / 2;
        double m3 = 3 / h.get(2) * (dSb - d.get(2)) - m2 / 2;

        for (int i = 0; i < n - 1; i++) {
            s[i][0] = y.get(i);
        }

        s[0][1] = d.get(0) - h.get(0) * (2 * m0 + m1) / 6;
        s[1][1] = d.get(1) - h.get(1) * (2 * m1 + m2) / 6;
        s[2][1] = d.get(2) - h.get(2) * (2 * m2 + m3) / 6;

        s[0][2] = m0 / 2;
        s[1][2] = m1 / 2;
        s[2][2] = m2 / 2;

        s[0][3] = (m1 - m0) / (6 * h.get(0));
        s[1][3] = (m2 - m1) / (6 * h.get(1));
        s[2][3] = (m3 - m2) / (6 * h.get(2));

        //output
        int j = 1, k = 0;
        for (int i = 0; i < n ; i++, k++, j++) {
            System.out.println("[" + x.get(k) + " " + x.get(j) + "]:");
            System.out.println(s[i][0] + " + (" + s[i][1] + ")*(x - (" + x.get(i) + ")) + (" + s[i][2] + ")*(x-(" + x.get(i) + "))^2 + (" + s[i][3] + ")*(x-(" + x.get(i) + "))^3");
        }
    }
}
