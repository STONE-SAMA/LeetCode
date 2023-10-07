package mid;

import java.util.*;

public class leetcode1333 {
    /**
     * 餐厅过滤器
     * https://leetcode.cn/problems/filter-restaurants-by-vegan-friendly-price-and-distance
     *
     * @param restaurants
     * @param veganFriendly
     * @param maxPrice
     * @param maxDistance
     * @return
     */
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<int[]> lists = new ArrayList<>();
        for (int[] arr : restaurants) {
            if (veganFriendly == 1) {
                //只能素菜
                if (arr[2] == 1 && arr[3] <= maxPrice && arr[4] <= maxDistance) {
                    lists.add(arr);
                }
            } else {
                if (arr[3] <= maxPrice && arr[4] <= maxDistance) {
                    lists.add(arr);
                }
            }
        }
        Collections.sort(lists, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o2[0] - o1[0];
                } else {
                    return o2[1] - o1[1];
                }
            }
        });
        List<Integer> res = new ArrayList<>();
        for (int[] arr : lists) {
            res.add(arr[0]);
        }
        return res;
    }

    public static void main(String[] args) {
        leetcode1333 l = new leetcode1333();
        int[][] restaurants = {{1,4,1,40,10},{2,8,0,50,5},{3,8,1,30,4},{4,10,0,10,3},{5,1,1,15,1}};
        int veganFriendly = 1;
        int maxPrice = 50;
        int maxDistance = 10;
        List<Integer> list = l.filterRestaurants(restaurants, veganFriendly, maxPrice, maxDistance);
        for (int i:list){
            System.out.printf(i+" ");
        }
    }
}
