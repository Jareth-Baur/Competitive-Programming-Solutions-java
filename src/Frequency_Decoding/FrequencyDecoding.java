package Frequency_Decoding;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FrequencyDecoding {
    public static void main(String[] args) throws FileNotFoundException {
        File decodeFile = new File("decode.in");
        Scanner scan = new Scanner(decodeFile);

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] words = line.split(" ");

            System.out.println(words);

        }
    }
}
