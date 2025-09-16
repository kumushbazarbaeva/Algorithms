import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); 
        int[][] graph = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                graph[i][j] = sc.nextInt();

        int start = sc.nextInt() - 1;
        int end = sc.nextInt() - 1;

        int[] dist = new int[n]; 
        int[] parent = new int[n];
        Arrays.fill(dist, -1); 
        Arrays.fill(parent, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int u = 0; u < n; u++) {
                if (graph[v][u] == 1 && dist[u] == -1) {
                    dist[u] = dist[v] + 1;
                    parent[u] = v;
                    queue.add(u);
                }
            }
        }

        if (dist[end] == -1) {
            System.out.println(-1);
        } else {
            System.out.println(dist[end]);

            if (dist[end] > 0) {
                List<Integer> path = new ArrayList<>();
                for (int v = end; v != -1; v = parent[v])
                    path.add(v + 1);
                Collections.reverse(path);

                for (int v : path)
                    System.out.print(v + " ");
                System.out.println();
            }
        }
    }
}
