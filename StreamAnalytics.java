import java.util.*;

public class StreamAnalytics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        // SensorID -> [sum, count]
        Map<String, double[]> data = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String sensorId = sc.next();
            double temperature = sc.nextDouble();

            // Filter temperatures greater than 50
            if (temperature > 50) {
                data.putIfAbsent(sensorId, new double[2]);

                data.get(sensorId)[0] += temperature; // sum
                data.get(sensorId)[1]++;              // count
            }
        }

        // Sort sensors by average temperature in descending order
        List<Map.Entry<String, double[]>> list =
                new ArrayList<>(data.entrySet());

        list.sort((a, b) -> {
            double avgA = a.getValue()[0] / a.getValue()[1];
            double avgB = b.getValue()[0] / b.getValue()[1];
            return Double.compare(avgB, avgA);
        });

        // Display result
        for (Map.Entry<String, double[]> entry : list) {
            double average = entry.getValue()[0] / entry.getValue()[1];
            System.out.println(entry.getKey() + " " + average);
        }

        sc.close();
    }
}