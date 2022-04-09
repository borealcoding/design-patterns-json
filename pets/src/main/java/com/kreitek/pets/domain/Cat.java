package com.kreitek.pets.domain;

public class Cat {

    private final String name;
    private final String ownerName;
    private final String telephone;

    public Cat(String petName, String ownerName, String telephone) {
        this.name = petName;
        this.ownerName = ownerName;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getTelephone() {
        return telephone;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
