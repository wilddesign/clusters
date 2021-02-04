package com.wilddesign.clusters;

import org.springframework.data.repository.CrudRepository;

import com.wilddesign.clusters.ChemicalBond;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ChemicalBondRepository extends CrudRepository<ChemicalBond, Integer> {

  Iterable<ChemicalBond> findBySymbol1OrSymbol2(String s1, String s2);
  Iterable<ChemicalBond> findByType1OrType2(String s1, String s2);
  Iterable<ChemicalBond> findBySymbol1AndSymbol2Not(String s1, String s2);
  Iterable<ChemicalBond> findBySymbol2AndSymbol1Not(String s1, String s2);

  Iterable<ChemicalBond> findBySymbol1AndSymbol2(String s1, String s2);
  Iterable<ChemicalBond> findBySymbol2AndSymbol1(String s1, String s2);

  Iterable<ChemicalBond> findAllById(Integer id);

}
