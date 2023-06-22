package mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class leetcode16_19 {
    /**
     * 面试题 16.19. 水域大小
     * https://leetcode.cn/problems/pond-sizes-lcci/
     *
     * @param land
     * @return
     */
    int[][] land;
    public int[] pondSizes(int[][] land) {
        int height = land.length;
        int width = land[0].length;
        this.land = land;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (land[i][j] == 0) {
                    res.add(dfs(i,j));
                }
            }
        }
        Collections.sort(res);
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public int dfs(int i, int j) {
        int res = 1;
        land[i][j] = 1;
        for (int x = i - 1; x <= i + 1; ++x) {
            for (int y = j - 1; y <= j + 1; ++y) {
                if (x >= 0 && x < land.length && y >= 0 && y < land[0].length && land[x][y] == 0) {
                    res += dfs(x, y);
                }
            }
        }
        return res;
    }

}
