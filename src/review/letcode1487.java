package review;

import java.util.*;

public class letcode1487 {
    /*
    保证文件名唯一
    https://leetcode.cn/problems/making-file-names-unique/
     */
    public String[] getFolderNames(String[] names) {

        String[] res = new String[names.length];
        Map<String, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < names.length; i++) {
            String[] splits = names[i].split("\\(");
            //最后一个括号的数字
            int num = 0;
            if (splits.length > 1) {
                num = Character.getNumericValue(splits[splits.length - 1].charAt(0));
                if (num == 0) {
                    res[i] = names[i];
                    continue;
                }
            }
            //获得最后一个括号前的文件名
            String name = splits[0];
            if (splits.length > 2) {
                for (int j = 1; j < splits.length - 1; j++) {
                    name += "(" + splits[j];
                }
            }
            if (!map.containsKey(names[i])) {
                // 当前未重复，直接加入
                map.put(names[i], new ArrayList<>(num));

                if (map.containsKey(name)) {
                    List<Integer> integerList = map.get(name);
                    integerList.add(num);
                    map.put(name, integerList);
                } else {
                    map.put(name, new ArrayList<>(0));
                }

                res[i] = names[i];
            } else {
                //有重复
                List<Integer> list = map.get(names[i]);
                for (int j = 0; ; j++) {
                    if (!list.contains(j)) {
                        list.add(j);
                        if (j == 0) {
                            res[i] = names[i];
                            for (int a=0;a<i;a++){
                                if (res[a]==names[i]){
                                    res[i] = names[i] + "(1)";
                                    break;
                                }
                            }
                        } else {
                            res[i] = names[i] + "(" + j + ")";
                        }
                        break;
                    }
                }
                map.put(names[i], list);
                map.put(res[i], new ArrayList<>(0));
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        String[] str = {"gta", "gta(1)", "gta", "abc"};
//        String[] str = {"abc","abc(1)","abc","abc(1)"};
//        String[] str = {"abc(0)", "abc", "abc"};
        String[] str = {"abc", "abc(1)", "abc", "abc(1)"};
        letcode1487 l = new letcode1487();
        String[] res = l.getFolderNames(str);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }

//        String str = "abc";
//        String[] res = str.split("\\(");
//        String string = res[0];
//        int num = -1;
//        num = Character.getNumericValue(res[res.length-1].charAt(0));
//        if (res.length>2){
//            for (int i=1;i< res.length-1;i++){
//                string += "(" + res[i];
//            }
//        }
//        System.out.println(string);

    }
}
