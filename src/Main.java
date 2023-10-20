
import Display.org.Display;
import Production.org.Product;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;
import org.nocrala.tools.texttablefmt.CellStyle.HorizontalAlign;

import javax.print.attribute.standard.PrinterURI;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<Product>();
        products.add(new Product(1,"Pepsi",2000,12, LocalDate.now()));
        products.add( new Product(2,"Coca",2000,24, LocalDate.now()));
        products.add( new Product(3,"Sting",2000,24, LocalDate.now()));
        products.add( new Product(4,"Anchor",2500,12, LocalDate.now()));
        products.add( new Product(5,"Milk",3000,8, LocalDate.now()));
        products.add( new Product(6,"Apple",1000,10, LocalDate.now()));
        products.add( new Product(7,"Book",500,50, LocalDate.now()));

       a: while (true){ Display object = new Display();
            object.displayedCaption();
            object.displayMenu("*/Display","    W/rite","   R/ead","    D/elete","   F/irst","   P/revious","   N/ext",
                    "   L/ast","    S/earch","  G/oto","    E/set row","    H/elp","    X/Exit");

            char ch = object.displaySelection();
            switch (ch){
                case '*': object.displayRecord(products); break;
                case 'W'|'w': writeData(products); break;
                case 'R'|'r': readData(products); break;
                case 'D'|'d': deleteElement(products); break;
                case 'F'|'f': dataFirstElement(products); break;
                case 'P'|'p': break;
                case 'N'|'n': break;
                case 'L'|'l': dataLastElement(products); break;
                case 'S'|'s': searchElement(products); break;
                case 'G'|'g': break;
                case 'E'|'e': break;
                case 'H'|'h': break;
                case 'X'|'x': break a;

            }
        }


    }






    //write data block
    public static void writeData(ArrayList<Product> arrayList){
        System.out.print("ID: "); int id = new Scanner(System.in).nextInt();
        System.out.print("Named Product: "); String name = new Scanner(System.in).nextLine();
        System.out.print("Price: "); double price = new Scanner(System.in).nextInt();
        System.out.print("Quantity: "); int qty = new Scanner(System.in).nextInt();
         LocalDate date = LocalDate.now();
        System.out.println("");
        arrayList.add(new Product(id,name,price,qty,date));
    }
    // write date end block
    //Read data block
    public static void readData(ArrayList<Product> arrayList){
        System.out.print("Read by ID: "); int id = new Scanner(System.in).nextInt();
        Display display = new Display();
        int index =0;
        for (int i =0 ; i< arrayList.size();i++){
            if(arrayList.get(i).getID()==id) index=i;
        }
        display.displayAnElement(arrayList,index);
    }
    //Read data end block
    //updateDate Block
    public static void updateData(ArrayList<Product> arrayList){
        Display obj = new Display();
        obj.displayMenu("1/Update ID","    2/Update Name","    3/Update Price","    4/Update Qty");
        char ch = obj.displaySelection();
        switch(ch){
            case '1':  idUpdating(arrayList);      break;
            case '2':  nameUpdating(arrayList);     break;
            case '3':  priceUpdating(arrayList);     break;
            case '4':  qtyUpdating(arrayList);     break;
            default:        break;
        }
    }
    public static void idUpdating(ArrayList<Product> arrayList){
        new Display().displayRecord(arrayList);
        System.out.print("Select Product's ID to update the element: ");
        int id = scanner.nextInt();
        int index =0;
        for (int i =0 ; i< arrayList.size();i++){
            if(arrayList.get(i).getID()==id) index=i;
        }
        System.out.println("Enter new ID: ");
        int newId = scanner.nextInt();
        arrayList.set(index,new Product(newId,
                arrayList.get(index).getProductName(),
                arrayList.get(index).getProductPrice(),
                arrayList.get(index).getQuantity(),
                arrayList.get(index).getDate()));
        System.out.println("===========After Update==========");
        new Display().displayRecord(arrayList);
    }
    public static void nameUpdating(ArrayList<Product> arrayList){
        new Display().displayRecord(arrayList);
        System.out.print("Select Product's ID to update the element: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        int index =0;
        for (int i =0 ; i< arrayList.size();i++){
            if(arrayList.get(i).getID()==id) index=i;
        }
        System.out.println("Enter new Pro's Name: ");
        String newName = scanner.nextLine();
        Product p =  arrayList.get(index);
        p.setProductName(newName);
        System.out.println("===========After Update==========");
        new Display().displayRecord(arrayList);
    }
    public static void priceUpdating(ArrayList<Product> arrayList){
        new Display().displayRecord(arrayList);
        System.out.print("Select Product's ID to update the element: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        int index =0;
        for (int i =0 ; i< arrayList.size();i++){
            if(arrayList.get(i).getID()==id) index=i;
        }
        System.out.println("Enter new Price: ");
        double newPrice = scanner.nextDouble();
        Product p =  arrayList.get(index);
        p.setProductPrice(newPrice);
        System.out.println("===========After Update==========");
        new Display().displayRecord(arrayList);
    }
    public static void qtyUpdating(ArrayList<Product> arrayList){
        new Display().displayRecord(arrayList);
        System.out.print("Select Product's ID to update the element: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        int index =0;
        for (int i =0 ; i< arrayList.size();i++){
            if(arrayList.get(i).getID()==id) index=i;
        }
        System.out.println("Enter new Quantity: ");
        int newQty = scanner.nextInt();
        Product p =  arrayList.get(index);
        p.setQuantity(newQty);
        System.out.println("===========After Update==========");
        new Display().displayRecord(arrayList);
    }
    // Update Block end
    //firstElement
    public static void dataFirstElement(ArrayList<Product> arrayList){
       new Display().displayAnElement(arrayList,0);
    }
    public static void dataLastElement(ArrayList<Product> arrayList){
        new Display().displayAnElement(arrayList, arrayList.size()-1);
    }

    //delete Element
    public static void deleteElement(ArrayList<Product> arrayList){
        new Display().displayRecord(arrayList);
        System.out.print("Select Product's ID to Delete the element: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        int index =0;
        for (int i =0 ; i< arrayList.size();i++){
            if(arrayList.get(i).getID()==id) index=i;
        }
        arrayList.remove(index);
        System.out.println("========After Remove=======");
    }

    public static void searchElement(ArrayList<Product> arrayList){
        Display obj = new Display();
        obj.displayMenu("1/Search by ID","    2/Search by Name","    3/Search by Price","    4/Search by Qty");
        char ch = obj.displaySelection();
        switch (ch){
            case '1':  searchElementByID(arrayList); break;
            case '2':searchElementByName(arrayList); break;
            case '3':searchElementByPrice(arrayList); break;
            case '4':searchElementByQty(arrayList); break;
        }
    }
    public static void searchElementByID(ArrayList<Product> arrayList){
        System.out.print("Enter ID: "); int id = new Scanner(System.in).nextInt();
        Display display = new Display();
        int index =0;
        for (int i =0 ; i< arrayList.size();i++){
            if(arrayList.get(i).getID()==id) index=i;
        }
        display.displayAnElement(arrayList,index);
    }
    public static void searchElementByName(ArrayList<Product> arrayList){
        b:while (true){ System.out.print("Enter Name: "); String name = new Scanner(System.in).nextLine();
            Display display = new Display();
            boolean ch = true;
            int index =0;
            for (int i =0 ; i< arrayList.size();i++){
                if(arrayList.get(i).getProductName().equals(name)) {
                    display.displayAnElement(arrayList,i);
                    ch = false; break b;
                }
            }
            if(ch){
                display.displayMenu("=====NOT FOUND=======");
            }
        }

    }

    public static void searchElementByPrice(ArrayList<Product> arrayList){
        System.out.print("Enter Price: "); double price = new Scanner(System.in).nextDouble();
        Display display = new Display();
        boolean ch = true;
        int index =0;
        for (int i =0 ; i< arrayList.size();i++){
            if(arrayList.get(i).getProductPrice()==price) {
                display.displayAnElement(arrayList,i);
                ch = false;
            }
        }
        if(ch){
            display.displayMenu("=====NOT FOUND=======");
        }
    }

    public static void searchElementByQty(ArrayList<Product> arrayList){
        System.out.print("Enter Qty: "); int qty = new Scanner(System.in).nextInt();
        Display display = new Display();
        boolean ch = true;
        int index =0;
        for (int i =0 ; i< arrayList.size();i++){
            if(arrayList.get(i).getQuantity()==qty) {
                display.displayAnElement(arrayList,i);
                ch=false;
            }
        }
        if(ch){
            display.displayMenu("=====NOT FOUND=======");
        }
    }


}