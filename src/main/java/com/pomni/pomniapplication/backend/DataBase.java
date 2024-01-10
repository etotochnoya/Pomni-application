package com.pomni.pomniapplication.backend;

import java.util.List;

import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.DB;

// IvanOgarkov (password x83KYd+0)
public class DataBase {

    final static String dbName = System.getenv("DBNAME");
    final static String driver = "org.mariadb.jdbc.Driver";
    final static String url = String.format("jdbc:mariadb://%s", System.getenv("HOST"));
    final static String username = System.getenv("USER");
    final static String pass = System.getenv("PASS");
    final static String attribute = "string";

    public static void CreateConnection() {
        new DB(dbName).open(
                driver,
                url,
                username,
                pass
        );
    }

    public static void CloseConnection() {
        Base.close();
    }

    public static void createText(String str) {
        Text txt = new Text();
        txt.set(attribute, str);
        txt.saveIt();
    }

    public static String selectByID(int ID){
        return Text
                .findById(ID)
                .getString(attribute);
    }

    public static List<Text> selectAll() {
        return Text.findAll();
    }

    public  static void updateByID(int ID, String str) {
        Text txt = Text.findById(ID);
        txt.set(attribute, str).saveIt();
    }

    public static void deleteByID(int ID) {
        Text txt = Text.findById(ID);
        txt.delete();
    }

    public static int getIdCount()
    {
        return Math.toIntExact(Text.count());
    }

}
