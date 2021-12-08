import java.util.Random;

public class driver {
    public static void main(String[] args) {
        BFS A = new BFS();

        int mat[][] = { { 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 } };

        System.out.print(A.countIslands(mat));
        // Create a graph given in the above diagram
        DFS a= new DFS(1000);




           // Random rand= new Random();


     /*
            DFS b = new DFS(2000);
            DFS c = new DFS(5000);
            DFS d = new DFS(10000);
            DFS e = new DFS(1000);
            DFS f = new DFS(2000);
            DFS g = new DFS(5000);
            DFS h = new DFS(10000);
            DFS i = new DFS(1000);
            DFS j = new DFS(2000);
*/

        System.out.println(
                "Following are connected components");
            a.connectedComponents();


    }
}
