import java.util.ArrayList;

public class CafeUtil {
    

    public int getStreakGoal(){

        int sum=0; 
        for(int i =0 ; i<11;i++){
            sum+=i;
        }
        return sum;
    }

    public double getOrderTotal(double[]prices){
        double total = 0;
        for (double price : prices) {
            total+=price;
        }

        return total;
    }

    public void displayMenu(ArrayList<String> menu){

            for (int i=0; i<menu.size();i++){
                System.out.println(i+" "+menu.get(i));
            }
    }

    public void addCustomer(ArrayList<String> customers){

        System.out.println("Please enter your name");
        String userName = System.console().readLine();
        System.out.println("Hello, "+userName);
        System.out.println("ther are "+customers.size()+" people ahead of you");
        customers.add(userName);
        System.out.printf("----Current Customer Queue-----\n %s",customers);

    }





}
