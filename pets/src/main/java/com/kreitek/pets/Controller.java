package com.kreitek.pets;

public interface Controller {
    String executePut(String petName, String ownerName, String telephone);
    String executeGet();
}
