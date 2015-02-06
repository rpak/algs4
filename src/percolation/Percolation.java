public class Percolation {
    public static int BLOCKED = 0;
    public static int OPEN = 1;
    private int n;
    private int totalSiteCount;
    private int[][] sites;
    private WeightedQuickUnionUF connectedSites;
    int virtualTopSiteId;
    int virtualBottomSiteId;

    // create N-by-N sites, with all sites blocked
    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException();
        this.n = n;
        this.totalSiteCount = n * n;
        this.sites = new int[n][n];
        this.connectedSites = new WeightedQuickUnionUF(this.totalSiteCount + 2);
        this.virtualTopSiteId = this.totalSiteCount;
        this.virtualBottomSiteId = this.totalSiteCount + 1;

        for (int i = 0; i < n; i++) {
            this.connectedSites.union(virtualTopSiteId, i);
            this.connectedSites.union(virtualBottomSiteId, (this.totalSiteCount - 1 - i));
            for (int j = 0; j < n; j++) {
                this.sites[i][j] = BLOCKED;
            }
        }
    }

    // open site (row i, column j) if it is not open already
    public void open(int i, int j) throws IndexOutOfBoundsException {
        validateBounds(i, j);
        int rowIndex = i - 1;
        int columnIndex = j - 1;
        int siteId = buildSiteId(rowIndex, columnIndex);

        int topRowIndex = rowIndex - 1;
        if (topRowIndex >= 0 && this.sites[topRowIndex][columnIndex] == OPEN) {
            int topSiteId = buildSiteId(topRowIndex, columnIndex);
            if (!connectedSites.connected(siteId, topSiteId)) {
                connectedSites.union(siteId, topSiteId);
            }

            if (isFull(i - 1, j)) {
                this.connectedSites.union(this.virtualTopSiteId, siteId);
            }
        }

        int bottomRowIndex = rowIndex + 1;
        if (bottomRowIndex < n && this.sites[bottomRowIndex][columnIndex] == OPEN) {
            int bottomSiteId = buildSiteId(bottomRowIndex, columnIndex);
            if (!connectedSites.connected(siteId, bottomSiteId)) {
                connectedSites.union(siteId, bottomSiteId);
            }

            if (isFull(i + 1, j)) {
                this.connectedSites.union(this.virtualTopSiteId, siteId);
            }
        }

        int leftColumnIndex = columnIndex - 1;
        if (leftColumnIndex >= 0 && this.sites[rowIndex][leftColumnIndex] == OPEN) {
            int leftSiteId = buildSiteId(rowIndex, leftColumnIndex);
            if (!connectedSites.connected(siteId, leftSiteId)) {
                connectedSites.union(siteId, leftSiteId);
            }

            if (isFull(i, j - 1)) {
                this.connectedSites.union(this.virtualTopSiteId, siteId);
            }
        }

        int rightColumnIndex = columnIndex + 1;
        if (rightColumnIndex < n && this.sites[rowIndex][rightColumnIndex] == OPEN) {
            int rightSiteId = buildSiteId(rowIndex, rightColumnIndex);
            if (!connectedSites.connected(siteId, rightSiteId)) {
                connectedSites.union(siteId, rightSiteId);
            }

            if (isFull(i, j + 1)) {
                this.connectedSites.union(this.virtualTopSiteId, siteId);
            }
        }

        this.sites[rowIndex][columnIndex] = OPEN;
    }

    // is site (row i, column j) open?
    public boolean isOpen(int i, int j) throws IndexOutOfBoundsException {
        validateBounds(i, j);
        return this.sites[i - 1][j - 1] == OPEN;
    }

    /**
     * A full site is an open site that can be connected to an open site in the top row via a chain of neighboring
     * (left, right, up, down) open sites.
     */
    public boolean isFull(int i, int j) throws IndexOutOfBoundsException {
        validateBounds(i, j);
        int rowIndex = i - 1;
        int columnIndex = j - 1;
        int siteId = buildSiteId(rowIndex, columnIndex);

        return isOpen(i, j) && this.connectedSites.connected(siteId, virtualTopSiteId);
    }

    /**
     * We say the system percolates if there is a full site in the bottom row. In other words, a system percolates if
     * we fill all open sites connected to the top row and that process fills some open site on the bottom row.
     */
    public boolean percolates() {
        return this.connectedSites.connected(virtualBottomSiteId, virtualTopSiteId);
    }

    public static void main(String[] args) {
        System.out.println("Programming Assignment 1: Percolation");
    }

    private void validateBounds(int i, int j) throws IndexOutOfBoundsException {
        String message = "Coordinates, [" + i + "][" + j + "], out of bounds for N-by-N sites of " + this.sites.length;
        if (i > this.sites.length || j > this.sites.length) throw new IndexOutOfBoundsException(message);
        if (i <= 0 || j <= 0) throw new IndexOutOfBoundsException(message);
    }

    private int buildSiteId(int rowIndex, int columnIndex) {
        return (rowIndex * this.n) + columnIndex;
    }

    public int getTotalSiteCount() {
        return this.totalSiteCount;
    }

    public String toString() {
        StringBuilder buffer = new StringBuilder();

        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                buffer.append('|');

                if (this.sites[i][j] == OPEN)
                    buffer.append('o');
                else
                    buffer.append(' ');

                if (j == this.n - 1) buffer.append("|\n");
            }
        }

        return buffer.toString();
    }
}