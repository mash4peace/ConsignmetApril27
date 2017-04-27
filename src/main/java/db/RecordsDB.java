package db;

import business.Records;

import java.sql.*;
import java.util.ArrayList;


/**
 * Created by mash4 on 4/25/2017.
 */
public class RecordsDB {
    private static final String JDBC_Driver = "com.mysql.cj.jdbc.Driver";
    private static final String DB_CONNECTION_URL=  "jdbc:mysql://localhost:3306/consignment";
    private static final String USER = ("mash4peace");
    private  static final String PASSWORDS = System.getenv("MYSQL_pw");
    private static final String TABLE_NAME = "products";
    private static final String CONSIGNOrName_COL = "consgnorName";
    private static final String CONSIGNORID_COL = "consgnrID";
    private static final String NUMBERofITEMS_COL = "items";
    private static final String ARTIST_COL = "artitsName";
    private static final String TITLE_COL = "title";
    private static final String SELLSpRX_COL = "sellsPrice";

    public RecordsDB(){
        try{
            Class.forName(JDBC_Driver);
        }catch (ClassNotFoundException cnfe){
            System.out.println("Can't instantiate driver class, "+
            "check you have a driver and classpath configured  correctly!");
            cnfe.printStackTrace();
            System.exit(-1);
        }
    }



    public void createTable() {
        try(Connection conn = DriverManager.getConnection(DB_CONNECTION_URL, USER, PASSWORDS);
        Statement statement = conn.createStatement()){
            String createTableSQLTem =
                    "CREATE TABLE IF NOT EXISTS %s ( "+ "%s INTEGER NOT NULL     AUTO_INCREMENT," +
                            "%s Varchar(100) NOT NULL  "+ ",%s INTEGER  "+
                            ",%s VARCHAR(100)" + ",%s VARCHAR(100)" + ",%s  DOUBLE , primary key(%s))";
            String createTableSQL = String.format(createTableSQLTem, TABLE_NAME, CONSIGNORID_COL,
                    CONSIGNOrName_COL, NUMBERofITEMS_COL, ARTIST_COL,
                    TITLE_COL, SELLSpRX_COL, CONSIGNORID_COL);
            System.out.println(createTableSQL);

            statement.executeUpdate(createTableSQL);
            System.out.println("Consignment Table is created !!!");
            statement.close();
            conn.close();

        }catch (SQLException s){
            s.getCause();
            s.printStackTrace();
        }


    }

    public void addRecord(Records records) {
        try(Connection conn = DriverManager.getConnection(DB_CONNECTION_URL, USER, PASSWORDS)  ) {
            String addPrdtSQL = "INSERT INTO products(consgnorName, items, artitsName, title, sellsPrice"+
                    ") VALUES (?,?,?,?, ?)";
            //String addPdtSQL = String.format("INSERT INTO " + TABLE_NAME + "(%s, %s, %s, %s, %s,%s, %s)",
                  //  CONSIGNOrName_COL, CONSIGNORID_COL,
                   // NUMBERofITEMS_COL, ARTIST_COL, TITLE_COL, SELLSpRX_COL);
            PreparedStatement addRecodsPS = conn.prepareStatement(addPrdtSQL);
            addRecodsPS.setString(1, records.getConsignorName());

            addRecodsPS.setInt(2, records.getNumberOfItems());
            addRecodsPS.setString(3, records.getArtist());
            addRecodsPS.setString(4, records.getTitle());
            addRecodsPS.setDouble(5, records.getSellsPrice());
            System.out.println(addRecodsPS);

            addRecodsPS.execute();
            System.out.println("added products in the consignment " + records);

            addRecodsPS.close();
            conn.close();

        }catch (SQLException s){
            s.getCause();
            s.printStackTrace();
        }

    }

    public ArrayList<Records> fetchAllRecords() {
        ArrayList<Records> allRecords= new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_CONNECTION_URL, USER, PASSWORDS);
             Statement statement = conn.createStatement()) {
            String selctALLSQL = "SELECT * FROM "+ TABLE_NAME;
            ResultSet rsall = statement.executeQuery(selctALLSQL);

            while(rsall.next()){

                String consName = rsall.getString(CONSIGNOrName_COL);
                int consID = rsall.getInt(CONSIGNORID_COL);
                int items = rsall.getInt(NUMBERofITEMS_COL);
                String artist = rsall.getString(ARTIST_COL);
                String title = rsall.getString(TITLE_COL);
                double sellingPrx = rsall.getDouble(SELLSpRX_COL);

            }
            rsall.close();
            statement.close();
            conn.close();
            return allRecords;



    }catch (SQLException s ){
            s.getCause();
            s.printStackTrace();
            return null;
        }


        }


}
