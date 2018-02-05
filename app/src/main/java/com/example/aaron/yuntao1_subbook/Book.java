package com.example.aaron.yuntao1_subbook;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Aaron on 2/5/2018.
 */

public class Book implements Serializable {

    private String name;
    private Date Datee;
    private String Comments;


    public Book(String name, Date Datee) {
        this.name = name;
        this.Datee = Datee;

    }

    public Book(String name) {
        this(name, new Date());
    }


    public String getComments() {
        return this.Comments;
    }

    public String getName() {
        return this.name;
    }

    public Date getDate() {
        return this.Datee;
    }

    public String getDateString() {
        return (new SimpleDateFormat("MM/dd/yyyy").format(this.getDate()));
    }


    public void setComments(String comments) {
        this.Comments = comments;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Date date) {
        this.Datee = date;
    }
}




