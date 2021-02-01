package com.wilddesign.clusters;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class ChemicalBondSphere {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  private String symbol1;
  private String symbol2;
  private Double length;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getSymbol1() {
    return symbol1;
  }

  public void setSymbol1(String symbol1) {
    this.symbol1 = symbol1;
  }

  public String getSymbol2() {
    return symbol2;
  }

  public void setSymbol2(String symbol2) {
    this.symbol2 = symbol2;
  }

  public Double getLength() {
    return length;
  }

  public void setLength(String length) {
    this.length = Double.parseDouble(length);
  }

}
