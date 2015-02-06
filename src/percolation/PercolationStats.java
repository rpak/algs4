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

    }
}
