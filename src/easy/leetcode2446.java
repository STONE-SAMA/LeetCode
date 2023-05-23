package easy;

public class leetcode2446 {
    /*
    判断两个事件是否存在冲突
    https://leetcode.cn/problems/determine-if-two-events-have-conflict/
     */
    public boolean haveConflict(String[] event1, String[] event2) {

        int start_event1 = formateTime(event1[0]);
        int end_event1 = formateTime(event1[1]);
        int start_event2 = formateTime(event2[0]);
        int end_event2 = formateTime(event2[1]);

        if (end_event1==start_event2){
            return true;
        } else if (start_event2<end_event1&&end_event1<end_event2) {
            return true;
        } else if (start_event2<start_event1&&end_event2>end_event1) {
            return true;
        } else if (start_event1<end_event2&&end_event1>end_event2) {
            return true;
        } else if (start_event1==end_event2) {
            return true;
        }
        return false;
    }

    private int formateTime(String str) {

        int h = Integer.parseInt(str.substring(0, 2));
        int m = Integer.parseInt(str.substring(3));

        return h * 60 + m;
    }
}
