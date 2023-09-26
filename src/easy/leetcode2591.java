package easy;

public class leetcode2591 {

    /**
     * 将钱分给最多的儿童
     * https://leetcode.cn/problems/distribute-money-to-maximum-children/
     *
     * @param money
     * @param children
     * @return
     */
    public int distMoney(int money, int children) {
        money = money - children;
        if (money <= 0) {
            return 0;
        }
        if (children * 7 < money) {
            return children - 1;
        }
        int temp = money / 7;
        int left = money % 7;
        if (left == 0) {
            return temp;
        }

        int left_person = children - temp;
        if (left_person == 1 && left == 3) {
            return temp - 1;
        }
        if (left_person == 0 && left != 0) {
            return temp - 1;
        }
        return temp;
    }
}
