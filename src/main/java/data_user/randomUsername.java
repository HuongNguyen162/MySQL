package data_user;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class randomUsername {
    public static void main(String[] args) throws IOException {
//        generate random user id 4 char unique from latin and number and write to username.txt
        File file = new File("src/main/java/data_user/username.txt");
        FileWriter fw = new FileWriter(file);
        Random r = new Random();
        ArrayList<String> username = new ArrayList<>();
        for (int i = 0; i < 1500000; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 6; j++) {
                sb.append((char) (r.nextInt(26) + 'a'));
            }
            username.add(sb.toString());
        }
        for (String s : username) {
            fw.write(s + "\n");
        }
        fw.close();
       


        
    }
}
//}


