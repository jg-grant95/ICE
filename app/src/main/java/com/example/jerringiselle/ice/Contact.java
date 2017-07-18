package com.example.jerringiselle.ice;

/**
 * Created by Jerrin Giselle on 7/18/2017.
 */

public class Contact {
    private String first_name;
    private String last_name;
    private String phone_number;
    private Relationship relationship;


    public String to_phone(String number) {
        String phone_num = "";
        if (number.length() == 10) {
            phone_num = String.format("(%s)%s-%s",
                    number.substring(0, 3),
                    number.substring(3, 6),
                    number.substring(6, 10));
        }
        return phone_num;
    }

    public Contact(){
        String first_name = "";
        String last_name = "";
        relationship =  Relationship.Other;
    }

    // getters and setters

    public void setFirstName(String first){
        this.first_name = first;
    }
    public String getFirstName(){
        return first_name;
    }

    public void setLastName(String last){
        this.last_name = last;
    }
    public String getLastName(){
        return last_name;
    }

    public void setPhoneNumber(String number){
        phone_number = to_phone(number);
    }
    public String getPhoneNumber(){
        return phone_number;
    }

    public void setRelationship( Relationship rel){
        this.relationship = rel;
    }
    public Relationship getRelationship(){
        return relationship;
    }



    public Contact(String first, String last, String num, Relationship rel){
        this.setFirstName(first);
        this.setLastName(last);
        this.setPhoneNumber(num);
        this.setRelationship(rel);
    }
}
