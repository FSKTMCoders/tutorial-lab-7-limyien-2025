package lab;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {

    try{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("coursename.dat"));
        
        out.writeUTF("WXES1116");
        out.writeUTF("Programming I");

        out.writeUTF("WXES1115");
        out.writeUTF("Data Structure");

        out.writeUTF("WXES1110");
        out.writeUTF("Operating System");

        out.writeUTF("WXES1112");
        out.writeUTF("Computing Mathematics I");

        out.close();
    } catch (IOException e) {
        System.out.println("Problem with file output");
    }

    Scanner sc = new Scanner(System.in);
    System.out.print("Enter course code: "); 
    String code = sc.nextLine();

    boolean found = false;

    try{
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("coursename.dat"));

        while(true){
            String courseCode = in.readUTF();
            String courseName = in.readUTF();

            if(courseCode.equals(code)){
                System.out.println("Course Name: " + courseName);
                found = true;
                break;
            }
        }
        in.close();
    } catch (EOFException e) {
        if(!found){
            System.out.println("Course code not found.");
        }
    } catch (IOException e) {
        System.out.println("Problem with file input");
    }
    }
}