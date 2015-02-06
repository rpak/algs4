public class Percolation {
    private int[][] grid;

    // create N-by-N grid, with all sites blocked
    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException();

        this.grid = new int[n][n];
    }

    // open site (row i, column j) if it is not open already
    public void open(int i, int j) throws IndexOutOfBoundsException {
        validateBounds(i, j);
    }

    // is site (row i, column j) open?
    public boolean isOpen(int i, int j) throws IndexOutOfBoundsException {
        validateBounds(i, j);
        return false;
    }

    // is site (row i, column j) full?
    public boolean isFull(int i, int j) throws IndexOutOfBoundsException {
        validateBounds(i, j);
        return false;
    }

    // does the system percolate?
    public boolean percolates() {
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Programming Assignment 1: Percolation");
    }

    private void validateBounds(int i, int j) throws IndexOutOfBoundsException {
        if (i > this.grid.length || j > this.grid.length) throw new IndexOutOfBoundsException();
        if (i <= 0 || j <= 0) throw new IndexOutOfBoundsException();
    }
}