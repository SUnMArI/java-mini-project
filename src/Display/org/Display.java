package Display.org;

import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.ArrayList;
import java.util.Scanner;

import Production.org.Product;
public class Display {

    public void displayedCaption(){
        System.out.println("\n" +
                " ██████╗███████╗████████╗ █████╗ ██████╗          ██╗ █████╗ ██╗   ██╗ █████╗ \n" +
                "██╔════╝██╔════╝╚══██╔══╝██╔══██╗██╔══██╗         ██║██╔══██╗██║   ██║██╔══██╗\n" +
                "██║     ███████╗   ██║   ███████║██║  ██║         ██║███████║██║   ██║███████║\n" +
                "██║     ╚════██║   ██║   ██╔══██║██║  ██║    ██   ██║██╔══██║╚██╗ ██╔╝██╔══██║\n" +
                "╚██████╗███████║   ██║   ██║  ██║██████╔╝    ╚█████╔╝██║  ██║ ╚████╔╝ ██║  ██║\n" +
                " ╚═════╝╚══════╝   ╚═╝   ╚═╝  ╚═╝╚═════╝      ╚════╝ ╚═╝  ╚═╝  ╚═══╝  ╚═╝  ╚═╝\n" +
                "                                                                              \n");
    }
    public void displayMenu(String ... a){
        String total="";
        CellStyle numberStyle = new CellStyle(CellStyle.HorizontalAlign.center);
        Table t = new Table(1, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE,
                ShownBorders.SURROUND_HEADER_FOOTER_AND_COLUMNS);
        t.setColumnWidth(0, 20, 200);

        for (String b:a){
            total+=b;
        }

        t.addCell(total);
        System.out.println(t.render());
    }
    public char displaySelection(){
        char ch;
        System.out.print("Command-->");
        return new Scanner(System.in).nextLine().charAt(0);
    }
    public void displayRecord(ArrayList<Product> arrayList){
        CellStyle numberStyle = new CellStyle(CellStyle.HorizontalAlign.center);
        Table t = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE,
                ShownBorders.SURROUND_HEADER_FOOTER_AND_COLUMNS);
        t.setColumnWidth(0, 10, 50);
        t.setColumnWidth(1, 20, 50);
        t.setColumnWidth(2, 20, 50);
        t.setColumnWidth(3, 20, 50);
        t.setColumnWidth(4, 20, 50);
        t.addCell("ID",numberStyle);
        t.addCell("Name",numberStyle);
        t.addCell("Unit Price",numberStyle);
        t.addCell("Qty",numberStyle);
        t.addCell("Import Date",numberStyle);


        for (Product p : arrayList){
            t.addCell(String.valueOf(p.getID()),numberStyle);
            t.addCell(String.valueOf(p.getProductName()),numberStyle);
            t.addCell(String.valueOf(p.getProductPrice()),numberStyle);
            t.addCell(String.valueOf(p.getQuantity()),numberStyle);
            t.addCell(String.valueOf(p.getDate()),numberStyle);
        }
        t.addCell("Total Record:"+arrayList.size(),5);
        System.out.println(t.render());
    }

    public void displayAnElement(ArrayList<Product> arrayList , int index){

        CellStyle numberStyle = new CellStyle(CellStyle.HorizontalAlign.center);
        Table t = new Table(2, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE,
                ShownBorders.SURROUND_HEADER_AND_COLUMNS);
        t.setColumnWidth(0, 10, 50);
        t.setColumnWidth(1, 30, 50);
        t.addCell("ID",numberStyle);
        t.addCell(String.valueOf(String.valueOf(arrayList.get(index).getID())),numberStyle);
        t.addCell("Product's Name",numberStyle);
        t.addCell(String.valueOf(String.valueOf(arrayList.get(index).getProductName())),numberStyle);
        t.addCell("Unit Price",numberStyle);
        t.addCell(String.valueOf(String.valueOf(arrayList.get(index).getProductPrice())),numberStyle);
        t.addCell("Qty",numberStyle);
        t.addCell(String.valueOf(String.valueOf(arrayList.get(index).getQuantity())),numberStyle);
        t.addCell("Date",numberStyle);
        t.addCell(String.valueOf(String.valueOf(arrayList.get(index).getDate())),numberStyle);
        System.out.println(t.render());
    }


}
