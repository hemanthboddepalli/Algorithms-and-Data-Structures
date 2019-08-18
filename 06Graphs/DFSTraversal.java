class DFSTraversal {

  //Depth First Traversal of Graph g from source vertex  
  public static String dfsTraversal(Graph g, int source) {
    String result = "";
    int num_of_vertices = g.vertices;
    int[] visited = new int[num_of_vertices];
    Stack<Integer> stack = new Stack<Integer>(num_of_vertices);
    stack.push(source);
    while (!stack.isEmpty()) {
      int v = stack.pop();
      result = result + v;
      visited[v] = 1;
      DoublyLinkedList<Integer>.Node temp = g.adjacencyList[v].getHeadNode();
      while (temp != null)
      {
        v = temp.data;
        if (visited[v] == 0) {
          stack.push(v);
        }
        temp = temp.nextNode;
      }
    }
    // Write - Your - Code
    return result; //For the above graph, it should return "01342" or "02143"
  }
}
