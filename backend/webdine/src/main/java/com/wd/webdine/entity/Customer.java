package com.wd.webdine.entity;

public class Customer extends User {

  public Customer() {
    this.setType("customer");
  }

  public Customer(String userName, String phoneNumber, String address,
      String city, String state, String zip) {
    super(userName, phoneNumber, address, city, state, zip);
    this.setType("customer");
  }
}
