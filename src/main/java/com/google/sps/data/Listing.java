package com.google.sps.data;

public final class Listing {

  private final String name;
  private final String location;
  private final String item;
  private final String number;

  public Listing(String name, String location, String item, String number) {
    this.name = name;
    this.location = location;
    this.item = item;
    this.number = number;
  }

}