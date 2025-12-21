package lab;

import java.util.Scanner;
import java.net.URL;
import java.net.URLConnection;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileOutputStream;

public class Q2 {
    public static void main(String[] args) {
        try {
            URL u = new URL("http://www.fsktm.um.edu.my");
            URLConnection cnn = u.openConnection();
            InputStream stream = cnn.getInputStream();
            Scanner in = new Scanner(stream);

            PrintWriter out = new PrintWriter(new FileOutputStream("index.htm"));

            while (in.hasNextLine()) {
                out.write(in.nextLine() + "\n");
            }

            out.close();
            System.out.println("Web page content saved to index.htm");

        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
    }
}
