package LAB04;
import java.io.*;
import java.util.*;

public class bankingsystem 
{
    static Scanner sc = new Scanner(System.in);

    static class Customer 
    {
        int cid;
        String cname;
        double amount;

        Customer(int cid, String cname, double amount) throws Exception 
        {
            if(cid < 1 || cid > 20) 
                throw new Exception("Invalid CID");

            if(amount < 1000) 
                throw new Exception("Minimum balance should be 1000");

            this.cid = cid;
            this.cname = cname;
            this.amount = amount;
        }

        void deposit(double amt) throws Exception 
        {
            if(amt <= 0) 
                throw new Exception("Invalid deposit");

            amount += amt;
        }

        void withdraw(double amt) throws Exception 
        {
            if(amt > amount) 
                throw new Exception("Insufficient balance");

            amount -= amt;
        }

        public String toString() 
        {
            return cid + " " + cname + " " + amount;
        }
    }

    public static void main(String[] args) 
    {
        Customer c = null;
        int choice;

        while(true) 
        {
            System.out.println("1.Create Account 2.Deposit 3.Withdraw 4.Display 5.Exit");
            choice = sc.nextInt();

            try 
            {
                if(choice == 1) 
                {
                    System.out.print("Enter CID: ");
                    int id = sc.nextInt();

                    System.out.print("Enter Name: ");
                    String name = sc.next();

                    System.out.print("Enter Amount: ");
                    double amt = sc.nextDouble();

                    c = new Customer(id, name, amt);

                    FileWriter fw = new FileWriter("bank.txt", true);
                    fw.write(c.toString() + "\n");
                    fw.close();

                    System.out.println("Account Created");
                } 
                else if(choice == 2) 
                {
                    System.out.print("Enter deposit amount: ");
                    double amt = sc.nextDouble();
                    c.deposit(amt);
                    System.out.println("Updated Balance: " + c.amount);
                } 
                else if(choice == 3) 
                {
                    System.out.print("Enter withdraw amount: ");
                    double amt = sc.nextDouble();
                    c.withdraw(amt);
                    System.out.println("Updated Balance: " + c.amount);
                } 
                else if(choice == 4) 
                {
                    BufferedReader br = new BufferedReader(new FileReader("bank.txt"));
                    String line;
                    while((line = br.readLine()) != null) 
                    {
                        System.out.println(line);
                    }
                    br.close();
                } 
                else if(choice == 5) 
                {
                    break;
                } 
                else 
                {
                    System.out.println("Invalid choice");
                }
            } 
            catch(Exception e) 
            {
                System.out.println(e.getMessage());
            }
        }
    }
}
