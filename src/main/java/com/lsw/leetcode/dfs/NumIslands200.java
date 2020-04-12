package com.lsw.leetcode.dfs;

/**
 * 200岛的数量
 * 好像很经典的一个题目
 * <p>
 * 输入:
 * 1 1 0 0 0
 * 1 1 0 0 0
 * 0 0 1 0 0
 * 0 0 0 1 1
 * <p>
 * 输出: 3
 */
public class NumIslands200 {

    public static void main(String[] args) {
//        char[][] grid = new char[][]{
//                {'1', '1', '0', '0', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '1', '0', '0'},
//                {'0', '0', '0', '1', '1'}
//        };

        char[][] grid =new char[][] {
                {'1','1','1'},
                {'0','1','0'},
                {'1','1','1'}
        };
        int i = numIslands(grid);
        System.out.println("i = " + i);

    }

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * @param i
     * @param j
     * @param grid
     */
    public static void dfs(int i, int j, char[][] grid) {
        // 广度优先好像也可以
        // 搜索过的记为0 搜索四周所有为1的节点
//        Stack<Character> stack = new Stack<>();
//        stack.push(grid[i][j]);
//        grid[i][j] = '0';
        // 先尝试递归
        if (i < 0 || i > grid.length-1 || j < 0 || j > grid[0].length-1 || grid[i][j] == '0') {
            return;
        } else {
            grid[i][j] = '0';
            dfs(i - 1, j, grid);
            dfs(i + 1, j, grid);
            dfs(i, j + 1, grid);
            dfs(i, j - 1, grid);
        }
    }
}
