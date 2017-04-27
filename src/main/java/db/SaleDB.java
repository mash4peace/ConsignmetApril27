package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by mash4 on 4/27/2017.
 */

public class SaleDB {
    private static final String JDBC_Driver = "com.mysql.cj.jdbc.Driver";
    private static final String DB_CONNECTION_URL=  "jdbc:mysql://localhost:3306/consignment";
    private static final String USER = ("mash4peace");
    private  static final String PASSWORDS = System.getenv("MYSQL_pw");
    private static final String TABLE_NAME = "sales";
    private static final String CONSIGNORID_COL = "consgnrID";
    private static final String CONSIGNOrName_COL = "consgnorName";
    private static final String NUMBERofITEMS_COL = "items";
    private static final String SELLSpRX_COL = "sellsPrice";
    private static final String TOTALAMOUNTDUE_COL = "totalAmountDue";
    private static final String PAIDAMOUNT_COL = "paidAmount";
    private static final String UNPAIDAMOUNT_COL = "unPaidAmount";

    public SaleDB(){
        try{
            Class.forName(JDBC_Driver);
        }catch (ClassNotFoundException clnf){
            System.out.println("Can't instantiate driver class," +
                    "check you have a driver and classpath configured correctly!");
            clnf.getCause();
            clnf.printStackTrace();
            System.exit(-1);

        }

    }



    public void createsSaleTable() {
        try(Connection conn = DriverManager.getConnection(DB_CONNECTION_URL, USER, PASSWORDS);
            Statement statement = conn.createStatement()){
            String createTablesSQLTEM =
                    "CREATE TABLE IF NOT EXISTS %sales ("+ " consgnrID INTEGER NOT NULL AUTO_INCREMENT,"+
                            " consgnorName VARCHAR(100) NOT NULL"+ ", items INTEGER " + ", sellsPrice DOUBLE " +
                            " totalAmountDue DOUBLE "+ " paidAmount DOUBLE "+ " unPaidAmoun DOUBLE " ;
            String createTableSQl = String.format(createTablesSQLTEM, TABLE_NAME, CONSIGNORID_COL, CONSIGNOrName_COL,
                    NUMBERofITEMS_COL, SELLSpRX_COL, TOTALAMOUNTDUE_COL, PAIDAMOUNT_COL, UNPAIDAMOUNT_COL);
            System.out.println(createTableSQl);
            System.out.println("Sale table is created ");
            statement.close();
            conn.close();


        }catch (SQLException s){
            s.getCause();
            s.printStackTrace();
        }

    }
}
