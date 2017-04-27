package business;

/**
 * Created by mash4 on 4/25/2017.
 */
public class Sales extends Records {
    double totalPayment;
    double paidAmount;
    double unpaidAmount;
    double totalAmount;

    public Sales(String consName, int numberOfitems, String artist,
                 String title, double sellingPrx,
                 double totalAmount, double paidAmount, double unpaidAmount ) {
        super(consName,numberOfitems, artist, title, sellingPrx );

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

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = getNumberOfItems() * getSellsPrice();
    }

    @Override
    public String toString() {
        return "Sales Records " +
                " Consignor Name " + getConsignorName()+
                ", Consignor ID " + getConsignorID()+
                ", totalPayment=   " + totalAmount  +
                ", paidAmount=  " + paidAmount +
                ", unpaidAmount=  " + unpaidAmount;
    }
}
