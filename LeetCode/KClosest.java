//https://leetcode.com/problems/k-closest-points-to-origin/
class KClosest {
    public int[][] kClosest(int[][] points, int K) {
        int length = points.length;
        PriorityQueue<Point> queue = new PriorityQueue<Point>(length, distanceComparator);
        int[][] res = new int[K][2];
        for (int i=0; i<length; i++) {
            int[] point = points[i];
            double distance = Math.sqrt(point[0]*point[0] + point[1]*point[1]);
            queue.add(new Point(distance, point));
        }
        int i=0;
        while (K != 0) {
            Point node = queue.remove();
            res[i] = node.point;
            K--; i++;
        }
        return res;
    }
    public static Comparator<Point> distanceComparator = new Comparator<Point>() {		
		@Override
		public int compare(Point c1, Point c2) {
            if (c1.distance == c2.distance) {
                return 0;
            }
            else if (c1.distance < c2.distance){
                return -1;
            }
            else {
                return 1;
            }
        }
	};
}
class Point {
    double distance;
    int[] point;
    public Point(double distance, int[] point) {
        this.distance = distance;
        this.point = point;
    }
}
