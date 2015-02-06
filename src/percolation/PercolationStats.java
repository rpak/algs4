import sun.reflect.annotation.ExceptionProxy;

public class PercolationStats {
    private double[] results;
    private int n;
    private int t;

    public PercolationStats(int n, int t) {
        if (n <= 0 || t <=0) throw new IllegalArgumentException();
        this.n = n;
        this.t = t;
        this.results = new double[t];
        this.runSimulation();
    }

    public double mean() {
        return StdStats.mean(results);
    }

    public double stddev() {
        return StdStats.stddev(results);
    }

    public double confidenceLo() {
        return mean() - ((1.96 * stddev()) / Math.sqrt(this.t));
    }

    public double confidenceHi() {
        return mean() + ((1.96 * stddev()) / Math.sqrt(this.t));
    }

    private void runSimulation() {
        for (int i = 0; i < t; i++) {
            Percolation percolation = new Percolation(n);
            double openSiteCount = 0;

            while (!percolation.percolates()) {
                int randomRow = StdRandom.uniform(1, n + 1);
                int randomColumn = StdRandom.uniform(1, n + 1);
                if (percolation.isOpen(randomRow, randomColumn)) continue;
                openSiteCount++;
                percolation.open(randomRow, randomColumn);
                if (openSiteCount >= percolation.getTotalSiteCount()) break;
            }
            this.results[i] = openSiteCount / percolation.getTotalSiteCount();
        }
    }

    public static void main(String[] args) {
        try {
            int n = Integer.parseInt(args[0]);
            int t = Integer.parseInt(args[1]);
            PercolationStats stats = new PercolationStats(n, t);
            System.out.println("mean                    = " + stats.mean());
            System.out.println("stddev                  = " + stats.stddev());
            System.out.println("95% confidence interval = " + stats.confidenceLo() + ", " + stats.confidenceHi());
        }
        catch (Exception e) {
            System.out.println("Usage: PercolationStats N T");
        }
    }
}
