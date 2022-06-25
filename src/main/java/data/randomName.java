package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

import static java.lang.Math.round;

public class randomName {
    public static void main(String[] args) throws IOException {
        //random name txt from file first_name.txt last_name.txt , date_of_bith and write to file student.csv
//        File file = new File("E:/java_mysql/src/main/java/data/semester.txt");
        File file = new File("D:/BT/Java/MySQL/data/student_id.txt");

//        File file = new File("E:/java_mysql/src/main/java/data/subject_id.txt");
//        File file = new File("E:/java_mysql/src/main/java/data/subject_id.txt");
//        File file = new File("E:/java_mysql/src/main/java/data/subject_id.txt");
        FileWriter fileWriter = new FileWriter(file);
        File file1 = new File("D:/BT/Java/MySQL/data/first_name.txt");
        File file2 = new File("D:/BT/Java/MySQL/data/last_name.txt");
        Scanner scanner1 = new Scanner(file1);
        Scanner scanner2 = new Scanner(file2);
        ArrayList<String> first_name = new ArrayList<>();
        ArrayList<String> last_name = new ArrayList<>();
        while (scanner1.hasNextLine()) {
            first_name.add(scanner1.nextLine());
        }
        while (scanner2.hasNextLine()) {
            last_name.add(scanner2.nextLine());
        }
        Random rd = new Random();
        for (int i = 0; i < 1000000; i++) {
//            fileWriter.append(String.valueOf(rd.nextFloat((10  ))+1) );
//            fileWriter.append("\n");

            if (i < 3000) {
                fileWriter.append(String.valueOf(first_name.get(rd.nextInt(20)) + " " + last_name.get(rd.nextInt(76))));
                fileWriter.append("\n");

            } else if (i < 6000) {
                fileWriter.append(String.valueOf(first_name.get(rd.nextInt(20)) + " " + last_name.get(rd.nextInt(76))));
                fileWriter.append("\n");
            } else if (i < 10000) {
                fileWriter.append(String.valueOf(first_name.get(rd.nextInt(20)) + " " + last_name.get(rd.nextInt(76))));
                fileWriter.append("\n");
            }
        }
        fileWriter.flush();
        fileWriter.close();
    }
}


