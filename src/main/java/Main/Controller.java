package Main;

import business.Records;
import db.RecordsDB;
import gui.ConsignmentGUI;

import java.util.ArrayList;

/**
 * Created by mash4 on 4/25/2017.
 */
public class Controller {
    static ConsignmentGUI gui;
    static RecordsDB rdb;
    public static void main(String[] args) {
        Controller contrl = new Controller();
        contrl.startApp();
        gui.displayCombox();

    }

    private void startApp() {
        rdb = new RecordsDB();
        rdb.createTable();

        ArrayList<Records> allInfo = rdb.fetchAllRecords();
        gui = new ConsignmentGUI(this, allInfo );

    }

    public void addRecods(Records r) {
        rdb.addRecord(r);
    }
}
