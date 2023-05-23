import java.util.*;

public class letcode2363 {
    /*
    https://leetcode.cn/problems/merge-similar-items/
    https://leetcode.cn/problems/merge-similar-items/
     */
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {

        Map<Integer,Integer> map = new HashMap<>();

        for (int i=0;i< items1.length;i++){
            if (map.containsKey(items1[i][0])){
                int temp = map.get(items1[i][0]);
                map.put(items1[i][0],temp+items1[i][1]);
            }else {
                map.put(items1[i][0],items1[i][1]);
            }
        }

        for (int i=0;i< items2.length;i++){
            if (map.containsKey(items2[i][0])){
                int temp = map.get(items2[i][0]);
                map.put(items2[i][0],temp+items2[i][1]);
            }else {
                map.put(items2[i][0],items2[i][1]);
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        for (Map.Entry<Integer,Integer> entry: map.entrySet()){
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(entry.getKey());
            arrayList.add(entry.getValue());
            res.add(arrayList);
        }

        res.sort(Comparator.comparingInt(o->o.get(0)));

        return res;
    }

//    private void sort(int[][] arr) {
//        Arrays.sort(arr, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if (o1[0] == o2[0]) {
//                    return o1[1] - o2[1];
//                }
//                return o1[0] - o2[0];
//            }
//        });
//    }


    public static void main(String[] args) {
        letcode2363 l = new letcode2363();
        int[][] items1 = {{1, 1}, {4, 5}, {3, 8}};
        int[][] items2 = {{3, 1}, {1, 5}};
        l.mergeSimilarItems(items1, items2);
    }
}
