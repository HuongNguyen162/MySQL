package com.cuminhtien;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

import static java.lang.Math.random;

public class connectMysql {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://172.17.80.26:3306/masterdev_huongnl2?serverTimezone=UTC&useSSL=false";

    static final String USER = "huongnl2";
    static final String PASS = "92GfmJZHcfyWUG4H";


    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {

            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database...");

            String sql = "insert into student_class (student_id,class_id,scores)" + " values (?,?,?)";
            PreparedStatement preparedStmt = connection.prepareStatement(sql);

            try {
                File myObj = new File("D:/BT/Java/MySQL/data/student_id.txt");
                Scanner myReader = new Scanner(myObj);
                File myObj1 = new File("D:/BT/Java/MySQL/data/class_id.txt");
                Scanner myReader1 = new Scanner(myObj1);
                File myObj2 = new File("D:/BT/Java/MySQL/data/scores.txt");
                Scanner myReader2 = new Scanner(myObj2);

                int count = 0;

                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    String subject = myReader1.nextLine();
                    String scores = myReader2.nextLine();

                    preparedStmt.setString(1, data);

                    preparedStmt.setString(2, subject);

                    preparedStmt.setString(3,scores);

                    preparedStmt.execute();

                    System.out.println(data);
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

                System.out.println("Inserted records into the table...");
                System.out.println("Insert data success");
            } catch(SQLException | ClassNotFoundException se){
                se.printStackTrace();
            }
            System.out.println("Done!");

    }
}
