package com.server.restapi.servicecontrollers;

import java.util.List;

import com.server.restapi.models.BackEnd3Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class BackEnd3ControllerService {
  private BackEnd3Model backEnd3Model = new BackEnd3Model();
  
  @GetMapping("/api/BackEnd3/viewList")
  public List<String> getList() {
    return backEnd3Model.getProfiles();
  }

  @GetMapping("/api/BackEnd3/Register")
  public List<String> setRegister(@RequestParam("nombre") String nombre, @RequestParam("planeta") String planeta) {
    String resultRedirect = (backEnd3Model.saveProfile(nombre, planeta) ? "Inserta" : "Error");
    return backEnd3Model.getProfiles();
  }
}