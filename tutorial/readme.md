# Tutorial 

1. Write statements for each of the following
    
    a. Store ten random integers within 0 to 1000 to a text file name integer.txt.
    ```java
    try{
        PrintWriter outputStream = new PrintWriter(new FileOutputStream("integer.txt"));
        Random rand = new Random();

        for (int i=0; i <10; i++){
            outputStream.print(rand.nextInt(1001)+ " ");
        }
        outputStream.close();
    } catch (IOException e){
        System.out.println("Problem with file output");
    }
    ```

    b. Read from the text file generated in a. Display all the integer and the largest integer.
    ```java
    try{
        Scanner in = new Scanner(new FileInputStream("integer.txt"));
    
        int max = 0;
        while(in.hasNextInt()){
            int num = in.nextInt();
            if(num>max) max = num;
            System.out.println(num);
        }
        System.out.println("The maximum number is"+ max);
    } catch (FileNotFoundException e){
        System.out.println("File was not found");
    }
    ```

    c. Store ten random integers within 0 to 1000 to a binary file name integer.dat.
    ```java
    try{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("integer.dat"));

        Random rand = new Random;

        for (int i = 0; i < 10; i++){
            out.writeInt(rand.nextInt(1001));
        }
        out.close();
    } catch (IOException e){
        System.out.println("Problem with file output");
    }
    ```

    d. Read from the binary file generated in a c. Display the all the integer and the average.
    ```java
    try {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("integer.dat"));

        int sum = 0;
        int count = 0;

        while (true) {
            int num = in.readInt();
            System.out.println(num);
            sum += num;
            count++;
        }
    } catch (FileNotFoundException e) {
        System.out.println("The file was not found.");
    } catch (EOFException e) {
        double average = (double) sum / count;
        System.out.println("Average: " + average);
    } catch (IOException e) {
        System.out.println("Problem with file input.");
    }
    ```

2. Correct the error for the following statements.

    a. 
    ```java
    PrintWriter out = new PrintWriter(new FileOutputStream("d:\data\matrix.txt"));
    ```
    ```java
    PrintWriter out = new PrintWriter(new FileOutputStream("d:/data/matrix.txt"));
    ```
    b.
    ```java
    try {
        PrintWriter out = new PrintWriter(new FileOutputStream("data.txt"));
        out.close();
    } catch (FileNotFoundException e) {
        System.out.println("Problem with file output");
    }
    ```
    ```java
    try {
        PrintWriter out = new PrintWriter(new FileOutputStream("data.txt"));
        out.close();
    } catch (IOException e) {
        System.out.println("Problem with file output");
    }
    ```
    c.
    ```java
    int num;
    Scanner a = new Scanner(new FileInputStream("data.dat"));
    num = a.readInt();
    a.close();
    ```
    ```java
    int num;
    try{
        ObjectInputStream a = new ObjectInputStream(new FileInputStream("data.dat"));
        num = a.readInt();
        a.close();
    }
    ```

    d.
    ```java
    ObjectOutputStream o = new ObjectOutputStream (new
    FileOutputStream("data.dat"));
    o.print('A');
    o.close();
    ```
    ```java
    ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("data.dat"));
    o.writeChar('A'); 
    o.close();
    ```

3. Write a program that convert a sentence into binary number (ASCII code 8 bit) and store it in a text file named data.txt. Then, read from the text file and display the sentence.
    ```java
    import java.io.FileOutputStream;
    import java.io.FileInputStream;
    import java.io.PrintWriter;
    import java.io.IOException;
    import java.util.Scanner;

    public class SentenceToBinary {
        public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        try {
            PrintWriter out = new PrintWriter(new FileOutputStream("data.txt"));

            for (int i = 0; i < sentence.length(); i++) {
                char ch = sentence.charAt(i);

                String binary = String.format("%8s", Integer.toBinaryString(ch)).replace(' ', '0');
                out.print(binary + " ");
            }
            out.close();
        } catch (IOException e) {
            System.out.println("Error writing to file");
        }

        try {
            Scanner in = new Scanner(new FileInputStream("data.txt"));
            String result = "";

            while (in.hasNext()) {
                String bin = in.next();
                int charCode = Integer.parseInt(bin, 2);
                result = result + (char) charCode;
            }

            in.close();
            System.out.println("The sentence is: " + result);

        } catch (IOException e) {
            System.out.println("Error reading from file");
        }
        }
    }
    ```