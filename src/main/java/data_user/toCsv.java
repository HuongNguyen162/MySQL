package data_user;

import java.io.*;
import java.util.ArrayList;


public class toCsv {
    // ghi vào file user.csv các cột username, fullname, province , age tương ứng các file username.txt, fullname.txt, ramdomTP.txt, age.txt
    public static void main(String[] args) {
        ArrayList<String> username = new ArrayList<>();
        ArrayList<String> fullname = new ArrayList<>();
        ArrayList<String> province = new ArrayList<>();
        ArrayList<String> age = new ArrayList<>();
        ArrayList<String> randomTP = new ArrayList<>();

        
        //ghi vào file user.csv
        try {
            FileWriter fw = new FileWriter(new File("src/main/java/data_user/users.csv"));
            fw.write("id,user_name,full_name,province,age\n");
            //id auto increment
            
            //ghi id vào cột id 
            int id = 1;

            //ghi từ file username.txt vào cột username
            File file = new File("src/main/java/data_user/username.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                username.add(line);
            }
            br.close();
            //ghi từ file fullname.txt vào cột fullname
            file = new File("src/main/java/data_user/fullname.txt");
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            line = "";
            while ((line = br.readLine()) != null) {
                fullname.add(line);
            }
            br.close();
            //ghi từ file randomTP.txt vào cột province
            file = new File("src/main/java/data_user/randomTP.txt");
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            line = "";
            while ((line = br.readLine()) != null) {
                province.add(line);
            }
            br.close();
            //ghi từ file age.txt vào cột age
            file = new File("src/main/java/data_user/age.txt");
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            line = "";
            while ((line = br.readLine()) != null) {
                age.add(line);
            }
            br.close();
            //ghi từ file randomTP.txt vào cột randomTP
            file = new File("src/main/java/data_user/randomTP.txt");
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            line = "";

            while ((line = br.readLine()) != null) {
                randomTP.add(line);
            }
            br.close();
            //ghi vào file user.csv
            for (int i = 0; i < username.size(); i++) {
                fw.write(id + ",");
                fw.write(username.get(i) + ",");
                fw.write(fullname.get(i) + ",");
                fw.write(province.get(i) + ",");
                fw.write(age.get(i) + "\n");
                id++;
            }
            

            fw.close();
            id++;
        } catch (IOException e) {
            e.printStackTrace();
            

        }
    }
}
        
        

    
    

