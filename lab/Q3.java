package lab;

import java.io.FileReader;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;

public class Q3 {
    public static void main(String[] args){
        try {
            BufferedReader in = new BufferedReader(new FileReader("input.txt"));
            PrintWriter out = new PrintWriter(new FileOutputStream("reverse.txt"));

            String line;

            while ((line = in.readLine()) != null) {
                String reversed = new StringBuilder(line).reverse().toString();
                out.write(reversed + "\n");
            }

            in.close();
            out.close();

            System.out.println("File reversed successfully.");

        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
    }
}

