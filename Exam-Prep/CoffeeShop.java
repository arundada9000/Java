// Step 1: Create an interface for the task (order processing).
interface CoffeeOrder {
    void processOrder(); // Each order will have a method to process it.
}

// Step 2: Implement the interface in a concrete class for each customer's
// order.
class CustomerOrder implements CoffeeOrder, Runnable {
    private String customerName;
    private String orderDetails;

    // Constructor
    public CustomerOrder(String customerName, String orderDetails) {
        this.customerName = customerName;
        this.orderDetails = orderDetails;
    }

    // Implementing the processOrder method from the CoffeeOrder interface
    @Override
    public void processOrder() {
        System.out.println("Processing order for " + customerName + ": " + orderDetails);
        try {
            // Simulate time taken to prepare the coffee (e.g., 2 seconds)
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Order ready for " + customerName + ": " + orderDetails);
    }

    // Implementing the run() method from Runnable (to run the process in a thread)
    @Override
    public void run() {
        processOrder();
    }
}

// Step 3: Create the main class to simulate a coffee shop.
public class CoffeeShop {
    public static void main(String[] args) {
        // Step 4: Create customer orders (each customer is represented by a thread)
        CustomerOrder customer1 = new CustomerOrder("Alice", "Cappuccino");
        CustomerOrder customer2 = new CustomerOrder("Bob", "Espresso");
        CustomerOrder customer3 = new CustomerOrder("Charlie", "Latte");

        // Step 5: Create threads for each customer order
        Thread thread1 = new Thread(customer1);
        Thread thread2 = new Thread(customer2);
        Thread thread3 = new Thread(customer3);

        // Step 6: Start the threads to process the orders concurrently
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
