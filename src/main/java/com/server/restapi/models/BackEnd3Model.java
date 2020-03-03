package com.server.restapi.models;

import java.io.*;
import java.time.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import org.springframework.core.io.ClassPathResource;

public class BackEnd3Model {
  private String nombre;
  private String planeta;
  private String dateTime;
  
  public boolean saveProfile(String nombre, String planeta) {
    this.nombre = nombre;
    this.planeta = planeta;
    this.dateTime = LocalDate.now().toString();
    boolean result = true;
    try {
    File resource = new ClassPathResource("repositoryData/BackEnd3Data.dat").getFile();
    String pathFile = resource.toPath().toString();
    
    BufferedWriter writer = new BufferedWriter(new FileWriter(pathFile, true));
    String str = "Rebel: " + this.nombre + " on " + this.planeta + " at " + this.dateTime + "\n";
    writer.append(str);
    writer.close();

    } catch (IOException e) {
      e.printStackTrace();
      result = false;
    }
    return result;
  }

  public List<String> getProfiles () {
    List<String> response = new ArrayList<String>();
    try {
      File resource = new ClassPathResource("repositoryData/BackEnd3Data.dat").getFile();
      String pathFile = resource.toPath().toString();
      
      Stream<String> stream = Files.lines(Paths.get(pathFile));
      stream.forEach((String item) -> { response.add(item); });

    } catch (IOException e) {
      e.printStackTrace(); 
    }
    return response;
  }
}