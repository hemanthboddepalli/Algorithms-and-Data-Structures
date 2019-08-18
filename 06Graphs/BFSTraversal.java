class BFSTraversal {

  //Breadth First Traversal of Graph g from source vertex 
  public static String bfsTraversal(Graph g, int source) {
    String result = "";
    int num_of_vertices = g.vertices;
    int[] visited = new int[num_of_vertices];
    Queue<Integer> queue = new Queue<Integer>(num_of_vertices);
    queue.enqueue(source);
    while (!queue.isEmpty()) {
      int v = queue.dequeue();
      result = result + v;
      visited[v] = 1;
      DoublyLinkedList<Integer>.Node temp = g.adjacencyList[v].getHeadNode();
      while (temp != null)
      {
        v = temp.data;
        if (visited[v] == 0) {
          queue.enqueue(v);
        }
        temp = temp.nextNode;
      }
    }
    // Write - Your - Code
    return result; //For the above graph, it should return "01234" or "02143"
  }

}
