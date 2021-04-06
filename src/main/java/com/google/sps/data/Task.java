package com.google.sps.data;

public final class Task {

  private final String name;
  private final long location;
  private final String item;
  private final long number;

  public Task(String name, long location, String item, long number) {
    this.name = name;
    this.location = location;
    this.item = item;
    this.number = number;
  }
}