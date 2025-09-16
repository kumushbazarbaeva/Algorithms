import java.util.*;

public class Main {
    static char[][] grid;
    static boolean[][] visited;
    static int n;
    static int area = 0;

    static int[] dx = {-1, 1, 0, 0}; 
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        scanner.nextLine();

        grid = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            grid[i] = scanner.nextLine().toCharArray();
        }

        int startX = scanner.nextInt() - 1; 
        int startY = scanner.nextInt() - 1;

        dfs(startX, startY);
        System.out.println(area);
    }

    static void dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= n) return;
        if (grid[x][y] == '*' || visited[x][y]) return;

        visited[x][y] = true;
        area++;

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            dfs(nx, ny);
        }
    }
}
