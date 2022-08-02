class Node {

  int row;
  int column;
  int value;

  public Node(int v, int r, int c) {
    this.value = v;
    this.row = r;
    this.column = c;
  }

  public int getValue() {
    return this.value;
  }

  public int getRow() {
    return this.row;
  }

  public int getColumn() {
    return this.column;
  }
}

class NodeComparator implements Comparator<Node> {
  public int compare(Node x, Node y) {
    return x.value - y.value;
  }
}

class Solution {

  public int kthSmallest(int[][] matrix, int k) {

    int N = matrix.length;

    PriorityQueue<Node> minHeap =
        new PriorityQueue<Node>(Math.min(N, k), new NodeComparator());

    for (int r = 0; r < Math.min(N, k); r++) {

      minHeap.offer(new Node(matrix[r][0], r, 0));
    }

    Node element = minHeap.peek();
    while (k> 0) {
        k--;
        element = minHeap.poll();
        int r = element.getRow(), c = element.getColumn();

        if (c < N - 1) {
            minHeap.offer(new Node(matrix[r][c + 1], r, c + 1));
        }
    }
    return element.getValue();
  }
}