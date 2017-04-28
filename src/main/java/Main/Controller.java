package Main;

import business.Record;
import db.RecordDB;
import db.SaleDB;
import gui.ConsignmentGUI;

import java.util.ArrayList;

/**
 * Created by mash4 on 4/25/2017.
 */
public class Controller {
    static ConsignmentGUI gui;
    static RecordDB rdb;
    static SaleDB sdb;
    public static void main(String[] args) {
        Controller contrl = new Controller();
        contrl.startApp();
        gui.displayCombox();

    }

    private void startApp() {
        rdb = new RecordDB();
        rdb.createTable();
        sdb = new SaleDB();
        sdb.createsSaleTable();

        ArrayList<Record> allInfo = rdb.fetchAllRecords();
        gui = new ConsignmentGUI(this, allInfo );

    }

    public void addRecods(Record r) {
        rdb.addRecord(r);
    }
}
