class CheckCycle {
    public static boolean detectCycle(Graph g){
        int num_of_vertices = g.vertices;
        int[] visited = new int[num_of_vertices];
        Queue<Integer> queue = new Queue<Integer>(num_of_vertices);
        queue.enqueue(0);
        while (!queue.isEmpty()) {
            int v = queue.dequeue();
            visited[v] = 1;
            DoublyLinkedList<Integer>.Node temp = g.adjacencyList[v].getHeadNode();
            while (temp != null)
            {
                v = temp.data;
                if (visited[v] == 0) {
                    queue.enqueue(v);
                }
                else {
                    return true;
                }
                temp = temp.nextNode;
            }
        }
        return false;
    }

}
