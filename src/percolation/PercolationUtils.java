public class PercolationUtils {
    public static String print(Percolation percolation, int n) {
        StringBuilder buffer = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                buffer.append('|');

                if (percolation.isOpen(i + 1, j + 1))
                    buffer.append('o');
                else
                    buffer.append(' ');

                if (j == (n - 1)) buffer.append("|\n");
            }
        }

        return buffer.toString();
    }
}
