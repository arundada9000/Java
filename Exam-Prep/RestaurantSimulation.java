import static mypackage.PackageCreation.clear;

// Step 1: Define the Task Interface - This represents a Chef's job.
interface RestaurantTask {
    void processOrder(); // Each chef will process an order
}

// Step 2: Create a class that implements RestaurantTask and Runnable (for
// multithreading)
class ChefOrder implements RestaurantTask, Runnable {
    private String chefName;
    private String dish;
    private int preparationTime;

    // Constructor to assign dish and preparation time
    public ChefOrder(String chefName, String dish, int preparationTime) {
        this.chefName = chefName;
        this.dish = dish;
        this.preparationTime = preparationTime;
    }

    // Method to process the order
    @Override
    public void processOrder() {
        System.out.println(chefName + " starts preparing: " + dish);
        try {
            Thread.sleep(preparationTime); // Simulate the time taken to prepare the dish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(chefName + " finished preparing: " + dish);
    }

    // Run method for the thread, which calls the processOrder
    @Override
    public void run() {
        processOrder();
    }
}

// Step 3: Create a main class to simulate the restaurant with multiple chefs
public class RestaurantSimulation {
    public static void main(String[] args) {
        clear();
        // Orders with chefs, dishes, and their respective preparation times in
        // milliseconds
        ChefOrder chef1 = new ChefOrder("Chef Gordon", "Steak", 5000); // 5 seconds for steak
        ChefOrder chef2 = new ChefOrder("Chef Jamie", "Salad", 2000); // 2 seconds for salad
        ChefOrder chef3 = new ChefOrder("Chef Ramsay", "Pasta", 4000); // 4 seconds for pasta
        ChefOrder chef4 = new ChefOrder("Chef Rachel", "Soup", 3000); // 3 seconds for soup

        // Create threads for each chef's task
        Thread thread1 = new Thread(chef1);
        Thread thread2 = new Thread(chef2);
        Thread thread3 = new Thread(chef3);
        Thread thread4 = new Thread(chef4);

        // Start all threads (chefs preparing their orders concurrently)
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
