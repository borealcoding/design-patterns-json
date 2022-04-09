package com.kreitek.pets.domain;

public class Dog {
    private final String petName;
    private final String ownerName;
    private final String telephone;

    public Dog(String petName, String ownerName, String telephone) {
        this.petName = petName;
        this.ownerName = ownerName;
        this.telephone = telephone;
    }

    public String getPetName() {
        return petName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getTelephone() {
        return telephone;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "petName='" + petName + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
