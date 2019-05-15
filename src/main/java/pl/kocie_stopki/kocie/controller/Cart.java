package pl.kocie_stopki.kocie.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.experimental.Accessors;
import pl.kocie_stopki.kocie.entity.Item;
import javax.persistence.OneToOne;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cart {

    @Accessors
    @OneToOne
    private ArrayList<Object> cart = new ArrayList<>();
    private double ProductsPrice = 0;
    private double finalPrice = 0;


    public void addItem(final int id, final String name, final Double price, final int quantity) {

        cart.add(new Item(id, name, price, quantity));
        System.out.println("Added Item id = " + id + ", name " + name);
        System.out.println(", quantity " + quantity + ", price " + price);
        for (int i = 0; i < cart.size(); i++) {
            cart.add(ProductsPrice);
            ProductsPrice += quantity * price;
            System.out.println("Products value  = " + ProductsPrice);
        }
        System.out.println(cart);
        for (int i = 0; i < cart.size(); i++) {
            finalPrice += ProductsPrice;
        }
        System.out.println("Your cart value is " + finalPrice);
    }
    public class PDFCreator {

        private  static final String DEST = "results/orders/order.pdf";

        public void PdfTable() {
            File file = new File(DEST);
            new pl.kocie_stopki.kocie.controller.Cart();//createPdf(DEST);
        }

        public void createPdf(String dest) throws IOException, DocumentException {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(dest));
            document.open();
            document.add(new Paragraph("Dear Customer this is autogenereted ORDER raport"));
            PdfPTable table = new PdfPTable(cart.size());
            table.setWidthPercentage(100);
            List<List<String>> dataset = getData();
            for (List<String> record : dataset) {
                for (String field : record) {
                    table.addCell(field);
                }
            }
            System.out.println("Total price to pay for the order is " + finalPrice);
            document.add(table);
            document.close();
        }

        public List<List<String>> getData() {
            List<List<String>> data = new ArrayList<List<String>>();
            String[] tableTitleList = {" Id " , " Name " , " Quantity " , " Price " , " Total Price"};
            data.add(Arrays.asList(tableTitleList));
            for (int i = 0; i < 10; ) {
                List<String> dataLine = new ArrayList<String>();
                i++;
                for (int j = 0; j < tableTitleList.length; j++) {
                    dataLine.add(tableTitleList[j] + " " + i);
                }
                data.add(dataLine);
            }
            return data;
        }


    }
}
