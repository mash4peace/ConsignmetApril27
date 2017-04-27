package business;

import java.text.NumberFormat;
import java.util.Date;

/**
 * Created by mash4 on 4/25/2017.
 */
public class Record {
    private int consignorID;
    private String consignorName;
    private int numberOfItems;
    private String artist;
    private String title;
    private double sellsPrice;
    private double totalAmount;
    private double paidAmount;
    private double unpaidAmount;

    Date date = new Date();



    private static int tickedID = 1;


    public Record(String consName, int numberOfitems, String artist, String title, double sellingPrx, Date date) {
        this.consignorName = consName;
        this.numberOfItems = numberOfitems;
        this.artist = artist;
        this.title = title;
        this.date = date;
        this.sellsPrice = sellingPrx;
        this.consignorID = tickedID;
        tickedID ++;
    }
    public Record(String consName,int consID, int numberOfitems, String artist, String title, double sellingPrx) {
        this.consignorName = consName;
        this.numberOfItems = numberOfitems;
        this.artist = artist;
        this.title = title;
        this.sellsPrice = sellingPrx;

    }
    public Record(String consignorName, int consID, int numberOfItems, double sellsPrice){
        this.consignorName = consignorName;
        this.consignorID = consID;
        this.numberOfItems = numberOfItems;
        this.sellsPrice = sellsPrice;
    }
    public Record(int consID,String consignorName,  int numberOfItems, double sellsPrice,
                  double totalAmount, double paidAmount, double unpaidAMount){
        this.consignorName = consignorName;
        this.consignorID = consID;
        this.numberOfItems = numberOfItems;
        this.sellsPrice = sellsPrice;
        this.totalAmount = totalAmount;
        this.paidAmount = paidAmount;
        this.unpaidAmount = unpaidAMount;
    }

    public int getConsignorID() {
        return consignorID;
    }

    public void setConsignorID(int consignorID) {
        this.consignorID = consignorID;
    }

    public String getConsignorName() {
        return consignorName;
    }

    public void setConsignorName(String consignorName) {
        this.consignorName = consignorName;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getSellsPrice() {
        return sellsPrice;
    }

    public void setSellsPrice(double sellsPrice) {
        this.sellsPrice = numberOfItems * sellsPrice;
    }



    public Date getDate() {

        return date;
    }

    public String getPriceFormatted(){
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        return currencyFormat.format(getSellsPrice());
    }

    @Override
    public String toString() {
        return " Consignment Records : " +
                "consignorID=  " + consignorID +
                ", consignorName='  " + consignorName + '\'' +
                ", numberOfItems= " + numberOfItems +
                ", artist=' " + artist + '\'' +
                ", title=' " + title + '\'' +
                ", sellsPrice= " + sellsPrice +
                ", Date " + date;
    }
}
