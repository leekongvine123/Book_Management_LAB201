/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

/**
 *
 * @author Admin
 */
public class Publisher {
    private String id;
    private String name;
    private String PhoneNumberField;

    public Publisher(String id, String name, String PhoneNumberField) {
        this.id = id;
        this.name = name;
        this.PhoneNumberField = PhoneNumberField;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumberField() {
        return PhoneNumberField;
    }

    public void setPhoneNumberField(String PhoneNumberField) {
        this.PhoneNumberField = PhoneNumberField;
    }
    
    @Override
    public String toString(){
        return String.format("%-8s|%-20s|%-14s\n", id, name, PhoneNumberField);
    }
    
}
