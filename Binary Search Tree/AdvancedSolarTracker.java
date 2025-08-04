import java.util.Random;

public class AdvancedSolarTracker {
    public static void main(String[] args) {
        int panelAngle = 90; // Default position (Facing upwards)
        Random rand = new Random();

        while (true) {
            // Simulating LDR sensor values (0 to 100)
            int ldrLeft = rand.nextInt(101);
            int ldrRight = rand.nextInt(101);

            System.out.println("LDR Left: " + ldrLeft + ", LDR Right: " + ldrRight);

            // Adjusting panel direction based on light intensity
            if (ldrLeft > ldrRight) {
                panelAngle = Math.max(0, panelAngle - 5); // Move left
                System.out.println("Moving panel left: " + panelAngle + "°");
            } else if (ldrRight > ldrLeft) {
                panelAngle = Math.min(180, panelAngle + 5); // Move right
                System.out.println("Moving panel right: " + panelAngle + "°");
            } else {
                System.out.println("Sunlight balanced. Holding position at: " + panelAngle + "°");
            }

            // Simulating real-time delay (1 second)
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

