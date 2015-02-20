import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Brute {
    private static void foo(String dataFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(dataFile));
        int n = Integer.parseInt(reader.readLine().trim());
        int actual = 0;
        Point[] points = new Point[n];

        while (reader.ready()) {
            String[] coordinates = reader.readLine().trim().split("\\s+");
            if (coordinates.length < 2) continue;
            int x = Integer.parseInt(coordinates[0]);
            int y = Integer.parseInt(coordinates[1]);
            actual++;
        }

        System.out.println("Brute Forcing " + n + " Points...");
        System.out.println("Processed " + actual + " Points. DONE.");
        reader.close();
    }

    public static void main(String[] args) {
        try {
            foo(args[0]);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            System.exit(1);
        }
    }
}
