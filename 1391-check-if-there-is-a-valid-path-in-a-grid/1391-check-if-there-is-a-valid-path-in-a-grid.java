import java.util.*;

class Solution {

    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        // Street type → allowed directions
        Map<Integer, int[][]> map = new HashMap<>();

        map.put(1, new int[][]{{0,-1},{0,1}});     // left, right
        map.put(2, new int[][]{{-1,0},{1,0}});     // up, down
        map.put(3, new int[][]{{0,-1},{1,0}});     // left, down
        map.put(4, new int[][]{{0,1},{1,0}});      // right, down
        map.put(5, new int[][]{{0,-1},{-1,0}});    // left, up
        map.put(6, new int[][]{{0,1},{-1,0}});     // right, up

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0,0});
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            if(r == m-1 && c == n-1) return true;

            for(int[] d : map.get(grid[r][c])) {
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr < 0 || nc < 0 || nr >= m || nc >= n || visited[nr][nc])
                    continue;

                // Check reverse connection
                for(int[] back : map.get(grid[nr][nc])) {
                    if(nr + back[0] == r && nc + back[1] == c) {
                        visited[nr][nc] = true;
                        q.offer(new int[]{nr,nc});
                    }
                }
            }
        }

        return false;
    }
}