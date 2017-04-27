package gui;

import Main.Controller;
import business.Record;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by mash4 on 4/25/2017.
 */
public class ConsignmentGUI extends JFrame {
    private JPanel rootPanel;
    private JTextField artitsTextField;
    private JTextField nametextField;
    private JList consignmentJlist;
    private JTextField titletextField;
    private JComboBox numberOfItemscomboBox;
    private JButton addConsignorButton;
    private JTextField sellingPrxtextField;
    private DefaultListModel consignmentListModel;

    //private Controller contr;
    double sellingPrx;
    private Controller cntr;

    public ConsignmentGUI(Controller contrl, ArrayList<Record> allrecods){
        this.cntr = contrl;
        consignmentListModel = new DefaultListModel();
        consignmentJlist.setModel(consignmentListModel);
        setTitle("Consignment Project !!!!");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(rootPanel);
        pack();
        setVisible(true);

        consignmentListModel = new DefaultListModel<>();
        for(Record r : allrecods){
            consignmentListModel.addElement(r);
        }
        consignmentJlist.setModel(consignmentListModel);
        consignmentJlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);





        addConsignorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nametextField.getText();
                if(name.trim().length() == 0){
                    JOptionPane.showMessageDialog(ConsignmentGUI.this, "Please enter consignor name ");
                    return;
                }

                int intItem = (int) numberOfItemscomboBox.getSelectedItem();
                String artist = artitsTextField.getText();
                if(artist.trim().length() == 0){
                    JOptionPane.showMessageDialog(ConsignmentGUI.this, "Enter the artist !");
                    return;
                }
                String title = titletextField.getText();
                if(title.trim().length()== 0){
                    JOptionPane.showMessageDialog(ConsignmentGUI.this, "Enter song title here !!");
                    return;
                }

                try{
                    sellingPrx = Double.parseDouble(sellingPrxtextField.getText());
                    if(sellingPrx < 0){
                        JOptionPane.showMessageDialog(ConsignmentGUI.this, "Enter a psoitive number ");
                        return;
                    }
                    Date date = new Date();

                    Record r = new Record(name,intItem, artist, title, sellingPrx, date);
                    consignmentListModel.addElement(r);
                    cntr.addRecods(r);

                }catch (NumberFormatException nfe ){
                    JOptionPane.showMessageDialog(ConsignmentGUI.this, "Enter a positive number ");
                }





            }
        });


    }





    public void displayCombox() {
        int i ;

        for (i = 1; i <=50 ; i++) {
            numberOfItemscomboBox.addItem(i);

        }
    }
}
