/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Management;

import Object.Publisher;
import Oject.Book;
import static java.nio.file.Files.list;
import static java.util.Collections.list;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class Validation {

    private static Scanner sc = new Scanner(System.in);

    public static int getInt(String msg, int min, int max) {
        int c;
        while (true) {
            try {
                System.out.print(msg);
                c = Integer.parseInt(sc.nextLine());
                if (min <= c && c <= max) {
                    break;
                }
                throw new NumberFormatException();

            } catch (NumberFormatException ex) {
                System.err.println("Please enter an integer number in range: " + min + "-->" + max);
            }
        }
        return c;
    }

    public static String getCode(String msg0, String msg, String err, String err1, String err2, String err0, int mode, List<Publisher> pList, List<Book> bList) {

        Pattern p = Pattern.compile("^P[0-9]{5}$");

        String s;
        //MODE:
        //1: Input -  id not exist
        //2: delte - id exist
        //3: input - book
        //4: search - book
        //5: update- book

        System.out.println(msg0);
        while (true) {

            System.out.print(msg);
            s = sc.nextLine();
            if (!s.isEmpty()) {
                if ((mode == 1 && p.matcher(s).find() && getPublisher(s, pList) == null)) {

                    break;
                } else if (mode == 1 && p.matcher(s).find() && getPublisher(s, pList) != null) {
                    System.err.println(err);
                } else if (mode == 2 && p.matcher(s).find() && getPublisher(s, pList) != null) {
                    break;

                } else if (mode == 2 && p.matcher(s).find() && getPublisher(s, pList) == null) {

                } else if (mode == 3 && p.matcher(s).find() && getPublisher(s, pList) != null && getBublsiherId(s, bList) != null) {
                    break;

                } else if (mode == 3 && p.matcher(s).find() && getPublisher(s, pList) != null && getBublsiherId(s, bList) == null) {
                    break;
                } else if (mode == 4 && p.matcher(s).find() && getPublisher(s, pList) != null && getBublsiherId(s, bList) != null) {

                    break;
                } else if (mode == 4 && p.matcher(s).find() && getPublisher(s, pList) != null && getBublsiherId(s, bList) == null) {
                    System.err.println(err0);
                  
                }
               
                else if (mode == 3 && p.matcher(s).find() && getPublisher(s, pList) == null) {
                    System.err.println(err0);
                } else if (mode == 5 && p.matcher(s).find() && getPublisher(s, pList) == null) {
                    System.err.println(err0);
                } else if (mode == 5 && p.matcher(s).find() && getPublisher(s, pList) != null) {
                    break;
                } else {
                    System.err.println(err1);
                }
            } else {
                if (mode == 5) {
                    break;
                
                }else if(mode ==4 && s.equals("")){
                    break;
                } 
                System.err.println(err2);
            }
        }

        return s;
    }

    private static Publisher getPublisher(String id, List<Publisher> pList) {
        for (Publisher p : pList) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public static String getName(String msg0, String msg, String err, List<Publisher> pList) {
        String k;
        System.out.println(msg0);
        Pattern p = Pattern.compile("^([a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*){5,30}$");

        while (true) {
            System.out.print(msg);
            k = sc.nextLine();
            if (p.matcher(k).find()) {
                break;
            }
            System.err.println(err);
        }

        return k;

    }

    public static String getPhoneNumberField(String msg0, String msg, String err, String err1, String err2, List<Publisher> pList) {
        String q;
        Pattern p = Pattern.compile("^[0-9]{10,12}$");

        while (true) {
            System.out.print(msg);
            q = sc.nextLine();

            if (!q.isEmpty()) {

                if (p.matcher(q).find() && gtPublisher(q, pList) == null) {
                    break;
                } else if (p.matcher(q).find() && gtPublisher(q, pList) != null) {
                    System.err.println(err);
                } else {
                    System.err.println(err1);
                }
            } else {
                System.err.println(err2);
            }
        }
        return q;

    }

    private static Publisher gtPublisher(String PhoneNumberField, List<Publisher> pList) {
        for (Publisher p : pList) {
            if (p.getPhoneNumberField().equals(PhoneNumberField)) {
                return p;
            }
        }
        return null;
    }

    public static double getDouble(String msg) {
        double c;
        while (true) {
            try {
                System.out.print(msg);
                c = Double.parseDouble(sc.nextLine());
                if (c > 0) {
                    break;
                }
                throw new NumberFormatException();

            } catch (NumberFormatException ex) {
                System.err.println("Please enter an real number and greater than 0");
            }
        }
        return c;
    }

    public static String getBcode(String msg0, String msg, String err, String err1, String err2, String err0, int mode, List<Book> bList) {

        Pattern p = Pattern.compile("^B[0-9]{5}$");

        String s;
        //MODE:
        //1: Input -  id not exist
        //2: delete - id exist
        //3: update
        while (true) {
        System.out.println(msg0);

            System.out.print(msg);
            s = sc.nextLine();
            if (!s.isEmpty()) {
                if ((mode == 1 && p.matcher(s).find() && getBook(s, bList) == null)) {

                    break;
                } else if (mode == 1 && p.matcher(s).find() && getBook(s, bList) != null) {
                    System.err.println(err);
                } else if (mode == 2 && p.matcher(s).find() && getBook(s, bList) != null) {
                    break;

                } else if (mode == 2 && p.matcher(s).find() && getBook(s, bList) == null) {
                    System.err.println(err0);

                } else if (mode == 3 && p.matcher(s).find() && getBook(s, bList) != null) {
                    break;
                } else if (mode == 3 && p.matcher(s).find() && getBook(s, bList) == null) {

                    System.err.println("the id do not exists");
                } else {
                    System.err.println(err1);
                }
            } else {
                System.err.println(err2);
            }
        }

        return s;
    }

    private static Book getBook(String Bid, List<Book> bList) {
        for (Book b : bList) {
            if (b.getBid().equals(Bid)) {
                return b;
            }
        }
        return null;
    }

    private static Book getBublsiherId(String PublisherId, List<Book> bList) {
        for (Book b : bList) {
            if (b.getPublisherId().equals(PublisherId)) {
                return b;
            }
        }
        return null;
    }

    public static String getStatus(String msg, String err, int mode, List<Book> bList) {
//1-input
//2-update
        Pattern p = Pattern.compile("^[Nn]{1}$");
        Pattern a = Pattern.compile("^[Aa]{1}$");
        String k;
        while (true) {
            System.out.print(msg);

            k = sc.nextLine();
            if (!k.isEmpty()) {

                if (p.matcher(k).find() && mode == 1) {
                    k = "Not Avaiable";
                    break;
                }
                if (a.matcher(k).find() && mode == 1) {
                    k = "Avaiable";
                    break;
                }
                if (p.matcher(k).find() && mode == 2) {
                    k = "Not Avaiable";
                    break;
                }
                if (a.matcher(k).find() && mode == 2) {
                    k = "Avaiable";
                    break;
                } else {
                    System.err.println(err);
                }
            } else {
                if (mode == 2) {
                    break;
                } else {
                    System.err.println("cant be empty");
                }
            }
        }
        return k;
    }

    public static double getPrice(String msg, String err, int mode, List<Book> bList) {
        double i = 0;

        while (true) {
            System.out.print(msg);
            try {
                i = Double.parseDouble(sc.nextLine());
            } catch (Exception e) {
                System.err.println("The input can not be empty and must be real number");
            }

            if (i > 0 && mode == 1) {
                break;
            }
            if (i == 0 && mode == 2) {
                break;
            }
            if (i > 0 && mode == 2) {
                break;
            } else {
                System.out.println(err);
            }

        }
        return i;

    }

    public static int getQuanity(String msg, String err, int mode, List<Book> bList) {
        int o = 0;

        while (true) {
            System.out.print(msg);
            try {
                o = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.err.println("The input can not be empty and must be integer number");
            }

            if (o > 0 && mode == 1) {
                break;
            }
            if (o == 0 && mode == 2) {
                break;
            }
            if (o > 0 && mode == 2) {
                break;
            } else {
                System.err.println(err);
            }
        }
        return o;

    }

    public static String getBName(String msg0, String msg, String err, int mode, List<Book> bList) {
        String k = "lala";
        System.out.println(msg0);
        Pattern p = Pattern.compile("^([a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*){5,30}$");
//1-input
//2-update

        while (true) {
            System.out.print(msg);
            k = sc.nextLine();
            if (!k.isEmpty()) {
                if (p.matcher(k).find() && mode == 1) {
                    break;
                }if (p.matcher(k).find() && mode == 2) {
                    break;
                }
                else{
                    System.err.println(err);
                }
            } else {
                
                if(k.equals("")&&mode==2){
                 break;
                }
                if (!p.matcher(k).find() && mode == 2) {
                    break;
                }
                else {
                    System.err.println("The name can not be empty, please try again");
                }

            }
        }
        return k;
    }

    public static String pName(String id, List<Publisher> pList, List<Book> bList) {
        String name;
        for (Publisher p : pList) {
            if (p.getId().equals(id)) {
                name = p.getName();
                return name;
            }
        }
        return null;
    }
  
    

}
