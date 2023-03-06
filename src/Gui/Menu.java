/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Management.Management;
import Management.Validation;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Menu {

    private static String[] ops = {
        "Add publisher",
        "Delet publisher",
        "Display Publisher",
        "Add book",
        "Search Book",
        "Delete Book",
        "Update Book",
        "Display book",
        "Exit"
    };

    private static int getChoice() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < ops.length; i++) {
            System.out.println((i + 1) + "." + ops[i]);

        }
        return Validation.getInt("Enter your choice: ", 1, ops.length);

    }

    public static void display() throws IOException {
        Management m = new Management();

        int choice;
        m.PLoadFromFile();
        m.BLoadFromFile();

        do {
            System.out.println("  ====Publisher Management====  ");
            choice = getChoice();

            switch (choice) {
                case 1:
                    Scanner sc = new Scanner(System.in);
                    String c;
                    boolean r = true;
                    boolean l = true;
                    do {
                        m.addPublisher();

                        m.Psort();
                        m.PLoadFromFile();

                        do {
                            System.out.println("Do you want to back to menu(Y/N): ");

                            c = sc.nextLine();
                            if (c.equals("y") || (c.equals("Y"))) {
                                r = false;
                                l = false;
                            } else if (c.equals("n") || (c.equals("N"))) {
                                r = true;
                                l = false;
                            } else {
                                System.out.println("Please choose Y/N!");
                                l = true;

                            }
                        } while (l);
                    } while (r);
                    break;
                case 2:

                    Scanner op = new Scanner(System.in);
                    String q;
                    boolean p = true;
                    boolean n = true;
                    do {
                        m.deletePublisher();
                        m.PLoadFromFile();

                        System.out.println("ADDING SUCCESSFULLY");
                        do {
                            System.out.println("Do you want to back to menu: ");

                            c = op.nextLine();
                            if (c.equals("y") || (c.equals("Y"))) {
                                p = false;
                                n = false;
                            } else if (c.equals("n") || (c.equals("N"))) {
                                p = true;
                                n = false;
                            } else {
                                System.out.println("Please choose Y/N!");
                                n = true;

                            }
                        } while (n);
                    } while (p);
                    break;

                case 3:
                    m.displayPublisher();
                    break;
                case 4:

                    Scanner kl = new Scanner(System.in);
                    String o;
                    boolean u = true;
                    boolean i = true;
                    do {

                        do {
                            m.addBook();
                            m.BLoadFromFile();
                            System.out.println("Do you want to back to menu(Y/N): ");

                            o = kl.nextLine();
                            if (o.equals("Y") || (o.equals("y"))) {
                                u = false;
                                i = false;
                            } else if (o.equals("n") || (o.equals("N"))) {
                                u = true;
                                i = false;
                            } else {
                                System.out.println("Please choose Y/N!");
                                i = true;

                            }
                        } while (i);
                    } while (u);

                    break;
                case 5:
                    Scanner sf = new Scanner(System.in);
                    String h;
                    boolean d = true;
                    boolean f = true;
                    do {

                        do {
                            m.searchBook();

                            System.out.println("Do you want to back to menu(Y/N): ");

                            h = sf.nextLine();
                            if (h.equals("Y") || (h.equals("y"))) {
                                d = false;
                                f = false;
                            } else if (h.equals("n") || (h.equals("N"))) {
                                d = true;
                                f = false;
                            } else {
                                System.out.println("Please choose Y/N!");
                                f = true;

                            }
                        } while (f);
                    } while (d);
                    break;
                case 6:

                    Scanner rt = new Scanner(System.in);
                    String e;
                    boolean a = true;
                    boolean v = true;
                    do {

                        do {
                            m.deleteBook();
                            m.BLoadFromFile();
                            System.out.println("Deleteing successfull");

                            System.out.println("Do you want to back to menu(Y/N): ");

                            e = rt.nextLine();
                            if (e.equals("Y") || (e.equals("y"))) {
                                a = false;
                                v = false;
                            } else if (e.equals("N") || (e.equals("n"))) {
                                a = true;
                                v = false;
                            } else {
                                System.out.println("Please choose Y/N!");
                                v = true;

                            }
                        } while (v);
                    } while (a);
                    break;

                case 7:
                   
                    Scanner bm = new Scanner(System.in);
                    String g;
                    boolean w = true;
                    boolean z = true;
                    do {

                        do {
                            m.updateBook();
                            m.BLoadFromFile();
                            System.out.println("Do you want to back to menu(Y/N): ");
                            g = bm.nextLine();
                            if (g.equals("y") || (g.equals("Y"))) {
                                w = false;
                                z = false;
                            } else if (g.equals("n") || (g.equals("N"))) {
                                w = true;
                                z = false;
                            } else {
                                System.out.println("Please choose Y/N!");
                                z = true;
                            }
                        } while (z);
                    } while (w);

                    break;
                case 8:
                    m.displayBook();
            }

        } while (choice != 9);
    }
}
