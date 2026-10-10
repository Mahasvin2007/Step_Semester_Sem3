public class BusiestBusRow {

    public static void busiestRow(int[][] grid) {
        int bestRow = 0;
        int maxTotal = 0;

        for (int i = 0; i < grid.length; i++) {
            int rowTotal = 0;

            for (int j = 0; j < grid[i].length; j++) {
                rowTotal += grid[i][j];
            }

            if (rowTotal > maxTotal) {
                maxTotal = rowTotal;
                bestRow = i;
            }
        }

        System.out.println("Row " + bestRow + ", Total " + maxTotal);
    }

    public static void main(String[] args) {
        int[][] grid = {
                {2, 0, 1},
                {3, 3, 1},
                {1, 1, 1}
        };

        busiestRow(grid);
    }
}
