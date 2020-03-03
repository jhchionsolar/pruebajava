package com.server.restapi.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.server.restapi.models.BackEnd1Model;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;

@Controller
public class BackEnd1Controller {
  private BackEnd1Model backEnd1Model = new BackEnd1Model();

  @GetMapping("/BackEnd1")
  public String getIndex(Model model) {
    model.addAttribute("currentPath", "BackEnd1");
		return "backEnd1Index";
  }
  @GetMapping("/BackEnd1/getlist")
  public String getSecuence(@RequestParam(value="number") String number, Model model) {
    String returnTemplate;
    try {
      model.addAttribute("secuence", backEnd1Model.getSecuence(Long.parseLong(number)));
      returnTemplate = "backEnd1Number";
    } catch(Exception e) {
      model.addAttribute("errorMessage", e.getMessage());
      returnTemplate = "backErrorView";
    }
    return returnTemplate;
  }
}