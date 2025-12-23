package lab;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.EOFException;
import java.io.IOException;

public class Q5 {
    public static void main(String[] args) {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("lab/lab07/person.dat"));
        
        int n = in.readInt();
        String[] nameArray = new String[n];
        int [] ageArray = new int[n];
        char [] genderArray = new char[n];

        for (int i = 0; i < n; i++) {
            nameArray[i] = in.readUTF();
            ageArray[i] = in.readInt();
            genderArray[i] = in.readChar();
        }

        for (int i = 0; i < n-1; i++){
            for (int j = 0; j < n - i - 1; j++){
                if (nameArray[j].compareTo(nameArray[j+1]) > 0){
                    String tempName = nameArray[j];
                    nameArray[j] = nameArray[j+1];
                    nameArray[j+1] = tempName;

                    int tempAge = ageArray[j];
                    ageArray[j] = ageArray[j+1];
                    ageArray[j+1] = tempAge;

                    char tempGender = genderArray[j];
                    genderArray[j] = genderArray[j+1];
                    genderArray[j+1] = tempGender;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            System.out.println(nameArray[i]);
            System.out.println(ageArray[i]);
            System.out.println(genderArray[i]);

        }
        in.close();

    } catch (EOFException e) {
        System.out.println("End of file reached.");

    } catch (IOException e) {
        System.out.println("IO Error: " + e.getMessage());
    }
    }
}