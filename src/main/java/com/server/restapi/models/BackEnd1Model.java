package com.server.restapi.models;

import java.util.*;

public class BackEnd1Model {
  public List<String> getSecuence (Long number) {
    int maxLimit = 20;
    List<String> ls = new ArrayList<String>();
    while(ls.size() < maxLimit) {
      String valueToInsert = number.toString();
      String multiple = "";
      if (number%3 == 0) { multiple += "fizz"; }
      if (number%5 == 0) { multiple += "buzz"; }

      if (multiple.length()>0) {
        valueToInsert = multiple;
      }
      ls.add(valueToInsert);
      number++;
    }
    return ls;
  }
}