package com.lecaddyfute.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Document DatabaseUtils
 * @created on 22 janv. 2015, 20:16:20
 * @Author Nono Guy
 */
public class DatabaseUtils {

    public static String hote = "localhost";
    public static String port = "3306";
    public static String dataBase = "curamdb";
    public static String user = "root";
    public static String passWord = "root";

    public Set<String> getTablesName() {
        Set<String> nameTable = new HashSet();
        try {
//            Création d'un objet Statement
            Statement statement = null;
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + hote + ":" + port + "/" + dataBase;
            Connection connexion = DriverManager.getConnection(url, user, passWord);
            statement = connexion.createStatement();
            String dynamiqueQuery = "SELECT TABLE_NAME FROM information_schema.`TABLES` WHERE TABLE_SCHEMA=\"curamdb\"  AND TABLE_TYPE =\"BASE TABLE\";";
            ResultSet result = statement.executeQuery(dynamiqueQuery);
            //On récupère les MetaData
            ResultSetMetaData resultMeta = result.getMetaData();
            List<String> tableName = new ArrayList();
//            System.out.println("\n**********************************");
            //On affiche le nom des colonnes
            for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
                System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
//                tableName.add(resultMeta.getColumnName(i).toUpperCase());
            }
//            System.out.println("\n**********************************");
            String query = "ALTER TABLE `_tableName_` MODIFY COLUMN `signature`  char(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL AFTER `version`;";
            String query1 = "ALTER TABLE `_tableName_` MODIFY COLUMN `signature`  char(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL AFTER `version`;";
            String query2 = "ALTER TABLE `_tableName_` MODIFY COLUMN `signature`  char(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL AFTER `version`;";
            String query3 = "ALTER TABLE `_tableName_` MODIFY COLUMN `signature`  char(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL AFTER `version`;";
            while (result.next()) {
                for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
                    System.out.println("\t" + result.getObject(i).toString() + "\t |");
                    tableName.add(result.getObject(i).toString());
                    System.out.println("\n---------------------------------");
                }
            }
            for (String t : tableName) {
                String q = query.replace("_tableName_", t);
                System.out.println(q);
                statement.executeUpdate(q);
            }
            result.close();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return nameTable;
    }

    public static void main(String[] args) {
        DatabaseUtils dbu = new DatabaseUtils();
        dbu.getTablesName();
    }
}
