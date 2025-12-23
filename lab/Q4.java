package lab;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Q4 {
    public static void main(String[] args) {
        int characters = 0;
        int words = 0;
        int lines = 0;

        try {
            BufferedReader in = new BufferedReader(new FileReader("lab/lab07/lecturer.txt"));
            String line;

            while ((line = in.readLine()) != null) {
                lines++;

                characters += line.length();

                if (!line.isEmpty()) {
                    words += line.split(" ").length;
                }
            }

            in.close();

            System.out.println("Number of characters: " + characters);
            System.out.println("Number of words: " + words);
            System.out.println("Number of lines: " + lines);

        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
    }
}