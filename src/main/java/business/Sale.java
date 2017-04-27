package business;

/**
 * Created by mash4 on 4/25/2017.
 */
public class Sale  {
    String consName;
    int consignID;
    double totalPayment;
    double paidAmount;
    double unpaidAmount;
    int items;
    double salePrx;



    public Sale(String consName,int consID, int numberOfitems, String artist,
                 String title, double sellingPrx,
                 double totalAmount, double paidAmount, double unpaidAmount ) {
        this.consName = consName;
        this.consignID = consID;



    }




    @Override
    public String toString() {
        return "Sales Records " +
                " Consignor Name " + consName+
                ", Consignor ID " + consignID +
                ", totalPayment=   " + totalPayment  +
                ", paidAmount=  " + paidAmount +
                ", unpaidAmount=  " + unpaidAmount;
    }
}
