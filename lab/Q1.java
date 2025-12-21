    package lab;

    import java.io.PrintWriter;
    import java.io.FileOutputStream;
    import java.util.Random;
    import java.io.IOException;

    public class Q1 {
        public static void main(String[] args) throws Exception {

    try{
    PrintWriter outputStream = new PrintWriter(new FileOutputStream("integer.txt"));
    Random rand = new Random();
    
    for (int i=0; i <10; i++){
        outputStream.println(rand.nextInt(1000));
    }
    outputStream.close();
    }catch(IOException e){
        System.out.println("Problem with file output");
    }
        }
    }