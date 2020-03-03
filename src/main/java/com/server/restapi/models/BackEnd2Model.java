package com.server.restapi.models;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class BackEnd2Model {
  private Long countDown;
  private LocalDateTime startTime;
  private LocalDateTime endTime;
  private LocalDateTime currentTime;
  public boolean running = false;

  public void start (Long number) {
    this.countDown = number;
    this.running = true;
    this.startTime = LocalDateTime.now();
    this.currentTime = LocalDateTime.now();
    this.endTime = startTime.plusSeconds(this.countDown);
  }
  public List<String> getSeconsRemainingList () {
    List<String> response = new ArrayList<String>();
    Long secondTotal = this.getSeconsRemaining();
    while (secondTotal >= 0) {
      response.add(secondTotal.toString());
      secondTotal--;
    }
    return response;
  }
  public Long getSeconsRemaining () {
    long response = 0;
    this.currentTime = LocalDateTime.now();
    long diff = ChronoUnit.SECONDS.between(this.currentTime, this.endTime);
    this.countDown = diff;
    if (this.countDown > -1) {
      response = this.countDown;
    } else {
      this.running = false;
      response = 0;
    }
    
    
    return response;
  }
}