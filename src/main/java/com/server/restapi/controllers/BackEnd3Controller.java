package com.server.restapi.controllers;

import com.server.restapi.models.BackEnd3Model;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BackEnd3Controller {
  private BackEnd3Model backEnd3Model = new BackEnd3Model();
  @GetMapping("/BackEnd3")
  public String getIndex(Model model) {
    model.addAttribute("viewList", "Ver listado");
    model.addAttribute("getList", "Obtener listado");
    return "backEnd3Index";
  }
  
  @GetMapping("/BackEnd3/viewList")
  public String getList(Model model) {
    model.addAttribute("itemsProfiles", backEnd3Model.getProfiles());
    return "backEnd3ViewList";
  }
  // @GetMapping("/BackEnd3/downloadList")
  // public ResponseEntity<ByteArrayResource> downloadList(Model model) {
  //   // model.addAttribute("itemsProfiles", backEnd3Model.downloadList());
  //   // return "backEnd3ViewList";
  //   return backEnd3Model.downloadFile();
  // }

  @PostMapping("/BackEnd3/Register")
  public String setRegister(@RequestParam("nombre") String nombre, @RequestParam("planeta") String planeta, Model model) {
    String resultRedirect = (backEnd3Model.saveProfile(nombre, planeta) ? "backEnd3Registrado" : "backEnd3Error");
    model.addAttribute("textResult", "Usuario Registrado");
    return resultRedirect;
  }
}