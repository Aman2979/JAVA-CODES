import java.util.*;

public class asteroidCollision {
    // Method to resolve asteroid collisions
    public static int[] asteroidCollisions(int[] asteroids) {
        Stack<Integer> stack = new Stack<>(); // Stack to track the state of asteroids

        for (int i = 0; i < asteroids.length; i++) {
            // If stack is empty or the current asteroid is moving right (positive), push it onto the stack
            if (stack.isEmpty() || asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } else {
                // Handle the case where the current asteroid is moving left (negative)
                while (!stack.isEmpty()) {
                    int top = stack.peek(); // Get the top of the stack without removing it

                    // If the top of the stack is also moving left, no collision occurs
                    if (top < 0) {
                        stack.push(asteroids[i]);
                        break;
                    }

                    // Compare the absolute values of the asteroids to determine the collision result
                    int modVal = Math.abs(asteroids[i]);

                    if (modVal == top) {
                        // If the magnitudes are equal, both asteroids destroy each other
                        stack.pop(); // Remove the top asteroid
                        break;       // Stop further processing
                    } else if (modVal < top) {
                        // If the incoming asteroid is smaller, it gets destroyed
                        break;
                    } else {
                        // If the incoming asteroid is larger, destroy the top asteroid
                        stack.pop(); // Remove the top asteroid

                        // If the stack becomes empty, push the incoming asteroid
                        if (stack.isEmpty()) {
                            stack.push(asteroids[i]);
                            break;
                        }
                    }
                }
            }
        }

        // Convert the remaining stack into an array for the result
        int len = stack.size();
        int ansArray[] = new int[len];

        for (int i = len - 1; i >= 0; i--) {
            ansArray[i] = stack.pop(); // Fill the result array from stack
        }
        return ansArray;
    }

    public static void main(String[] args) {
        int[] asteroid = {10, 2, -5}; // Input asteroid array
        int[] ans = asteroidCollisions(asteroid); // Resolve collisions
        System.out.println(Arrays.toString(ans)); // Print the result
    }
}
