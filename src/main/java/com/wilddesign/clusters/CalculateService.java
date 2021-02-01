package com.wilddesign.clusters;


import com.wilddesign.clusters.ChemicalBond;

// gets a set of bonds and calculates their stats

public interface CalculateService {
//  public abstract Boolean checkAtomType (String atom, String desiredAtom);
//  public abstract Double extractLength (ChemicalBond chemicalBond);
  public abstract Double[] extractLengths (Iterable<ChemicalBond> chemicalBonds);
//  public abstract Double[] extractLengthsByAtomType (Iterable<ChemicalBond> chemicalBonds);
  public abstract Double calculateMean (Double[] chemicalBondLengths);
  public abstract Double calculateStdDev (Double[] chemicalBondLengths);
}
