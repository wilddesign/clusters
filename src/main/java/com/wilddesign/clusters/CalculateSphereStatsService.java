package com.wilddesign.clusters;


import com.wilddesign.clusters.ChemicalBond;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

// gets a set of bonds and calculates their stats

@Service
public class CalculateSphereStatsService implements CalculateService {

//  @Override
//  public Boolean checkAtomType (String atom, String desiredAtom) {
//    return atom.equals(desiredAtom);
//  }

//  @Override
//  public Double extractLength (ChemicalBond chemicalBond){
//    return 1.0;
//  }

  @Override
  public Double[] extractLengths (Iterable<ChemicalBond> chemicalBonds){
    ArrayList<Double> res = new ArrayList<Double>();

    for(ChemicalBond chemicalBond: chemicalBonds) {
      res.add(chemicalBond.getLength());
    }
    Double[] result = new Double[res.size()];
    for (int i = 0; i < res.size(); i++){result[i] = res.get(i);}

    return result;
  }

//  @Override
//  public Double[] extractLengthsByAtomType (Iterable<ChemicalBond> chemicalBonds){
//    return new Double[]{1,2};
//  }

  @Override
  public Double calculateMean (Double[] chemicalBondLengths){
    Double sum = 0.0;
    Double leng = 0.0;
    for(Double chemicalBond: chemicalBondLengths) {
      leng += 1.0;
      sum += chemicalBond;
    }
    return sum/leng;
  }

  @Override
  public Double calculateStdDev (Double[] chemicalBondLengths){
    Double mean = this.calculateMean(chemicalBondLengths);
    Double varianceSum = 0.0;

    for(Double chemicalBondLength: chemicalBondLengths){
      varianceSum += Math.pow((chemicalBondLength-mean), 2);
    }

    return Math.sqrt(varianceSum/chemicalBondLengths.length);
  }
}
