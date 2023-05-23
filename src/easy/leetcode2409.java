package easy;

public class leetcode2409 {
    /*
    统计共同度过的日子数
    https://leetcode.cn/problems/count-days-spent-together/
     */
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {

        int a_arrive_m = Integer.parseInt(arriveAlice.substring(0, 2));
        int a_arrive_d = Integer.parseInt(arriveAlice.substring(3));
        int a_leave_m = Integer.parseInt(leaveAlice.substring(0, 2));
        int a_leave_d = Integer.parseInt(leaveAlice.substring(3));

        int b_arrive_m = Integer.parseInt(arriveBob.substring(0, 2));
        int b_arrive_d = Integer.parseInt(arriveBob.substring(3));
        int b_leave_m = Integer.parseInt(leaveBob.substring(0, 2));
        int b_leave_d = Integer.parseInt(leaveBob.substring(3));

        int arrive_late_m;
        int arrive_late_d;
        if (a_arrive_m > b_arrive_m) {
            arrive_late_m = a_arrive_m;
            arrive_late_d = a_arrive_d;
        } else if (b_arrive_m > a_arrive_m) {
            arrive_late_m = b_arrive_m;
            arrive_late_d = b_arrive_d;
        } else {
            arrive_late_m = a_arrive_m;
            if (a_arrive_d >= b_arrive_d) {
                arrive_late_d = a_arrive_d;
            } else {
                arrive_late_d = b_arrive_d;
            }
        }

        int leave_early_m;
        int leave_early_d;
        if (a_leave_m < b_leave_m) {
            leave_early_m = a_leave_m;
            leave_early_d = a_leave_d;
        } else if (b_leave_m < a_leave_m) {
            leave_early_m = b_leave_m;
            leave_early_d = b_leave_d;
        } else {
            leave_early_m = a_leave_m;
            if (a_leave_d <= b_leave_d) {
                leave_early_d = a_leave_d;
            } else {
                leave_early_d = b_leave_d;
            }
        }

        int arrive = count_month_day(arrive_late_m) + arrive_late_d;
        int leave = count_month_day(leave_early_m) + leave_early_d;

        if (leave >= arrive) {
            return leave - arrive + 1;
        } else {
            return 0;
        }

    }

    private int count_month_day(int mon) {
        int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int count = 0;
        for (int i = 0; i < mon - 1; i++) {
            count += month[i];
        }
        return count;
    }

    public static void main(String[] args) {
        leetcode2409 l = new leetcode2409();
        String arriveAlice = "08-15";
        String leaveAlice = "08-18";
        String arriveBob = "08-16";
        String leaveBob = "08-19";
        int res = l.countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob);
        System.out.println(res);
    }
}
