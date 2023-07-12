package banking;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Bank {
    public static void main(String[] args){
        // To DO auto generated method stub
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        // Generating the customer ID
        // Extracting the initials from the name
        StringBuilder initials = new StringBuilder();
        String[] nameParts = name.split(" ");
        for (String part : nameParts) {
            initials.append(part.charAt(0));
        }

        // Generating a random number
        int randomNumber = (int) (Math.random() * 100000);

        // Creating the CID by combining the initials and random number
        String cid = initials.toString().toUpperCase() + randomNumber;

        // Creating an account object with the generated CID
        Account account = new Account(name, cid);

        // Store name and ID in a text file
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("customer.txt"));
            writer.write("Name: " + name);
            writer.newLine();
            writer.write("CID: " + cid);
            writer.close();
            System.out.println("Customer details saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving customer details to file.");
        }
        account.showMenu();
    }
}
