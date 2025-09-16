import java.util.*;

public class Main {
    static int n;
    static int[][] graph;
    static boolean[] visited;
    static int[] parent;
    static List<Integer> cycle = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        graph = new int[n][n];
        visited = new boolean[n];
        parent = new int[n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                graph[i][j] = sc.nextInt();

        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (dfs(i, -1)) {
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
            System.out.println(cycle.size());
            for (int v : cycle)
                System.out.print((v + 1) + " ");
            System.out.println();
        }
    }

    static boolean dfs(int v, int par) {
        visited[v] = true;
        for (int u = 0; u < n; u++) {
            if (graph[v][u] == 1) {
                if (!visited[u]) {
                    parent[u] = v;
                    if (dfs(u, v))
                        return true;
                } else if (u != par) {
                    List<Integer> tempCycle = new ArrayList<>();
                    tempCycle.add(u);
                    int cur = v;
                    while (cur != u) {
                        tempCycle.add(cur);
                        cur = parent[cur];
                    }
                    Collections.reverse(tempCycle);
                    cycle = tempCycle;
                    return true;
                }
            }
        }
        return false;
    }
}
