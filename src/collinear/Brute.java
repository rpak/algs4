import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Brute {
    private static Point[] buildPointsFromFile(String dataFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(dataFile));
        int n = Integer.parseInt(reader.readLine().trim());
        int actual = 0;
        Point[] points = new Point[n];

        while (reader.ready()) {
            String[] coordinates = reader.readLine().trim().split("\\s+");
            if (coordinates.length < 2) continue;
            int x = Integer.parseInt(coordinates[0]);
            int y = Integer.parseInt(coordinates[1]);
            points[actual] = new Point(x, y);
            actual++;
        }

//        System.out.println("Brute forcing " + n + " points...");
//        System.out.println("Finished reading " + actual + " points...");
        reader.close();

        return points;
    }

    private static void findCollinearLines(Point[] points) {
        Arrays.sort(points);
        int cost = 0;

        for (int i = 0; i < points.length; i++) {
            points[i].draw();
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    for (int l = k + 1; l < points.length; l++) {
                        double s1 = points[i].slopeTo(points[j]);
                        double s2 = points[j].slopeTo(points[k]);
                        double s3 = points[k].slopeTo(points[l]);

                        cost++;
                        if (s1 == s2 && s2 == s3) {
                            points[i].drawTo(points[j]);
                            points[j].drawTo(points[k]);
                            points[k].drawTo(points[l]);
                            System.out.println(points[i] + " -> " +
                                               points[j] + " -> " +
                                               points[k] + " -> " + points[l]);
                        }
                    }
                }
            }
        }

        // System.out.println("Finished finding collinear lines at a cost of " + cost);
    }

    public static void main(String[] args) {
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);

        try {
            Point[] points = buildPointsFromFile(args[0]);
            findCollinearLines(points);

            // while (true) { Thread.sleep(1000); }
        } catch (Exception e) {
            e.printStackTrace(System.err);
            throw new RuntimeException(e.getMessage());
        }
    }
}
