/*
 * Create a class Distance with private variables feet of type integer and inches of type floating point. Use suitable constructor, and methods for adding and comparing two distance objects. [Hint: 1 feet = 12 inches]
 */
public class Question3 {
    public static void main(String[] args) {
        Distance d1 = new Distance(3, 3);
        Distance d2 = new Distance(2, 4);

        // Add the two distances and print the result
        Distance result = d1.addObjects(d2);
        System.out.println("After addition: " + result); // Show the result

        // Compare the two distances
        d1.compareObjects(d2);
    }
}

class Distance {
    private int feet;
    private float inches;

    // Constructor to initialize the distance in feet and inches
    Distance(int feet, float inches) {
        this.feet = feet;
        this.inches = inches;
    }

    // Method to add two Distance objects and return the new object
    Distance addObjects(Distance d) {
        int newFeet = this.feet + d.feet;
        float newInches = this.inches + d.inches;

        // Convert excess inches into feet
        while (newInches >= 12) {
            newFeet++;
            newInches -= 12;
        }

        // Return a new Distance object with the calculated feet and inches
        return new Distance(newFeet, newInches);
    }

    // Method to compare two Distance objects
    void compareObjects(Distance d) {
        // Convert both distances to inches for accurate comparison
        float totalInchesThis = this.feet * 12 + this.inches;
        float totalInchesOther = d.feet * 12 + d.inches;

        if (totalInchesThis > totalInchesOther) {
            System.out.println("d1 is greater than d2.");
        } else if (totalInchesThis < totalInchesOther) {
            System.out.println("d2 is greater than d1.");
        } else {
            System.out.println("Both distances are equal.");
        }
    }

    // Override toString() for proper printing of Distance object
    @Override
    public String toString() {
        return feet + " feet and " + inches + " inches";
    }
}
