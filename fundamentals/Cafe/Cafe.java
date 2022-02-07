
public class Cafe {

    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app.
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";

        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripPrice = 4.5;
        double lattePrice = 4.65;
        double cappuccinoPrice = 4.95;

        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";

        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = true;

        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
        // ** Your customer interaction print statements will go here ** //

        if (isReadyOrder1) {
            System.out.println(customer1 + readyMessage);
        } else {
            System.out.println(customer1 + pendingMessage);
        }

        if (isReadyOrder4) {
            System.out.println(customer4 + readyMessage +"; total cost is: $" + cappuccinoPrice);
        } else {
            System.out.println(customer4 + pendingMessage);
        }

        if (isReadyOrder2) {
            System.out.println(customer2 + readyMessage +"; total cost is: $" + (2*lattePrice));
        } else {
            System.out.println(customer2 + pendingMessage);
        }

        System.out.printf("%s - Thanks for being honest, your total should have been $%s; don't worry about that extra: $%.2f",customer3,lattePrice,(lattePrice-dripPrice));


    }

}
