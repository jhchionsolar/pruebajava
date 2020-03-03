package com.server.restapi.servicecontrollers;

import java.util.List;

import com.server.restapi.models.BackEnd2Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class BackEnd2ControllerService {
  private BackEnd2Model backEnd2Model = new BackEnd2Model();
  
  @GetMapping("/api/BackEnd2/start")
  public String getCountDownIndex(@RequestParam("countDownValue") String countDownValue) {
    
    String responseTemplate = "Cuenta Iniciada";
    try{
      if(!backEnd2Model.running){
        backEnd2Model.start(Long.parseLong(countDownValue));
      } else {
        responseTemplate = "Cuanta atrás iniciada.";
      }
    }catch(Exception e) {
      responseTemplate = "backErrorView";
    }
    return responseTemplate;
  }
  @GetMapping("/api/BackEnd2/getRemaining")
  public Long getSeconsRemaining() {
    return backEnd2Model.getSeconsRemaining();
  }
  
  @GetMapping("/api/BackEnd2/getRemainingList")
  public List<String> getSeconsRemainingList() {
    return backEnd2Model.getSeconsRemainingList();
  }
}