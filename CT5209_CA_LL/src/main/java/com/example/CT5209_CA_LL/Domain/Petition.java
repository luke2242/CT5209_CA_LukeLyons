package com.example.CT5209_CA_LL.Domain;

import java.util.List;

public class Petition {

    private int id;
    private String title;
    private String description;
    private List<Signature> signatures;


    public Petition(int id, String title, String description, List<Signature> signatures){
        this.id = id;
        this.title = title;
        this.description = description;
        this.signatures = signatures;
    }

    public int getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }

    public List<Signature> getSignatures(){
        return signatures;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public  void setSignatures(List<Signature> signatures){
        this.signatures = signatures;
    }

}
