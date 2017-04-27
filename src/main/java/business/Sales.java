package business;

/**
 * Created by mash4 on 4/25/2017.
 */
public class Sales  {
    String consName;
    int consignID;
    double totalPayment;
    double paidAmount;
    double unpaidAmount;
    double totalAmount;

    public Sales(String consName,int consID, int numberOfitems, String artist,
                 String title, double sellingPrx,
                 double totalAmount, double paidAmount, double unpaidAmount ) {
        this.consName = consName;
        this.consignID = consID;



    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalAmount - unpaidAmount;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public double getUnpaidAmount() {
        return unpaidAmount;
    }

    public void setUnpaidAmount(double unpaidAmount) {
        unpaidAmount = totalAmount - paidAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }




    @Override
    public String toString() {
        return "Sales Records " +
                " Consignor Name " + consName+
                ", Consignor ID " + consignID +
                ", totalPayment=   " + totalAmount  +
                ", paidAmount=  " + paidAmount +
                ", unpaidAmount=  " + unpaidAmount;
    }
}
