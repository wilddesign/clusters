package com.wilddesign.clusters;

import org.springframework.stereotype.Component;
import com.google.common.collect.Iterables;
import java.util.Queue;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

@Component
public class DatabaseGraph {
  private boolean adjacencyMatrix[][];
  public Integer numberOfVertices;

  DatabaseGraph (){}

  DatabaseGraph (Iterable<ChemicalBond> data){
    this.numberOfVertices = Iterables.size(data);
    this.adjacencyMatrix = new boolean[numberOfVertices][numberOfVertices];

    // first, to each atom a number schould be attached
    // until atoms are being assigned numbers,
    // in order to do so, we treat bonds as vertices and atoms as edges

    // fill in the adjacency matrix
    for (ChemicalBond entry: data){
      //add edge
      ChemicalBond firstElem = Iterables.getFirst(data, null);
      Integer norm = 0;
      if(firstElem != null) {
        norm = firstElem.getId(); // database generated ids are counted since the creation of the database, so it has to be normalized
      }

      String at1 = entry.getSymbol1();
      String at2 = entry.getSymbol2();
      Integer index = entry.getId() - norm;

      // take data.index and set true to all other data.indices
      // for which any of the atom symbols overlap
      for (ChemicalBond entry2: data){
        String foundAt1 = entry2.getSymbol1();
        String foundAt2 = entry2.getSymbol2();
        Integer index2 = entry2.getId() - norm; // database generated ids are counted since the creation of the database, so it has to be normalized

        if ((at1.equals(foundAt1) || at1.equals(foundAt2)) || (at2.equals(foundAt1) || at2.equals(foundAt2))) {
          this.adjacencyMatrix[index][index2] = true;
          this.adjacencyMatrix[index2][index] = true;
        }
      }
    }
  }


  public Integer[] findBFSPath (Integer startId, Integer endId, Integer firstEntryId) {


    //initialize distance vector
    Integer localStartId = startId - firstEntryId;
    Integer localEndId = endId - firstEntryId;

    Integer[] predecessorMatrix = new Integer[this.numberOfVertices]; //initialized with false

    Queue<Integer> q = new LinkedList<>();
    Integer currentIndex = localStartId;
    boolean[] visited = new boolean[this.numberOfVertices];
    // bfs init
    visited[currentIndex] = true;

    Integer formerIndex = null;
    // verticex that have been already queued
    boolean[] wasAlreadyQueued = new boolean[this.numberOfVertices];
    if(!wasAlreadyQueued[currentIndex]) {
      q.add(currentIndex);
      wasAlreadyQueued[currentIndex] = true;
    }
    // perform BFS of the database graph
    do {
      formerIndex = currentIndex;
      currentIndex = q.remove();
      visited[currentIndex] = true;

      for (int i=0; i<this.numberOfVertices; i++ ){
        if (this.adjacencyMatrix[currentIndex][i]){
          if(i != currentIndex && !visited[i]){
            predecessorMatrix[i] = currentIndex;
            if(!wasAlreadyQueued[i]) {
              q.add(i);
              wasAlreadyQueued[currentIndex] = true;
            }
          }
        }
      }
    } while (q.isEmpty() != true);

    //construct the results arraylist
    ArrayList<Integer> result = new ArrayList<>();
    Integer current = predecessorMatrix[localEndId];
    result.add(localEndId);
    do {
        result.add(current);
        current = predecessorMatrix[current];

    } while (current != localStartId);
    result.add(localStartId);
    //transform it into an array of fixed length
    Integer[] resArr = new Integer[result.size()];
    result.toArray(resArr);
    return resArr;
  }
}
