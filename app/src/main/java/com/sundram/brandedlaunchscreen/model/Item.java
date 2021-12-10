package com.sundram.brandedlaunchscreen.model;

public class Item {

    private  String name;
    private int image;
    private String Ingridents;
    private  int person;
    private String prepation;

    public Item(String name, int image,String Ingridents,int person,String prepation) {
          this.name=name;
          this.image=image;
          this.Ingridents=Ingridents;
          this.person=person;
          this.prepation=prepation;

    }

    public Item(int position) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getPerson() {
        return person;
    }

    public void setPerson(int person) {
        this.person = person;
    }

    public String getIngridents() {
        return Ingridents;
    }

    public void setIngridents(String ingridents) {
        Ingridents = ingridents;
    }

    public String getPrepation() {
        return prepation;
    }

    public void setPrepation(String prepation) {
        this.prepation = prepation;
    }
}
