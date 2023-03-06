/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Management;

import Object.Publisher;
import Oject.Book;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Management {

    private Scanner sc = new Scanner(System.in);
    private List<Publisher> pList;
    private List<Book> bList;

    public Management() {
        pList = new ArrayList<>();
        bList = new ArrayList<>();
    }

    public void addPublisher() throws IOException {
        this.displayPublisher();
        String id, name, PhoneNumberField;
        id = Validation.getCode("The ID must follow the format:Pxxxxx( x is a number(0-9))", "Enter ID:", "ID EXIST", "Error Format", "ID can not be empty", "", 1, pList, bList);
        name = Validation.getName("Input must be character", "Enter Name:", "The name must have 5-30 length and must be character", pList);
        PhoneNumberField = Validation.getPhoneNumberField("PhoneNumberField must have 10 to 12 lenght", "Enter PhoneNumberField: ", "PhoneNumber exist", "Please follow the format", "PhoneNumber can not be empty", pList);

        pList.add(new Publisher(id, name.toUpperCase(), PhoneNumberField));
        this.PSaveToFile();
        pList.removeAll(pList);
    }

    public void PSaveToFile() {

        try {
            File f = new File("Publisher.txt");
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Publisher o : pList) {
                bw.write(o.toString());

            }

            bw.close();

            fw.close();
            System.out.println("Saved scuccelfaf");

        } catch (Exception ex) {
            System.out.println("Saved fails");

        }

    }

    public void BSaveToFile() {
        try {
            File f = new File("Book.txt");
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Book o : bList) {
                bw.write(o.toString());

            }
            System.out.println("Have been saved to file");

            bw.close();

            fw.close();

        } catch (Exception ex) {
            System.out.println("Fails");

        }

    }

    public void PLoadFromFile() throws FileNotFoundException, IOException {
        File f = new File("Publisher.txt");

        FileReader fr = new FileReader(f);

        BufferedReader br = new BufferedReader(fr);

        while (true) {
            String line = br.readLine();
            if (line == null) {
                break;
            }
            String[] info = line.split("[|]");
            String id = info[0].trim();
            String name = info[1].trim();
            String PhoneNumberField = info[2].trim();
            pList.add(new Publisher(id, name, PhoneNumberField));

        }

        br.close();

        fr.close();

    }

    public void BLoadFromFile() throws FileNotFoundException, IOException {
        File f = new File("Book.txt");

        FileReader fr = new FileReader(f);

        BufferedReader br = new BufferedReader(fr);

        while (true) {
            String line = br.readLine();
            if (line == null) {
                break;
            }
            String[] inf = line.split("[|]");
            String Bid = inf[0].trim();
            String Bname = inf[1].trim();
            double Bprice = Double.parseDouble(inf[2].trim());
            int quanity = Integer.parseInt(inf[3].trim());
            String PublisherId = inf[4].trim();
            String status = inf[5].trim();

            bList.add(new Book(Bid, Bname, Bprice, quanity, PublisherId, status));

        }

        br.close();
        fr.close();

    }

    public void deletePublisher() {
        displayPublisher();
        String DeId;
        if (pList.isEmpty()) {
            System.out.println("There is no Publisher in the list");
        } else {
            DeId = Validation.getCode("The ID must follow the format:Pxxxxx( x is a number(0-9))", "Enter ID:", "ID EXIST", "Error Format", "ID can not be empty", "The id do not exist\n Deleting failed!", 2, pList, bList);

            for (Publisher o : pList) {
                if (o.getId().equals(DeId)) {

                    pList.remove(o);
                    System.out.println("Delete sucessfully!");
                    break;
                }
            }
        }
        this.PSaveToFile();
        pList.removeAll(pList);
    }

    public void Psort() {
        Collections.sort(pList, new Comparator<Publisher>() {
            @Override
            public int compare(Publisher o1, Publisher o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    public void displayPublisher() {

        System.out.println(pList);
    }

    public void addBook() {
        this.displayBook();
        String Bid;
        String Bname;
        double Bprice;
        String status;
        int quanity;
        String PublisherId;
        String PublisherName;
        double subTotal;
        Bid = Validation.getBcode("The ID must follow the format:Bxxxxx( x is a number(0-9))", "Enter ID:", "ID EXIST", "Error Format", "ID can not be empty", "", 1, bList);
        Bname = Validation.getBName("Input must be character", "Enter Name:", "The name must have 5-30 length and must be character", 1, bList);
        Bprice = Validation.getPrice("Please input the price: ", "try again", 1, bList);
        quanity = Validation.getQuanity("Quanity: ", "Try again", 1, bList);
        subTotal = sub(Bprice, quanity);
        status = Validation.getStatus("Please input status: ", "Try again", 1, bList);
        PublisherId = Validation.getCode("The ID must follow the format:Pxxxxx( x is a number(0-9))", "Enter ID:", "ID EXIST", "Error Format", "ID can not be empty", "", 3, pList, bList);

        bList.add(new Book(Bid, Bname, Bprice, quanity, PublisherId, status));
        System.out.println("Adding successfully");
        this.BSaveToFile();
        bList.removeAll(bList);
    }

    public void searchBook() {

        String bookSearchByName;
        String bookSearchByPId;
        int count = 0;
        int countt = 0;

        for (Book b : bList) {
            System.out.println(b);
        }

        do {
            System.out.print("Enter the name of book you want to search: ");
            bookSearchByName = sc.nextLine();

            bookSearchByPId = Validation.getCode("The ID must follow the format:Pxxxxx( x is a number(0-9))", "Enter ID:", "ID EXIST", "Error Format", "ID can not be empty", "The id do not exist\n Deleting failed!", 4, pList, bList);

            for (Book b : bList) {

                if (b.getBname().contains(bookSearchByName) && bookSearchByPId.equals(b.getPublisherId())) {
                    System.out.println(b);

                } else if (b.getBname().contains(bookSearchByName) && bookSearchByPId.equals("")) {
                    System.out.println(b);

                } else if (bookSearchByName.equals("") && bookSearchByPId.equals("")) {
                    System.out.println(b);

                } else if (bookSearchByName.equals("") && bookSearchByPId.equals(b.getPublisherId())) {
                    System.out.println(b);

                } else if (b.getBname().contains(bookSearchByName) && !bookSearchByPId.equals(b.getPublisherId())) {
                    countt++;
                }

                count++;

            }

            if (count == 0 || countt != 0) {
                System.err.println("\n\nHave no any book!!!");
                System.err.println("\n\nPlease enter again");
            } else {
                break;
            }

        } while (true);

    }

    public void deleteBook() {
        this.displayBook();
        String DeId;
        DeId = Validation.getBcode("The ID must follow the format:Bxxxxx( x is a number(0-9))", "Enter ID:", "ID EXIST", "Error Format", "ID can not be empty", "", 2, bList);
        for (Book o : bList) {
            if (o.getBid().equals(DeId)) {

                bList.remove(o);
                System.out.println("Delete sucessfully!");
                break;
            }
        }
        this.BSaveToFile();
        bList.removeAll(bList);
    }

    public void updateBook() {
        this.displayBook();
        String Bname;
        String Bprice;
        String status;
        String quanity;
        String PublisherId;
        String DeId;
        String n;
        double p;
        int q;
        String t;
        String s;
        String pn;
        String pn2;

        System.out.println("Enter BOOK ID:");
        DeId = Validation.getBcode("The ID must follow the format:Bxxxxx( x is a number(0-9))", "Enter ID:", "ID EXIST", "Error Format", "ID can not be empty", "", 3, bList);
        for (Book o : bList) {
            if (o.getBid().equals(DeId)) {
                n = o.getBname();
                p = o.getBprice();
                q = o.getQuanity();
                t = o.getPublisherId();
                s = o.getStatus();

                Bname = Validation.getBName("Input must be character", "Enter Name:", "The name must have 5-30 length", 2, bList);

                status = Validation.getStatus("Please input status: ", "Try again", 2, bList);
                PublisherId = Validation.getCode("The ID must follow the format:Pxxxxx( x is a number(0-9))", "Enter ID:", "ID EXIST", "Error Format", "ID can not be empty", "", 5, pList, bList);
             
                if (Bname.equals("")) {
                    o.setBname(n);
                }
                if (!Bname.equals("")) {
                    o.setBname(Bname);
                }
                do {
                    System.out.print("Update book price: ");
                    Bprice = sc.nextLine();
                    if (Bprice.equals("")) {
                        o.getBprice();
                        break;
                    } else if (Bprice.matches(("^([0-9]){1,15}$")) || Bprice.matches(("^([0.00-9.99]){1,15}$"))) {
                        o.setBprice(Double.parseDouble(Bprice));
                        break;
                    } else {
                        System.err.println("Invalid");
                    }
                } while (true);

                do {
                    System.out.print("Update book quantity: ");
                    quanity = sc.nextLine();
                    if (quanity.equals("")) {
                        o.setQuanity(q);
                        break;
                    } else if (quanity.matches("^([0-9]){1,15}$")) {
                        o.setQuanity(Integer.parseInt(quanity));
                        break;
                    } else {
                        System.err.println("Invalid quantity");
                    }
                } while (true);

                if (status.equals("")) {
                    o.setStatus(o.getStatus());
                }
                if (!status.equals("")) {
                    o.setStatus(status);
                }
                if (PublisherId.equals("")) {
                    o.setPublisherId(o.getPublisherId());

                }
                if (!PublisherId.equals("")) {
                    o.setPublisherId(PublisherId);

                }

                System.out.println(o);
               break; 
            }

        }
        BSaveToFile();
        bList.removeAll(bList);
    }

    public double sub(double a, int b) {

        double st = a * b;

        return st;

    }

    public void displayBook() {

        System.out.println("");
        for (int i = 0; i < bList.size() - 1; i++) {
            for (int j = i + 1; j < bList.size(); j++) {
                if (bList.get(i).getQuanity() < bList.get(j).getQuanity()) {

                    Collections.swap(bList, i, j);

                } else if (bList.get(i).getQuanity() == bList.get(j).getQuanity()) {
                    if (bList.get(i).getBprice() > bList.get(j).getBprice()) {
                        Collections.swap(bList, i, j);
                    }
                }
            }
        }

        System.out.println("BookID        Name                       Prices     Quantity   Subtotal     Publisher's Name    Status   ");
        for (Book x : bList) {
            System.out.printf("%-6s | %-30s | %-7.1f | %8d | %-10.1f | %-15s | %-15s\n", x.getBid(), x.getBname(), x.getBprice(), x.getQuanity(), (x.getBprice() * x.getQuanity()), Validation.pName(x.getPublisherId(), pList, bList), x.getStatus());

        }
    }
  


}
