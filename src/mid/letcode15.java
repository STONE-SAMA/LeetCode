package mid;

import java.util.*;

public class letcode15 {
    /*
    三数之和
    https://leetcode.cn/problems/3sum/
     */

    public List<List<Integer>> threeSum(int[] nums) {

//        Arrays.sort(nums);
//        List<List<Integer>> res = new ArrayList<>();
//        for(int k = 0; k < nums.length - 2; k++){
//            if(nums[k] > 0) break;
//            if(k > 0 && nums[k] == nums[k - 1]) continue;
//            int i = k + 1, j = nums.length - 1;
//            while(i < j){
//                int sum = nums[k] + nums[i] + nums[j];
//                if(sum < 0){
//                    while(i < j && nums[i] == nums[++i]);
//                } else if (sum > 0) {
//                    while(i < j && nums[j] == nums[--j]);
//                } else {
//                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
//                    while(i < j && nums[i] == nums[++i]);
//                    while(i < j && nums[j] == nums[--j]);
//                }
//            }
//        }
//        return res;


        int[] arr = nums;

        Arrays.sort(arr);

        List<List<Integer>> arrayList = new ArrayList<>();
        int count = 0;//0的数量

        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;
            if (arr[i]==0){
                count++;
            }
            if (count>2){
                List<Integer> integerList = new ArrayList<>();
                integerList.add(0);
                integerList.add(0);
                integerList.add(0);
                boolean flag = true;
                for (List<Integer> list : arrayList) {
                    if (list.equals(integerList)) {
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    arrayList.add(integerList);
                }
                break;
            }
            while (left < right) {
                if (arr[right]<0){
                    break;
                }
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == 0) {
                    int a = arr[i];
                    int b = arr[left];
                    int c = arr[right];
                    boolean flag = true;
                    for (List<Integer> list : arrayList) {
                        if (list.contains(a) && list.contains(b) && list.contains(c)) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        List<Integer> tempList = new ArrayList<>();
                        tempList.add(arr[i]);
                        tempList.add(arr[left]);
                        tempList.add(arr[right]);
                        arrayList.add(tempList);
                    }

                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
//        if (count>2){
//            List<Integer> integerList = new ArrayList<>();
//            integerList.add(0);
//            integerList.add(0);
//            integerList.add(0);
//            boolean flag = true;
//            for (List<Integer> list : arrayList) {
//                if (list.equals(integerList)) {
//                    flag = false;
//                    break;
//                }
//            }
//            if (flag){
//                arrayList.add(integerList);
//            }
//
//        }

        return arrayList;
    }

    private boolean compare(int a, int b, int c, Map<Integer, Map<Integer, List<Integer>>> map) {
        // 判断是否有重复解答,有重复返回true
        // abc是从小到大排列的
        if (map.containsKey(a)) {
            Map<Integer, List<Integer>> temp_map = map.get(a);
            if (temp_map.containsValue(b)) {
                List<Integer> temp_list = temp_map.get(b);
                if (temp_list.contains(c)) {
                    return true;
                } else {
                    temp_list.add(c);
                    temp_map.put(b, temp_list);
                    map.put(a, temp_map);
                    return false;
                }
            } else {
                List<Integer> temp_list = new ArrayList<>();
                temp_list.add(c);
                temp_map.put(b, temp_list);
                map.put(a, temp_map);
                return false;
            }
        } else {
            List<Integer> temp_list = new ArrayList<>();
            temp_list.add(c);
            Map<Integer, List<Integer>> temp_map = new HashMap<>();
            temp_map.put(b, temp_list);
            map.put(a, temp_map);
            return false;
        }
    }


    public static void main(String[] args) {
        letcode15 l = new letcode15();
        List<List<Integer>> res = new ArrayList<>();
//        res = l.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
//        res = l.threeSum(new int[]{-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0});
        res = l.threeSum(new int[]{4, 4, 3, -5, 0, 0, 0, -2, 3, -5, -5, 0});
        System.out.println(res);
    }
}
