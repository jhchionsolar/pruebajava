package com.server.restapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import com.server.restapi.models.BackEnd2Model;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;

@Controller
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class BackEnd2Controller {
  private BackEnd2Model backEnd2Model = new BackEnd2Model();
  @GetMapping("/BackEnd2")
  public String getIndex(Model model) {
    // model.addAttribute("numberList", numberList);
    return "backEnd2Index";
  }
  @GetMapping("/BackEnd2/start")
  public String getCountDownIndex(@RequestParam("countDownValue") String countDownValue, Model model) {
    // model.addAttribute("numberList", numberList);
    String responseTemplate = "backEnd2CountDownView";
    try{
      if(!backEnd2Model.running){ 
        backEnd2Model.start(Long.parseLong(countDownValue)); }
      model.addAttribute("initialCountDown", "quedan: " + backEnd2Model.getSeconsRemaining().toString() + "s");
    }catch(Exception e) {
      model.addAttribute("errorMessage", countDownValue);
      responseTemplate = "backErrorView";
    }
    return responseTemplate;
  }

  @GetMapping("/BackEnd2/getRemaining")
  public Long getSeconsRemaining() {
    return backEnd2Model.getSeconsRemaining();
  }
}