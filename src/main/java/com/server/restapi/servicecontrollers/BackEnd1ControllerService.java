package com.server.restapi.servicecontrollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.server.restapi.models.BackEnd1Model;

import java.util.*;


@RestController
public class BackEnd1ControllerService {
  private BackEnd1Model backEnd1Model = new BackEnd1Model();

  @GetMapping("/api/BackEnd1/getlist")
  public List<String> getSecuenceApi (@RequestParam(value="number") String number) {
    List<String> response = new ArrayList<String>();
    try {
      response = backEnd1Model.getSecuence(Long.parseLong(number));
    }catch(Exception e) {
      e.printStackTrace();
    }
    return response;
  }
}