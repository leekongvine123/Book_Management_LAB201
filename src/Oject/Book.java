/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oject;

/**
 *
 * @author Admin
 */
public class Book {

    String Bid;
    String Bname;
    double Bprice;
    String status;
    int quanity;
    String PublisherId;
    
   

    
    public Book(String Bid, String Bname, double Bprice, int quanity, String PublisherId , String status) {
        this.Bid = Bid;
        this.Bname = Bname;
        this.Bprice = Bprice;
        this.quanity = quanity;
        this.PublisherId = PublisherId;
        this.status = status;

    }

    public String getPublisherId() {
        return PublisherId;
    }

    public void setPublisherId(String PublisherId) {
        this.PublisherId = PublisherId;
    }

    public String getBid() {
        return Bid;
    }

    public void setBid(String Bid) {
        this.Bid = Bid;
    }

    public String getBname() {
        return Bname;
    }

    public void setBname(String Bname) {
        this.Bname = Bname;
    }

    public double getBprice() {
        return Bprice;
    }

    public void setBprice(double Bprice) {
        this.Bprice = Bprice;
    }

    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

   

    @Override
    public String toString() {
        return String.format("%s|%s|%f|%d|%s|%s\n",Bid, Bname, Bprice, quanity, PublisherId, status);
    }
 
}
