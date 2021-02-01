package com.wilddesign.clusters;

import org.springframework.stereotype.Component;


@Component
public class CalculateSphereStatsResultComponent {
  public Double mean;
  public Double stdDev;

  CalculateSphereStatsResultComponent (){}

  CalculateSphereStatsResultComponent (Double mean, Double stdDev){
    this.mean = mean;
    this.stdDev = stdDev;
  }
}
