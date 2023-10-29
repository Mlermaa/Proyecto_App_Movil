package com.example.apptechdesk2023.Activity.Domain;

public class ProductosDomain {
    private  String title;
    private  String pic;
    private String descrption;
    private Double fee;
    private  int numberIncart;

    public ProductosDomain(String title, String pic, String descrption, Double fee) {
        this.title = title;
        this.pic = pic;
        this.descrption = descrption;
        this.fee = fee;
    }

    public ProductosDomain(String title, String pic, String descrption, Double fee, int numberIncart) {
        this.title = title;
        this.pic = pic;
        this.descrption = descrption;
        this.fee = fee;
        this.numberIncart = numberIncart;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public int getNumberIncart() {
        return numberIncart;
    }

    public void setNumberIncart(int numberIncart) {
        this.numberIncart = numberIncart;
    }
}
