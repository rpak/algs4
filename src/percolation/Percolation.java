public class Percolation {
    // create N-by-N grid, with all sites blocked
    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException();
    }

    // open site (row i, column j) if it is not open already
    public void open(int i, int j) {
    }

    // is site (row i, column j) open?
    public boolean isOpen(int i, int j) {
        return false;
    }

    // is site (row i, column j) full?
    public boolean isFull(int i, int j) {
        return false;
    }

    // does the system percolate?
    public boolean percolates() {
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Programming Assignment 1: Percolation");
    }
}