package com.wilddesign.clusters;

import org.springframework.stereotype.Component;
import com.google.common.collect.Iterables;
import java.util.Queue;
import java.util.LinkedList;

@Component
public class DatabaseGraph {
  private Boolean adjacencyMatrix[][];
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
        if ((at1 == foundAt1 || at1 == foundAt2) || (at2 == foundAt1 || at2 == foundAt2)) {
          this.adjacencyMatrix[index][index2] = true;
          this.adjacencyMatrix[index2][index] = true;
        }
      }
    }
  }

  public Integer[] findDijkstraPath (startId, endId, firstEntryId) {
    //initialize distance vector
    Integer localStartId = startId - firstEntryId;
    Integer localEndId = endId - firstEntryId;

    Integer[] distanceMatrix = new Integer[this.numberOfVertices];
    Integer[] predecessorMatrix = new Integer[this.numberOfVertices]; //initialized with false
    // distance tfro startId to endId is 0
    distanceMatrix[localStartId] = 0;
    predecessorMatrix[localStartId] = null;
    // initialize Queue
    Queue<Integer> q = new LinkedList<>();
    // perform BFS search of the graph
    q.add(localStartId);
    Integer distanceCounter = 1;
    Integer currentIndex = localStartId;
    do {
      //for each index connected to start in the queue, set its distance as distance counter, set

      for (int i=0; i<this.numberOfVertices; i++ ){
        if (this.adjacencyMatrix[currentIndex][i]){
          if(i != currentIndex){
            distanceMatrix[i] = distanceCounter;
            predecessorMatrix[i] = currentIndex;
            q.add(i);
          }
        }
      }
      currentIndex = q.remove();
      // their predecessor as startId adn put them to the queue
      distanceCounter++;
    } while (q.isEmpty() != true;)
    // read and return an array of indices on the path
  }
}
