package com.wilddesign.clusters;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class ChemicalBond {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  private String symbol1;
  private String symbol2;
  private Double length;
  private String type1;
  private String type2;

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

  public String getType1() {
    return type1;
  }

  public void setType1(String type1) {
    this.type1 = type1;
  }

  public String getType2() {
    return type2;
  }

  public void setType2(String type2) {
    this.type2 = type2;
  }

  public String getAnotherSymbol(String symbol){
    if (this.symbol1 == symbol) {
        return this.symbol2;
    } else {
        return this.symbol1;
    }
  }

}
